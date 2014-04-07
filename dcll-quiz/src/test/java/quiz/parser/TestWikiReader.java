package quiz.parser;

import org.junit.Test;

import quiz.Answer;
import quiz.AnswerBlock;
import quiz.QuestionType;
import quiz.impl.DefaultAnswer;
import quiz.impl.DefaultAnswerBlock;
import junit.framework.TestCase;

public class TestWikiReader extends TestCase {

	@Test
	public void testCheckQuestionForm(){
		WikiReader parseur = new WikiReader();
		assertEquals(true, parseur.checkQuestionForm("{Ceci est la première question\n|type=\"[]\"}\n+The correct answer.\n- Distractor.\n- Distractor.\n- Distractor.\n\n{Ceci est la seconde question\n|type=\"()\"}\n+The correct answer.\n- Distractor.\n- Distractor.\n- Distractor.)"));
		
	}
	
	@Test
	public void testGetQuestionType(){
		WikiReader parseur = new WikiReader();
		assertEquals(QuestionType.MultipleChoice, parseur.getQuestionType("{Ceci est la première question\n|type=\"[]\"}\n+The correct answer.\n- Distractor.\n- Distractor.\n- Distractor."));
		
	}
	
	@Test
	public void testnbGoodAnswers(){
		WikiReader parseur = new WikiReader();
		DefaultAnswer answer1 = new  DefaultAnswer();
		DefaultAnswer answer2 = new  DefaultAnswer();
		DefaultAnswer answer3 = new  DefaultAnswer();
		DefaultAnswer answer4 = new  DefaultAnswer();
		answer1.setPercentCredit(0.5f);
		answer1.setTextValue("question 1");
		answer2.setPercentCredit(0.f);
		answer2.setTextValue("question 2");
		answer3.setPercentCredit(0.5f);
		answer3.setTextValue("question 3");
		answer4.setPercentCredit(0.f);
		answer4.setTextValue("question 4");
		
		AnswerBlock answerList= new DefaultAnswerBlock();
		answerList.getAnswerList().add(answer1);
		answerList.getAnswerList().add(answer2);
		answerList.getAnswerList().add(answer3);
		answerList.getAnswerList().add(answer4);
		assertEquals(2, parseur.nbGoodAnswers(answerList));
		
		/*
		 * Ici on aurait pu faire un parcours efficace en 2 lignes,
		 * Seulement l'architecture sur laquelle nous sommme basé ne permet pas de modifier un  block de questio,
		 * en effet les block contiennent des reponse de type Answer, une interface ne proposant que des getters, un choix de sécurité mais pas optimal question code
		
		for(Answer parcours: answerList.getAnswerList()){
			parcours.
			
		}*/
		
		answer1 = new  DefaultAnswer();
		answer2 = new  DefaultAnswer();
		answer3 = new  DefaultAnswer();
		answer4 = new  DefaultAnswer();
		answer1.setPercentCredit(0.0f);
		answer1.setTextValue("question 1bis");
		answer2.setPercentCredit(0.f);
		answer2.setTextValue("question 2bis");
		answer3.setPercentCredit(0.0f);
		answer3.setTextValue("question 3bis");
		answer4.setPercentCredit(0.f);
		answer4.setTextValue("question 4bis");
		
		answerList= new DefaultAnswerBlock();
		answerList.getAnswerList().add(answer1);
		answerList.getAnswerList().add(answer2);
		answerList.getAnswerList().add(answer3);
		answerList.getAnswerList().add(answer4);
		assertEquals(0, parseur.nbGoodAnswers(answerList));
		
		
		
		
	}
	
	
	@Test
	public void testgetAnswerBlock(){
		WikiReader parseur = new WikiReader();
		DefaultAnswer answer1 = new  DefaultAnswer();
		DefaultAnswer answer2 = new  DefaultAnswer();
		DefaultAnswer answer3 = new  DefaultAnswer();
		DefaultAnswer answer4 = new  DefaultAnswer();
		answer1.setPercentCredit(1.f);
		answer1.setTextValue("The correct answer.");
		answer2.setPercentCredit(0.f);
		answer2.setTextValue("Distractor.");
		answer3.setPercentCredit(0.f);
		answer3.setTextValue("Distractor.");
		answer4.setPercentCredit(0.f);
		answer4.setTextValue("Distractor.");
		
		AnswerBlock answerList= new DefaultAnswerBlock();
		answerList.getAnswerList().add(answer1);
		answerList.getAnswerList().add(answer2);
		answerList.getAnswerList().add(answer3);
		answerList.getAnswerList().add(answer4);
		
		int i=0;
		for(Answer parcours : parseur.getAnswerBlock("{Ceci est la première question\n|type=\"[]\"}\n+The correct answer.\n-Distractor.\n-Distractor.\n-Distractor.\n").getAnswerList()){
				
			assertEquals(parcours.getTextValue(),answerList.getAnswerList().get(i).getTextValue());
			assertEquals(parcours.getPercentCredit(),answerList.getAnswerList().get(i).getPercentCredit());
			i++;
		}
		
	
	}
	
}


