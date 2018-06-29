package com.icia.nboard.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int bno;
	private String writer;
	private String title;
	private String content;
	private Date writeDate;
	private int readCnt;
	private int likeCnt;

}
