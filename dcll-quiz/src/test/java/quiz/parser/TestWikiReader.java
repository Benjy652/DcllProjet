package quiz.parser;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import quiz.Answer;
import quiz.AnswerBlock;
import quiz.QuestionType;
import quiz.exceptions.WrongSyntaxException;
import quiz.impl.DefaultAnswer;
import quiz.impl.DefaultAnswerBlock;
import quiz.impl.DefaultQuestion;
import junit.framework.TestCase;

public class TestWikiReader extends TestCase {

	
	@Test
	public void testgetQuestion(){
		WikiReader parseur = new WikiReader();
		
		
		DefaultQuestion questionQuiz = new DefaultQuestion();
		try {
			questionQuiz=parseur.getQuestion("{Ceci est la première question\n|type=\"[]\"}\n+The correct answer.\n-Distractor.\n-Distractor.\n-Distractor.\n");
		} catch (WrongSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(QuestionType.MultipleChoice,questionQuiz.getQuestionType());
		assertEquals("Ceci est la première question",questionQuiz.getTitle());
		
		ArrayList<String> answerList= new ArrayList<String>();
		answerList.add("The correct answer.");
		answerList.add("Distractor.");
		answerList.add("Distractor.");
		answerList.add("Distractor.");
		
		ArrayList<Float> answerListPercent= new ArrayList<Float>();
		answerListPercent.add(1.0f);
		answerListPercent.add(0.0f);
		answerListPercent.add(0.0f);
		answerListPercent.add(0.0f);
		
		int i=0;
		List<AnswerBlock> answerBlock = questionQuiz.getAnswerBlockList();
		for(AnswerBlock parcours : answerBlock){
			for(Answer parcoursAnswer : parcours.getAnswerList()){
				System.out.println(parcoursAnswer.getTextValue()+" "+answerList.get(i));
				assertEquals(answerList.get(i),parcoursAnswer.getTextValue());
				System.out.println(parcoursAnswer.getTextValue()+" "+answerList.get(i));
				assertEquals(answerListPercent.get(i),parcoursAnswer.getPercentCredit());
				i++;
				
			}
		}
	}
	
	
	@Test
	public void testcheckQuestionForm(){
		WikiReader parseur = new WikiReader();
		assertEquals(true, parseur.checkQuestionForm("{Ceci est la première question\n|type=\"[]\"}\n+The correct answer.\n- Distractor.\n- Distractor.\n- Distractor.\n\n{Ceci est la seconde question\n|type=\"()\"}\n+The correct answer.\n- Distractor.\n- Distractor.\n- Distractor.)"));
		
	}
	
	@Test
	public void testgetQuestionType(){
		WikiReader parseur = new WikiReader();
		assertEquals(QuestionType.MultipleChoice, parseur.getQuestionType("{Ceci est la première question\n|type=\"[]\"}\n+The correct answer.\n- Distractor.\n- Distractor.\n- Distractor."));
		
	}
	
	@Test
	public void testgetQuestionTitle(){
		WikiReader parseur = new WikiReader();
		assertEquals("Ceci est la première question", parseur.getQuestionTitle("{Ceci est la première question\n|type=\"[]\"}\n+The correct answer.\n- Distractor.\n- Distractor.\n- Distractor."));
		
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

		
		ArrayList<String> answerList= new ArrayList<String>();
		answerList.add("The correct answer.");
		answerList.add("Distractor.");
		answerList.add("Distractor.");
		answerList.add("Distractor.");
		
		ArrayList<Float> answerListPercent= new ArrayList<Float>();
		answerListPercent.add(1.0f);
		answerListPercent.add(0.0f);
		answerListPercent.add(0.0f);
		answerListPercent.add(0.0f);
		
		int i=0;
		for(Answer parcours : parseur.getAnswerBlock("{Ceci est la première question\n|type=\"[]\"}\n+The correct answer.\n-Distractor.\n-Distractor.\n-Distractor.\n").getAnswerList()){
				
			assertEquals(answerList.get(i),parcours.getTextValue());
			assertEquals(answerListPercent.get(i),parcours.getPercentCredit());
			i++;
		}
		
	
	}
	
}


