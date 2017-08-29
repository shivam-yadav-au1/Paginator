package com.kodecamp.Paginator;

import java.util.List;

public class Page {

	private int pageSize;
	private List<? extends Object> items;
	private int pageNo;

	public Page(final List<? extends Object> items, final int pageNO) {

		this.items = items;
		this.pageNo = pageNO;

	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<? extends Object> getItems() {
		return items;
	}

	

}
