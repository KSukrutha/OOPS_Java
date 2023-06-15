package CustomException;

public class InvalidChoiceException extends RuntimeException {
	String message;

	public  InvalidChoiceException (String message) {
		this.message= message;
	}
	@Override
	public String toString() {
		return message;
	}

}
