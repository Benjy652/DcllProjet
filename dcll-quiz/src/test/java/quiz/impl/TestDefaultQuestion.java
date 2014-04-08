package quiz.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import quiz.QuestionType;

public class TestDefaultQuestion {
	DefaultQuestion dq = new DefaultQuestion();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetTitle() {
		String test = "test";
		dq.setTitle("test");
		assertTrue(dq.getTitle().equals(test));
	}

	@Test
	public void testGetQuestionType() {
		dq.setQuestionType(QuestionType.TrueFalse);
		assertEquals(dq.getQuestionType(),QuestionType.TrueFalse);
	}

	@Test
	public void testSetQuestionType() {		
		dq.setQuestionType(QuestionType.TrueFalse);
		assertEquals(dq.getQuestionType(),QuestionType.TrueFalse);
	}

	@Test
	public void testSetTitle() {
		String test = "test";
		dq.setTitle("test");
		assertTrue(dq.getTitle().equals(test));
	}

	@Test
	public void testGetBlockList() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddAnswerBlock() {
		DefaultAnswerBlock dab = new DefaultAnswerBlock();
		dq.addAnswerBlock(dab);
		assertTrue(dq.getAnswerBlockList().equals(dab));		
	}

	@Test
	public void testAddTextBlock() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAnswerBlockList() {
		DefaultAnswerBlock dab = new DefaultAnswerBlock();
		dq.addAnswerBlock(dab);
		assertTrue(dq.getAnswerBlockList().equals(dab));	
	}

	@Test
	public void testGetTextBlockList() {
		fail("Not yet implemented");
	}

}
