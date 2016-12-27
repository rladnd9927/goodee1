package logic;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	@Size(min=3, max=10, message = "id는 3자리 이상 10자리 이하로 입력바랍니다.") //해당 유효성 검증항목에대해 벗어나게 되면 기본적으로 출력되는 오류 메세지를 변경 가능함 (이렇게 파라미터로 넘겨줘서 변경)
	private String userId;
	
	@Size(min=4, max=12, message="비밀번호는 4자리 이상, 12자리 이하로 입력 바랍니다.")
	private String password;
	private String userName;
	private String phoneNo;
	private String postCode;
	private String address;
	private String email;
	
	@Past(message="생일은 과거 날짜만 가능합니다.")
	private Date birthDay;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", userName=" + userName + ", phoneNo=" + phoneNo
				+ ", postCode=" + postCode + ", address=" + address + ", email=" + email + ", birthDay=" + birthDay
				+ "]";
	}
	
	
}
