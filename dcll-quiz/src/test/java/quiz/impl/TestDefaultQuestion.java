package quiz.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import quiz.QuestionType;

public class TestDefaultQuestion {
	DefaultQuestion defQuestion = new DefaultQuestion();

	@Test
	public void testGetTitle() { 
		String test = "test";
		defQuestion.setTitle("test");
		assertTrue(defQuestion.getTitle().equals("test"));
	}

	@Test
	public void testGetQuestionType() {
		defQuestion.setQuestionType(QuestionType.TrueFalse);
		assertEquals(defQuestion.getQuestionType(),QuestionType.TrueFalse);
	}

	@Test
	public void testSetQuestionType() {		
		defQuestion.setQuestionType(QuestionType.TrueFalse);
		assertEquals(defQuestion.getQuestionType(),QuestionType.TrueFalse);
	}

	@Test
	public void testSetTitle() {
		String test = "test";
		defQuestion.setTitle("test");
		assertTrue(defQuestion.getTitle().equals("test"));
	}

	@Test
	public void testGetBlockList() {
		
	}

	@Test
	public void testAddAnswerBlock() {
		DefaultAnswerBlock dab = new DefaultAnswerBlock();
		defQuestion.addAnswerBlock(dab);
		assertTrue(defQuestion.getAnswerBlockList().equals(dab));		
	}

	@Test
	public void testAddTextBlock() {
		
	}

	@Test
	public void testGetAnswerBlockList() {
			
	}

	@Test
	public void testGetTextBlockList() {
		
	}

}
