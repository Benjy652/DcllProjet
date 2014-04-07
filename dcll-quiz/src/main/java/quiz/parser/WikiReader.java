package quiz.parser;

import java.util.regex.Pattern;

import quiz.Answer;
import quiz.AnswerBlock;
import quiz.QuestionType;
import quiz.Quiz;
import quiz.impl.DefaultAnswer;
import quiz.impl.DefaultAnswerBlock;
import quiz.impl.DefaultQuestion;
import quiz.impl.DefaultQuiz;

/**
 * 
 * @author Assyl
 *
 */

public class WikiReader implements QuizReader {
	
	/**
	 * This method take a quiz, in a text form, in entry and do all the necessary operations to check
	 * the questions forms and construct the objects	
	 * @param quiz
	 * @return a Quiz object 
	 */
	public Quiz getDefaultQuiz(String quiz){
		String[] questions = quiz.split("\\n\\n");
		DefaultQuiz defQuiz = new DefaultQuiz();
		
		for(int i = 0; i < questions.length; i++){
			if(checkQuestionForm(questions[i])){
				defQuiz.addQuestion(getQuestion(questions[i]));
			}
		}
		return defQuiz;
		
	}
	
	/**
	 * This method checks the form of the question 
	 * @param question
	 * @return true if the question respects wikiversity form, false otherwise
	 */
	public boolean checkQuestionForm(String question)
	{
		String regEx = "\\A\\{.+\\n\\|type=";
		regEx += "\"(\\[\\]|\\(\\))\"\\}\\n";
		regEx += "([\\+|\\-]+.+\\n){2,}";
		Pattern questionPattern = Pattern.compile(regEx);
		return questionPattern.matcher(question).find();
	}
	
	/**
	 * This method takes a question in a text form and construct the object
	 * @param question
	 * @return DefaultQuestion object
	 */
	private DefaultQuestion getQuestion(String question) 
	{
		DefaultQuestion questionObject = new DefaultQuestion();
		questionObject.setQuestionType(getQuestionType(question));
		questionObject.setTitle(getQuestionTitle(question));
		questionObject.addAnswerBlock(getAnswerBlock(question));
		int nbGdAnswers = nbGoodAnswers(questionObject.getAnswerBlockList().get(0));
		if(nbGdAnswers >= 1) {
			if((nbGdAnswers > 1) && (questionObject.getQuestionType() == QuestionType.ExclusiveChoice)){
				
			}
		}
		
		return questionObject;
	}

	/**
	 * This method gives, from the question in a wikiversity form, the question type
	 * @param question
	 * @return the type of the question (Multiple or Single)
	 */
	private QuestionType getQuestionType(String question) 
	{
		int index = question.indexOf('|');
		if(question.charAt(index+7) == '[') return QuestionType.MultipleChoice;
		else return QuestionType.ExclusiveChoice;
		
	}
	
	/**
	 * This method gives, from the question in a wikiversity form, the question title
	 * @param question
	 * @return the title of the question
	 */
	private String getQuestionTitle(String question) 
	{
		int index = question.indexOf('|');
		return question.substring(1,index-1);	
	}

	/**
	 * This method returns the number of good answers that are available in the answer block
	 * @param answerBlock
	 * @return the number of good answers
	 */
	private int nbGoodAnswers(AnswerBlock answerBlock){
		int nbGdAnswers= 0;
		for(Answer answer : answerBlock.getAnswerList()){
			if (answer.getPercentCredit() > 0) {
				nbGdAnswers++;
			}
		}
		
		return nbGdAnswers;
	
	}
	
	/**
	 * This method gives, from the question in a wikiversity form, the different answers put in a DefaultAnswerBlock
	 * @param question
	 * @return a DefaultAnswerBlock object 
	 */
	private DefaultAnswerBlock getAnswerBlock(String question) 
	{
		DefaultAnswerBlock answerBlock = new DefaultAnswerBlock();
		String[] answers = question.substring(question.indexOf('}')+2).split("\n");
		int nbGdAnswers = 0;
		DefaultAnswer answer;
		for (int i = 0; i < answers.length; i++) {
			if (answers[i].charAt(0)=='+') {
				nbGdAnswers++;
			}
		}
		for (int i = 0; i < answers.length; i++) {
			answer = new DefaultAnswer();
			if (answers[i].charAt(0)=='+') {
				answer.setFeedback("Correct Answer!");
				answer.setPercentCredit(1.f/nbGdAnswers);
			}
			else {
				answer.setFeedback("Wrong Answer!");
				answer.setPercentCredit(0.f);
			}
			answer.setTextValue(answers[i].substring(1));
			answerBlock.addAnswer(answer);
		}
		return answerBlock;	
	}
}
