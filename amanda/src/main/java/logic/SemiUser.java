package logic;
//semiuser
public class SemiUser {
	private int m_number;
	private String s_email;
	private String s_password;
	private String s_name;
	private int s_score;
	private int gender;
	private int s_usercount;
	
	//getter,setter,toString
	public int getM_number() {
		return m_number;
	}
	public void setM_number(int m_number) {
		this.m_number = m_number;
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
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getS_usercount() {
		return s_usercount;
	}
	public void setS_usercount(int s_usercount) {
		this.s_usercount = s_usercount;
	}
	@Override
	public String toString() {
		return "SemiUser [m_number=" + m_number + ", s_email=" + s_email + ", s_password=" + s_password + ", s_name="
				+ s_name + ", s_score=" + s_score + ", gender=" + gender + ", s_usercount=" + s_usercount + "]";
	}
}
