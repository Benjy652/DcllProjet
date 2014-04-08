package quiz.exceptions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import quiz.parser.WikiReader;

public class NoParserInputExceptionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = NoParserInputException.class)  
	public void test() throws  NoParserInputException, WrongSyntaxException {
		WikiReader parseur = new WikiReader();
		parseur.getQuestion("");
	}

}
