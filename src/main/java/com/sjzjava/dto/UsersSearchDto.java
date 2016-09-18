package com.sjzjava.dto;

public class UsersSearchDto {
	
	//检索信息
	private String searchName;
	//检索表列名
	private String columnName;
	//检索起始数
	private int limitFirst;
	
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public int getLimitFirst() {
		return limitFirst;
	}
	public void setLimitFirst(int limitFirst) {
		this.limitFirst = limitFirst;
	}
}
