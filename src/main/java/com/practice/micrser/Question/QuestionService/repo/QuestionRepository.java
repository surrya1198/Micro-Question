package com.practice.micrser.Question.QuestionService.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.micrser.Question.QuestionService.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>{
	
	List<Question> findByCategory(String category);

}
