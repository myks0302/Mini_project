package org.samzo.cafe.board;

import java.sql.Date;

public class BoardDTO {
		private int bbs_number;
		private String bbs_category;
		private String hh_head;
		private String m_nickname;
		private String bbs_title;
		private String bbs_content;
		private Date bbs_date;
		private int bbs_views;
		private int bbs_activated;
		
		public BoardDTO() {
			// TODO Auto-generated constructor stub
		}
	
		public BoardDTO(int bbs_number, String bbs_category, String hh_head, String m_nickname, String bbs_title,
				String bbs_content, Date bbs_date, int bbs_views, int bbs_activated) {
			super();
			this.bbs_number = bbs_number;
			this.bbs_category = bbs_category;
			this.hh_head = hh_head;
			this.m_nickname = m_nickname;
			this.bbs_title = bbs_title;
			this.bbs_content = bbs_content;
			this.bbs_date = bbs_date;
			this.bbs_views = bbs_views;
			this.bbs_activated = bbs_activated;
		}


		public int getBbs_activated() {
			return bbs_activated;
		}


		public void setBbs_activated(int bbs_activated) {
			this.bbs_activated = bbs_activated;
		}


		public int getBbs_number() {
			return bbs_number;
		}

		public void setBbs_number(int bbs_number) {
			this.bbs_number = bbs_number;
		}

		public String getBbs_category() {
			return bbs_category;
		}

		public void setBbs_category(String bbs_category) {
			this.bbs_category = bbs_category;
		}

		public String gethh_head() {
			return hh_head;
		}

		public void sethh_head(String hh_head) {
			this.hh_head = hh_head;
		}

		public String getm_nickname() {
			return m_nickname;
		}

		public void setm_nickname(String m_nickname) {
			this.m_nickname = m_nickname;
		}

		public String getBbs_title() {
			return bbs_title;
		}

		public void setBbs_title(String bbs_title) {
			this.bbs_title = bbs_title;
		}

		public String getBbs_content() {
			return bbs_content;
		}

		public void setBbs_content(String bbs_content) {
			this.bbs_content = bbs_content;
		}

		public Date getBbs_date() {
			return bbs_date;
		}

		public void setBbs_date(Date bbs_date) {
			this.bbs_date = bbs_date;
		}

		public int getBbs_views() {
			return bbs_views;
		}

		public void setBbs_views(int bbs_views) {
			this.bbs_views = bbs_views;
		}

		@Override
		public String toString() {
			return "BoardDTO [bbs_number=" + bbs_number + ", bbs_category=" + bbs_category + ", hh_head=" + hh_head
					+ ", m_nickname=" + m_nickname + ", bbs_title=" + bbs_title + ", bbs_content=" + bbs_content
					+ ", bbs_date=" + bbs_date + ", bbs_views=" + bbs_views + ", bbs_activated=" + bbs_activated + "]";
		}
}	