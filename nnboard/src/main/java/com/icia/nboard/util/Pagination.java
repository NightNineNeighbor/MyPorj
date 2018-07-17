package com.icia.nboard.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination {
	private int startRowNum;
	private int endRowNum;
	private int startPageNo;
	private int endPageNo;
	private int prev;
	private int next;
	private int pageNo;
}