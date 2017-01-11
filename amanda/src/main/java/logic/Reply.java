package logic;

public class Reply {
	private int m_number;
	private String m_nickname;
	private int r_num;
	private int ref_level;
	private String r_content;
	private int sns_no;
	public int getM_number() {
		return m_number;
	}
	public void setM_number(int m_number) {
		this.m_number = m_number;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public int getR_num() {
		return r_num;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
	}
	public int getRef_level() {
		return ref_level;
	}
	public void setRef_level(int ref_level) {
		this.ref_level = ref_level;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public int getSns_no() {
		return sns_no;
	}
	public void setSns_no(int sns_no) {
		this.sns_no = sns_no;
	}
	@Override
	public String toString() {
		return "Reply [m_number=" + m_number + ", m_nickname=" + m_nickname + ", r_num=" + r_num + ", ref_level="
				+ ref_level + ", r_content=" + r_content + ", sns_no=" + sns_no + "]";
	}
	
	
}
