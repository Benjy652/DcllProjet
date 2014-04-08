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
		DefaultAnswer da2 = new DefaultAnswer();
		assertTrue(da.hashCode()==da2.hashCode());	
	}

	@Test
	public void testEqualsObject() {
		Object da2 = new DefaultAnswer();
		System.out.println(da.equals(da2)==true);
		assertTrue(da.equals(da2));
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
