package study.swagger_rest_docs.controller;

import static com.epages.restdocs.apispec.ResourceDocumentation.*;
import static org.mockito.BDDMockito.given;
import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static org.mockito.Mockito.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static com.epages.restdocs.apispec.ResourceDocumentation.resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;

import com.epages.restdocs.apispec.ResourceSnippet;
import com.epages.restdocs.apispec.ResourceSnippetParameters;
import com.epages.restdocs.apispec.ResourceSnippetParametersBuilder;

import study.swagger_rest_docs.controller.Controller;
import study.swagger_rest_docs.controller.Service;

@WebMvcTest(Controller.class)
@AutoConfigureRestDocs
class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private Service service;

	@Test
	void create() throws Exception {
		// given
		given(service.create()).willReturn("create");

		// when & then
		mockMvc.perform(RestDocumentationRequestBuilders.post("/api")
						.param("input", "some input"))
				.andDo(print())
				.andExpect(status().isOk())
				.andDo(document("create",
						preprocessRequest(prettyPrint()),
						preprocessResponse(prettyPrint()),
						resource(ResourceSnippetParameters.builder()
								.tag("생성 API")
								.summary("생성합시다.")
								.build()
						)
				));
	}

	@Test
	void read() throws Exception {
		given(service.read()).willReturn("read");

		mockMvc.perform(RestDocumentationRequestBuilders.get("/api"))
				.andDo(print())
				.andExpect(status().isOk())
				.andDo(document("read",
						preprocessRequest(prettyPrint()),
						preprocessResponse(prettyPrint()),
						resource(ResourceSnippetParameters.builder()
								.tag("조회 API")
								.summary("조회합시다.")
								.build()
						)
				));
	}

	@Test
	void update() throws Exception {
		given(service.update()).willReturn("update");

		mockMvc.perform(RestDocumentationRequestBuilders.put("/api"))
				.andDo(print())
				.andExpect(status().isOk())
				.andDo(document("update",
						preprocessRequest(prettyPrint()),
						preprocessResponse(prettyPrint()),
						resource(ResourceSnippetParameters.builder()
								.tag("수정 API")
								.summary("수정합시다.")
								.build()
						)
				));
	}

	@Test
	void delete() throws Exception {
		given(service.delete()).willReturn("delete");

		mockMvc.perform(RestDocumentationRequestBuilders.delete("/api"))
				.andDo(print())
				.andExpect(status().isOk())
				.andDo(document("delete",
						preprocessRequest(prettyPrint()),
						preprocessResponse(prettyPrint()),
						resource(ResourceSnippetParameters.builder()
								.tag("삭제 API")
								.summary("삭제합시다.")
								.build()
						)
				));
	}
}
