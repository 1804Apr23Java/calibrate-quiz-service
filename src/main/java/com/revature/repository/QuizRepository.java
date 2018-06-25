package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
