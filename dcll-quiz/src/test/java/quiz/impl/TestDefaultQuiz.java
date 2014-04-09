package quiz.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDefaultQuiz {
	DefaultQuiz dquiz = new DefaultQuiz();


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
