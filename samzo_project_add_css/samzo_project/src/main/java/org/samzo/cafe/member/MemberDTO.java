package org.samzo.cafe.member;

public class MemberDTO {
	//member 테이블의 각 컬럼들
	int m_number;
	String m_id;
	String m_pw;
	String m_nickname;
	String m_email;
	
	
	//getter와 setter들
	public int getM_number() {
		return m_number;
	}
	public void setM_number(int m_number) {
		this.m_number = m_number;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	@Override
	public String toString() {
		return "UserDTO [m_number=" + m_number + ", m_id=" + m_id + ", m_pw=" + m_pw + ", m_nickname="
				+ m_nickname + ", m_email=" + m_email + "]";
	}
	
}
