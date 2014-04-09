package quiz.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import quiz.Answer;

public class TestDefaultAnswerBlock {	

	@Test
	public void testGetAnswerList() {
		DefaultAnswerBlock answerBlock = new DefaultAnswerBlock();
		DefaultAnswer answer1 = new DefaultAnswer();
		answer1.setIdentifier("answer1");
		answer1.setPercentCredit(0.5f);
		answer1.setTextValue("text1");
	
		DefaultAnswer answer2 = new DefaultAnswer();
		answer2.setIdentifier("answer2");
		answer2.setPercentCredit(0.0f);
		answer2.setTextValue("text2");
		
		DefaultAnswer answer3 = new DefaultAnswer();
		answer3.setIdentifier("answer3");
		answer3.setPercentCredit(0.5f);
		answer3.setTextValue("text3");
		
		List<Answer> listeAnswers = new ArrayList<Answer>();
		listeAnswers.add(answer1);
		answerBlock.addAnswer(answer1);
		listeAnswers.add(answer2);
		answerBlock.addAnswer(answer2);
		listeAnswers.add(answer3);
		answerBlock.addAnswer(answer3);
		
		for(int i = 0; i < answerBlock.getAnswerList().size(); i ++) {
			assertTrue(answerBlock.getAnswerList().get(i).equals(listeAnswers.get(i)));
		}
		
	}

	@Test
	public void testAddAnswer() {
		DefaultAnswerBlock answerBlock = new DefaultAnswerBlock();
		DefaultAnswer answer1 = new DefaultAnswer();
		answer1.setIdentifier("answer1");
		answer1.setPercentCredit(0.5f);
		answer1.setTextValue("text1");
		
		DefaultAnswer answer2 = new DefaultAnswer();
		answer1.setIdentifier("answer2");
		answer1.setPercentCredit(0.5f);
		answer1.setTextValue("text2");

		assertTrue(answerBlock.getAnswerList().size() == 0);
		
		answerBlock.addAnswer(answer1);	
		assertTrue(answerBlock.getAnswerList().size() == 1);		
		assertTrue(answerBlock.getAnswerList().get(0).equals(answer1));
		
		answerBlock.addAnswer(answer2);	
		assertTrue(answerBlock.getAnswerList().size() == 2);
		assertTrue(answerBlock.getAnswerList().get(1).equals(answer2));
	}

}
