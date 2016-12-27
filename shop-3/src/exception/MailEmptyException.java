package exception;

public class MailEmptyException extends RuntimeException {
	public MailEmptyException (String msg){
		super(msg);
	}
}
