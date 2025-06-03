package com.practice.micrser.Question.QuestionService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.micrser.Question.QuestionService.entity.Question;
import com.practice.micrser.Question.QuestionService.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	QuestionService service;

	@PostMapping
	public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
		return ResponseEntity.ok(service.addQuestion(question));
	}

	@GetMapping
	public ResponseEntity<List<Question>> getAll() {
		return ResponseEntity.ok(service.getAllQuestions());
	}

	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getByCategory(@PathVariable String category) {
		return ResponseEntity.ok(service.getQuestionsByCategory(category));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Question> getById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getQuestionById(id));
	}

	@PostMapping("/addallquestion")
	public ResponseEntity<List<Question>> addlistofQuestion(@RequestBody List<Question> question) {
		return ResponseEntity.ok(service.saveListofQuestionDatabase(question));
	}

	@GetMapping("/randomfivequestion")
	public ResponseEntity<List<Question>> getRandomFiveQuestion() {

		return ResponseEntity.ok(service.getRandomFiveQuestion());

	}

	@PostMapping("/fivequestion")

	public ResponseEntity<List<Question>> getRandomFiveQuestion(@RequestBody List<Long> questionids) {

		return ResponseEntity.ok(service.getFiveQuestion(questionids));

	}

}
