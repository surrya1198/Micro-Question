package com.practice.micrser.Question.QuestionService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.micrser.Question.QuestionService.entity.Question;
import com.practice.micrser.Question.QuestionService.repo.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository repository;

	public Question addQuestion(Question question) {
		return repository.save(question);
	}

	public List<Question> getAllQuestions() {
		return repository.findAll();
	}

	public List<Question> getQuestionsByCategory(String category) {
		return repository.findByCategory(category);
	}

	public Question getQuestionById(Long id) {
		return repository.findById(id).orElseThrow();
	}

	public List<Question> saveListofQuestionDatabase(List<Question> questions) {

		return repository.saveAll(questions);

	}

	public List<Question> getRandomFiveQuestion() {
		List<Question> question = new ArrayList<>();
		Random random = new Random();
		for (int i = 1; i <= 5; i++) {
			Long j = random.nextLong(1, 20);
			question.add(repository.findById(j).get());
		}
		return question;
	}

	public List<Question> getFiveQuestion(List<Long> questionids) {
		List<Question> question = new ArrayList<>();
		for (Long questionid : questionids) {

			question.add(repository.findById(questionid).get());
		}
		return question;
	}

}
