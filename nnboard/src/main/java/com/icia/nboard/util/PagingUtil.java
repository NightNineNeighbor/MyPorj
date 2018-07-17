package com.icia.nboard.util;

import org.springframework.stereotype.Component;

@Component
public class PagingUtil {
	private static final int countBoardPerPage = 10;											// 한 페이지에 출력할 글의 개수
	private static final int countPagePerBlock = 5;											// 한 블록에 출력할 페이지의 개수
	public Pagination getPagination(int countOfBoard, int pageNo) {
		int startRowNum = (pageNo-1)*countBoardPerPage + 1;
		int endRowNum = startRowNum + countBoardPerPage - 1;
		endRowNum = (endRowNum>countOfBoard)?countOfBoard : endRowNum;
		int countOfPage = (countOfBoard-1)/countBoardPerPage + 1;			// 페이지의 개수
		int groupNo = (pageNo-1)/countPagePerBlock;							// 0번부터 시작하는 블록번호
		int startPageNo = groupNo * countPagePerBlock + 1;
		int endPageNo = startPageNo + countPagePerBlock - 1;
		int prev = startPageNo -1;
		// 마지막 블록일 경우 next가 페이지의 개수보다 커지게 된다
		int next = endPageNo + 1;
		if(endPageNo>countOfPage) {
			endPageNo = countOfPage;
			next = 0;
		}
		return new Pagination(startRowNum, endRowNum, startPageNo, endPageNo, prev, next, pageNo);
	}
}
