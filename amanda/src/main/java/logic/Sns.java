package logic;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class Sns {
	private Date sns_date; //�����
	
	@NotNull
	private String sns_content; //�� ����
	
	private int sns_no; //�۹�ȣ
	
	@NotNull
	private String sns_subject;//�� ����
	private String fileUrl;
	
	private int m_number; //������ȣ
	private MultipartFile sns_picture; //����
	
	
	public MultipartFile getSns_picture() {
		return sns_picture;
	}
	public void setSns_picture(MultipartFile sns_picture) {
		this.sns_picture = sns_picture;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public Date getSns_date() {
		return sns_date;
	}
	public void setSns_date(Date sns_date) {
		this.sns_date = sns_date;
	}
	public String getSns_content() {
		return sns_content;
	}
	public void setSns_content(String sns_content) {
		this.sns_content = sns_content;
	}
	public int getSns_no() {
		return sns_no;
	}
	public void setSns_no(int sns_no) {
		this.sns_no = sns_no;
	}
	public String getSns_subject() {
		return sns_subject;
	}
	public void setSns_subject(String sns_subject) {
		this.sns_subject = sns_subject;
	}
	public int getM_number() {
		return m_number;
	}
	public void setM_number(int m_number) {
		this.m_number = m_number;
	}
	
}
