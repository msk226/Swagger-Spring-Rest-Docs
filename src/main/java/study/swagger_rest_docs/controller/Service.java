package study.swagger_rest_docs.controller;

import org.springframework.stereotype.Component;

@Component
public class Service {

	public String create() {
		return "create";
	}

	public String read() {
		return "read";
	}

	public String update() {
		return "update";
	}

	public String delete() {
		return "delete";
	}


}
