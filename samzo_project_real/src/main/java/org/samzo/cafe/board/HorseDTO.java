package org.samzo.cafe.board;

public class HorseDTO {
	private int hh_number;
	private String hh_head;
	
	public HorseDTO(int hh_number, String hh_head) {
		this.hh_number = hh_number;
		this.hh_head = hh_head;
	}
	public int getHh_number() {
		return hh_number;
	}
	public void setHh_number(int hh_number) {
		this.hh_number = hh_number;
	}
	public String getHh_head() {
		return hh_head;
	}
	public void setHh_head(String hh_head) {
		this.hh_head = hh_head;
	}
	@Override
	public String toString() {
		return "HorseDTO [hh_number=" + hh_number + ", hh_head=" + hh_head + "]";
	}
	

}
