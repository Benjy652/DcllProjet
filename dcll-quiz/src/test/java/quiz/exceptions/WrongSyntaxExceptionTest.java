package quiz.exceptions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import quiz.parser.WikiReader;

public class WrongSyntaxExceptionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = WrongSyntaxException.class)  
	public void testWrongSyntaxException() throws WrongSyntaxException, NoParserInputException {
		WikiReader parseur = new WikiReader();
		parseur.getQuestion("{Ceci est la première question\n|type=\"[]\"}\n-Distractor.\n-Distractor.\n-Distractor.\n-Distractor.\n");
		
	}

}
