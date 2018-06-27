INSERT INTO QUESTION (QUESTION_CONTENT, DIFFICULTY, LIBRARY_ID)
	VALUES('What is the capital of Canada?', 1, 56);
	
	INSERT INTO ANSWER(ANSWER_CONTENT, IS_CORRECT, id)
		VALUES("Ottawa", true, SELECT id FROM QUESTION WHERE QUESTION_CONTENT = 'What is the capital of Canada?');
	INSERT INTO ANSWER(ANSWER_CONTENT, IS_CORRECT, id)
		VALUES("Toronto", false, SELECT id FROM QUESTION WHERE QUESTION_CONTENT = 'What is the capital of Canada?');
	INSERT INTO ANSWER(ANSWER_CONTENT, IS_CORRECT, id)
		VALUES("Montreal", false, SELECT id FROM QUESTION WHERE QUESTION_CONTENT = 'What is the capital of Canada?');
	INSERT INTO ANSWER(ANSWER_CONTENT, IS_CORRECT, id)
		VALUES("Vancouver", false, SELECT id FROM QUESTION WHERE QUESTION_CONTENT = 'What is the capital of Canada?');

INSERT INTO QUESTION (QUESTION_CONTENT, DIFFICULTY, LIBRARY_ID)
	VALUES('What is the capital of the USA?', 1, 56);
	
	INSERT INTO ANSWER(ANSWER_CONTENT, IS_CORRECT, id)
		VALUES("Washington", true, SELECT id FROM QUESTION WHERE QUESTION_CONTENT = 'What is the capital of the USA?');
	INSERT INTO ANSWER(ANSWER_CONTENT, IS_CORRECT, id)
		VALUES("New York", false, SELECT id FROM QUESTION WHERE QUESTION_CONTENT = 'What is the capital of the USA?');
	INSERT INTO ANSWER(ANSWER_CONTENT, IS_CORRECT, id)
		VALUES("Philadelphia", false, SELECT id FROM QUESTION WHERE QUESTION_CONTENT = 'What is the capital of the USA?');
	INSERT INTO ANSWER(ANSWER_CONTENT, IS_CORRECT, id)
		VALUES("Arlington", false, SELECT id FROM QUESTION WHERE QUESTION_CONTENT = 'What is the capital of the USA?');

INSERT INTO QUESTION (QUESTION_CONTENT, DIFFICULTY, LIBRARY_ID)
	VALUES('What is the capital of China?', 1, 56);
	
	INSERT INTO ANSWER(ANSWER_CONTENT, IS_CORRECT, id)
		VALUES("Beijing", true, SELECT id FROM QUESTION WHERE QUESTION_CONTENT = 'What is the capital of China?');
	INSERT INTO ANSWER(ANSWER_CONTENT, IS_CORRECT, id)
		VALUES("Shanghai", false, SELECT id FROM QUESTION WHERE QUESTION_CONTENT = 'What is the capital of China?');
	INSERT INTO ANSWER(ANSWER_CONTENT, IS_CORRECT, id)
		VALUES("Hong Kong", false, SELECT id FROM QUESTION WHERE QUESTION_CONTENT = 'What is the capital of China?');
	INSERT INTO ANSWER(ANSWER_CONTENT, IS_CORRECT, id)
		VALUES("Guangzhou", false, SELECT id FROM QUESTION WHERE QUESTION_CONTENT = 'What is the capital of China?');