package com.kodecamp.Paginator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Paginator {

	private static final int DEFAULT_PAGE_NO = 10;
	private int pageSize = DEFAULT_PAGE_NO;
	private List<Page> pages = new ArrayList<>();
	private int currentIndex = -1;
	private List<? extends Object> allItems;

	public Paginator(final List<? extends Object> items) {
		this(items, DEFAULT_PAGE_NO);

	}

	public Paginator(final List<? extends Object> items, final int pageSize) {

		this.allItems = items;
	
		this.pageSize = pageSize;

	}

	public void refresh() {
		this.currentIndex = -1;
		this.pages.clear();

		float totalItems = this.allItems.size() * 1.0f;
		float totalFractionalPages = totalItems * 1.0f / pageSize;
		int completePages = (int) totalFractionalPages;

		float lastFraction = (totalFractionalPages - completePages) * 1.0f;

		int itemsOnLastPage = (int) (lastFraction * pageSize);
		

		int pageNo = 1;
		for (int i = 0; i < completePages; i++) {
			List<? extends Object> pageItems = this.allItems.subList(i * pageSize, pageNo * pageSize);
			pages.add(new Page(pageItems, pageNo));
			pageNo += 1;
		}
		if (itemsOnLastPage > 0) {
			List<? extends Object> pageItems = this.allItems.subList(this.allItems.size() - itemsOnLastPage,
					this.allItems.size());
			pages.add(new Page(pageItems, pageNo));
		}

		

	}

	public Page next() {
		Page currentPage = null;
	
		this.currentIndex += 1;
	
		if (!hasNext()) {
			
			currentPage = new Page(new ArrayList(0), -1);
			return currentPage;
		}

		currentPage = this.pages.get(currentIndex);

		return currentPage;
	}

	public Page previous() {
		Page currentPage = null;
		if (!hasPrevious()) {
			
			currentPage = new Page(new ArrayList(0), -1);
			this.currentIndex -= 1;
			return currentPage;
		}
		this.currentIndex -= 1;
		
		currentPage = this.pages.get(currentIndex);

		return currentPage;
	}

	public boolean hasPrevious() {
		
		boolean isPrevious = this.currentIndex > 0 && this.currentIndex < this.pages.size() ? true : false;
		
		return isPrevious;

	}

	public boolean hasNext() {

		boolean isNext = this.currentIndex < this.pages.size() ? true : false;
	
		return isNext;
	}

	public static void main(String args[]) {

		
		int totalItems = 6;
		int size = 10;
		Float d = new Float(totalItems * 1f / size);
		System.out.println(d);
	}

}
