package logic;

public class User {
    private int m_number;
    private String m_email;
    private String m_password;
    private String m_name;
	public int getM_number() {
		return m_number;
	}
	public void setM_number(int m_number) {
		this.m_number = m_number;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	@Override
	public String toString() {
		return "User [m_number=" + m_number + ", m_email=" + m_email + ", m_password=" + m_password + ", m_name="
				+ m_name + "]";
	}  
}
