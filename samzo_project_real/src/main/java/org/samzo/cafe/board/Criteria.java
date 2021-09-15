package org.samzo.cafe.board;

public class Criteria {
	
	private int page;
	private int perPageNum;
	private int rowStart;
	private int rowEnd;
	
//	private int bbs_number;
	private String bbs_title;
	private String bbs_content;
	
	private String bbs_category;
	
	private int m_number; //추가
	private int hh_number;
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}
	
	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	
	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPage() {
		return page;
	}
	
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}
	
	public int getPerPageNum() {
		return this.perPageNum;
	}
	
	public int getRowStart() {
//		System.out.println("로우 스타트 실행되냐?");
		rowStart = ((page - 1) * perPageNum) + 1;
//		System.out.println(rowStart);
		return rowStart;
	}
	

	
	public int getRowEnd() {
//		System.out.println("로우 엔드 실행되냐?");
		rowEnd = rowStart + perPageNum - 1;
//		System.out.println(rowEnd);
		return rowEnd;
	}
	

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", rowStart=" + rowStart + ", rowEnd=" + rowEnd
				+ "]";
	}

	public int getM_number() {
		return m_number;
	}

	public void setM_number(int m_number) {
		this.m_number = m_number;
	}

	public int getHh_number() {
		return hh_number;
	}

	public void setHh_number(int hh_number) {
		this.hh_number = hh_number;
	}

	public String getBbs_content() {
		return bbs_content;
	}

	public void setBbs_content(String bbs_content) {
		this.bbs_content = bbs_content;
	}

	public String getBbs_title() {
		return bbs_title;
	}

	public void setBbs_title(String bbs_title) {
		this.bbs_title = bbs_title;
	}
//
//	public int getBbs_number() {
//		return bbs_number;
//	}
//
//	public void setBbs_number(int bbs_number) {
//		this.bbs_number = bbs_number;
//	}

	public String getBbs_category() {
		return bbs_category;
	}

	public void setBbs_category(String bbs_category) {
		this.bbs_category = bbs_category;
	}

}
