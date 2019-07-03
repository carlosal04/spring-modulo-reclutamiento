package com.example.demo.util.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {
	
	private String url;
	private Page<T> page;
	
	private int totalPages;
	
	private int elementsByPage;
	
	private int currentPage;
	
	private List<PageItem> pages;
	
	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.pages = new ArrayList<PageItem>();
		
		elementsByPage = page.getSize();
		totalPages = page.getTotalPages();
		currentPage = page.getNumber() + 1;
		
		int from, to;
		if(totalPages <= elementsByPage) {
			from = 1;
			to = totalPages;
		} else {
			if(currentPage <= elementsByPage/2) {
				from = 1;
				to = elementsByPage;
			} else if(currentPage >= totalPages - elementsByPage/2 ) {
				from = totalPages - elementsByPage + 1;
				to = elementsByPage;
			} else {
				from = currentPage -elementsByPage/2;
				to = elementsByPage;
			}
		}
		
		for(int i=0; i < to; i++) {
			pages.add(new PageItem(from + i, currentPage == from+i));
		}

	}

	public String getUrl() {
		return url;
	}
	
	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<PageItem> getPages() {
		return pages;
	}

	public void setPages(List<PageItem> pages) {
		this.pages = pages;
	}

	public boolean isFirst() {
		return page.isFirst();
	}
	
	public boolean isLast() {
		return page.isLast();
	}
	
	public boolean isHasNext() {
		return page.hasNext();
	}
	
	public boolean isHasPrevious() {
		return page.hasPrevious();
	}

}
