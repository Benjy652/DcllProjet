package quiz.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDefaultAnswer {
	DefaultAnswer da = new DefaultAnswer();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHashCode() {
		DefaultAnswer answer1 = new DefaultAnswer();
		answer1.setIdentifier("answer1");
		answer1.setPercentCredit(0.5f);
		answer1.setTextValue("text1");
	
		DefaultAnswer answer2 = new DefaultAnswer();
		answer2.setIdentifier("answer1");
		answer2.setPercentCredit(0.5f);
		answer2.setTextValue("text1");
		
		assertTrue(answer2.hashCode()==answer1.hashCode());	
	}

	@Test
	public void testEqualsObject() {
		DefaultAnswer answer1 = new DefaultAnswer();
		answer1.setIdentifier("answer1");
		answer1.setPercentCredit(0.5f);
		answer1.setTextValue("text1");
	
		DefaultAnswer answer2 = new DefaultAnswer();
		answer2.setIdentifier("answer1");
		answer2.setPercentCredit(0.5f);
		answer2.setTextValue("text1");
		
		DefaultAnswer answer3 = new DefaultAnswer();
		answer3.setIdentifier("answer2");
		answer3.setPercentCredit(0.5f);
		answer3.setTextValue("text3");
		
		assertTrue(answer1.equals(answer2));
		assertFalse(answer1.equals(answer3));
		
	}

	@Test
	public void testGetTextValue() {
		String test = "test";
		da.setTextValue("test");
		assertTrue(da.getTextValue().equals(test));
	}

	@Test
	public void testSetTextValue() {
		String test = "test";
		da.setTextValue("test");
		assertTrue(da.getTextValue().equals(test));
	}

	@Test
	public void testGetPercentCredit() {
		float test = 0.5f;
		da.setPercentCredit(test);;
		assertTrue(da.getPercentCredit().equals(test));	
	}

	@Test
	public void testSetPercentCredit() {
		float test = 0.5f;
		da.setPercentCredit(test);;
		assertTrue(da.getPercentCredit().equals(test));	
	}

	@Test
	public void testGetIdentifier() {
		String test = "01";
		da.setIdentifier(test);
		assertTrue(da.getIdentifier().equals(test));		
	}

	@Test
	public void testSetIdentifier() {
		String test = "01";
		da.setIdentifier(test);
		assertTrue(da.getIdentifier().equals(test));
	}

	@Test
	public void testSetFeedback() {
		String test = "fb";
		da.setFeedback(test);
		assertTrue(da.getFeedBack().equals(test));
	}

	@Test
	public void testGetFeedBack() {
		String test = "fb";
		da.setFeedback(test);
		assertTrue(da.getFeedBack().equals(test));
	}
	

}
