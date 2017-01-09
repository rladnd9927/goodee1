package logic;

public class SemiUser {
	private int s_number;
	private String s_email;
	private String s_password;
	private String s_name;
	private int s_score;
	 
	 //getter,setter,toString
	public int getS_number() {
		return s_number;
	}
	public void setS_number(int s_number) {
		this.s_number = s_number;
	}
	public String getS_email() {
		return s_email;
	}
	public void setS_email(String s_email) {
		this.s_email = s_email;
	}
	public String getS_password() {
		return s_password;
	}
	public void setS_password(String s_password) {
		this.s_password = s_password;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public int getS_score() {
		return s_score;
	}
	public void setS_score(int s_score) {
		this.s_score = s_score;
	}
	
	@Override
	public String toString() {
		return "SemiUser [s_number=" + s_number + ", s_email=" + s_email + ", s_password=" + s_password + ", s_name="
				+ s_name + ", s_score=" + s_score + "]";
	}
}
