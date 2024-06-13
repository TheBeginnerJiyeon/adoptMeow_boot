package com.multi.adoptMeow.page.model.dto;


public class PageDTO {

	private int page;
	private int start;
	private int end;

	public void setStartEnd(int page) {

		// 5개씩 넘어가기
		
		start = 1 + (page - 1) * 5;
		end = page * 5;

	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	
	
	
}
