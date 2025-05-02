package study.swagger_rest_docs.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class Controller {

	private final Service service;

	@PostMapping()
	public ResponseEntity<String> create() {

		return ResponseEntity.ok(service.create());
	}
	@GetMapping()
	public ResponseEntity<String> read() {

		return ResponseEntity.ok(service.read());
	}

	@PutMapping
	public ResponseEntity<String> update() {

		return ResponseEntity.ok(service.update());
	}

	@DeleteMapping
	public ResponseEntity<String> delete() {

		return ResponseEntity.ok(service.delete());
	}




}
