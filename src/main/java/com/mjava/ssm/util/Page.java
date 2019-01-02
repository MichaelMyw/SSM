package com.mjava.ssm.util;

public class Page {
	//开始的页数
	int start = 0;
	//每页的个数
	int count = 5;
	//最后一页的页数
	int last = 0;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	
	public void calculateLast(int total) {
		if(total % count ==0) {
			last = total-count;
		}
		else {
			last = total-total%count;
		}
	}
	
}
