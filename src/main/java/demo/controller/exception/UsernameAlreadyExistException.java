package demo.controller.exception;

public class UsernameAlreadyExistException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2457189221942924874L;

	public UsernameAlreadyExistException() {
        super("Username already exist");
    }

}
