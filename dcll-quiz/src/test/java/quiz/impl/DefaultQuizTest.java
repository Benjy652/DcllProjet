package quiz.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DefaultQuizTest {
	DefaultQuiz dquiz = new DefaultQuiz();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddQuestion() {
		DefaultQuestion dques = new DefaultQuestion();
		dquiz.addQuestion(dques);
		assertTrue(dques.equals(dquiz.getQuestionList().get(0)));
	}

	@Test
	public void testGetQuestionList() {
		DefaultQuestion dques = new DefaultQuestion();
		dquiz.addQuestion(dques);
		assertTrue(dques.equals(dquiz.getQuestionList().get(0)));
	}

}
