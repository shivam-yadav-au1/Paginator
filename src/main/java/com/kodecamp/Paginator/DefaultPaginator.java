package com.kodecamp.Paginator;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Shivam <tt>
 * This class can be used for records pagination.
 * This class needs to be created by using parametrized constructor which takes list to be paginated.
 * </tt>
 *
 */

public final class DefaultPaginator  {

	private List currentList = new ArrayList<>();

	private final Paginator paginator;

	public DefaultPaginator(List objects) {
		paginator = new Paginator(objects);
		// TODO Auto-generated constructor stub
	}

	public void refresh() {
		paginator.refresh();
	}

	/**
	 * <tt>
	 * This method moves the cursor to next page
	 * It must be called on jsf page.
	 * &#64;return empty string
	 * </tt>
	 */
	public String next() {
		Page page = this.paginator.next();
		currentList.clear();
		currentList.addAll(page.getItems());
		return "";
		
	}

	/**
	 * <tt>
	 * This method moves the cursor to previous page
	 * It must be called on jsf  page.
	 * &#64;return empty string 
	 * </tt>
	 */

	public String previous() {
		Page page = this.paginator.previous();
		currentList.clear();
		currentList.addAll(page.getItems());
		return "";
		
	}

	/**
	 * <tt>
	 * This method get the list of current object
	 * &#64;return List
	 * </tt>
	 */

	public List<?> getCurrentList() {
		return this.currentList;
	}

}
