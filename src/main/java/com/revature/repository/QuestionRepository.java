package com.revature.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	public Set<Question> findBylibraryId(Integer libraryId);
}
