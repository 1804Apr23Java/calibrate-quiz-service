package com.revature.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Answer;
import com.revature.beans.Question;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
	public Set<Answer> findByQuestion(Question q);
}
