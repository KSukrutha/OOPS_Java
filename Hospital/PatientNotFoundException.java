package CustomException;

public class PatientNotFoundException extends RuntimeException {
private String message;

public PatientNotFoundException(String message){
	this.message=message;
}
public String toString() {
	return message;
}
}


	