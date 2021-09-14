package org.samzo.cafe.board;

import java.sql.Date;

public class ReplyDTO {
	private int r_number;
	private String m_nickname;
	private String r_content;
	private Date r_date;
	
	public ReplyDTO(int r_number, String m_nickname, String r_content, Date r_date) {
		this.r_number = r_number;
		this.m_nickname = m_nickname;
		this.r_content = r_content;
		this.r_date = r_date;
	}

	public int getR_number() {
		return r_number;
	}

	public void setR_number(int r_number) {
		this.r_number = r_number;
	}

	public String getM_nickname() {
		return m_nickname;
	}

	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}

	@Override
	public String toString() {
		return "ReplyDTO [r_number=" + r_number + ", m_nickname=" + m_nickname + ", r_content=" + r_content
				+ ", r_date=" + r_date + "]";
	}
}
