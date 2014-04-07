package quiz.exceptions;

/**
 * 
 * @author Assyl
 *
 */
public class WrongSyntaxException extends Exception {
	
	/**
	 * The constructor of a WrongSyntaxException exception
	 * @param errorMessage : the message that fits the error
	 */
	public WrongSyntaxException(String errorMessage){
		super(errorMessage);
	}

}
