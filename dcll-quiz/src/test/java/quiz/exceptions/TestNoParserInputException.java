package quiz.exceptions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import quiz.parser.WikiReader;

public class TestNoParserInputException {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = NoParserInputException.class)  
	public void testNoParserInputException() throws  NoParserInputException, WrongSyntaxException {
		WikiReader parseur = new WikiReader();
		parseur.getQuestion("");
	}

}
