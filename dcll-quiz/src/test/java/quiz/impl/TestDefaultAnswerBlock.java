package quiz.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDefaultAnswerBlock {
	DefaultAnswerBlock dab = new DefaultAnswerBlock();
	DefaultAnswer da = new DefaultAnswer();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAnswerList() {
		dab.addAnswer(da);
		assertTrue(da.equals((dab.getAnswerList().get(0))));
	}

	@Test
	public void testAddAnswer() {
		dab.addAnswer(da);
		assertTrue(da.equals((dab.getAnswerList().get(0))));
	}

}
