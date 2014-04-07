package quiz.parser;

import org.junit.Test;

import junit.framework.TestCase;

public class TestWikiReader extends TestCase {

	@Test
	public void testCheckQuestionForm(){
		WikiReader parseur = new WikiReader();
		assertEquals(true, parseur.checkQuestionForm("{Ceci est la première question\n|type=\"[]\"}\n+The correct answer.\n- Distractor.\n- Distractor.\n- Distractor.\n\n{Ceci est la seconde question\n|type=\"()\"}\n+The correct answer.\n- Distractor.\n- Distractor.\n- Distractor.)"));
		
	}
	
	
	
}


