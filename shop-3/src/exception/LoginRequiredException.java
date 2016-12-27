package exception;

public class LoginRequiredException extends RuntimeException { //runtimeExceptio은 예외처리 생략가능.
	public LoginRequiredException(String msg){
		super(msg);
	}
}
