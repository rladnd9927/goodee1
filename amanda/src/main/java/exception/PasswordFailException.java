package exception;

public class PasswordFailException extends RuntimeException {
	public PasswordFailException(String msg){
		super(msg);
	}
}
