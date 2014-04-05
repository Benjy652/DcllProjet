package quiz.impl.wikiversity;

import java.util.regex.Pattern;

import quiz.Answer;
import quiz.QuestionType;
import quiz.Quiz;
import quiz.impl.DefaultQuiz;
import quiz.impl.DefaultAnswer;
import quiz.impl.DefaultAnswerBlock;
import quiz.impl.DefaultQuestion;

public class WikiReader {
	
	/**
	 * This method take a quiz, in a text form, in entry and do all the necessary operations to check
	 * the questions forms and construct the objects	
	 * @param quiz
	 * @return a Quiz object 
	 */
	Quiz getDefaultQuiz(String quiz){
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
	boolean checkQuestionForm(String question)
	{
		String regEx = "\\A\\{.+\\n\\|type=";
		regEx += "\"(\\[\\]|\\(\\))\"\\}\\n";
		regEx += "([\\+|\\-]+.+\\n){2,}";
		Pattern questionPattern = Pattern.compile(regEx);
		return questionPattern.matcher(question).find();
	}
	
	/**
	 * This method takes a question in a text form and construc the object
	 * @param question
	 * @return DefaultQuestion object
	 */
	DefaultQuestion getQuestion(String question) 
	{
		DefaultQuestion questionObject = new DefaultQuestion();
		questionObject.setQuestionType(getQuestionType(question));
		questionObject.setTitle(getQuestionTitle(question));
		questionObject.addAnswerBlock(getAnswerBlock(question));
		return questionObject;
	}

	/**
	 * This method gives, from the question in a wikiversity form, the question type
	 * @param question
	 * @return the type of the question (Multiple or Single)
	 */
	QuestionType getQuestionType(String question) 
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
	String getQuestionTitle(String question) 
	{
		int index = question.indexOf('|');
		return question.substring(1,index-1);	
	}
	
	/**
	 * This method gives, from the question in a wikiversity form, the different answers put in a DefaultAnswerBlock
	 * @param question
	 * @return a DefaultAnswerBlock object 
	 */
	DefaultAnswerBlock getAnswerBlock(String question) 
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
