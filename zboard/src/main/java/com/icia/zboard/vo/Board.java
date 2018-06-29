package com.icia.zboard.vo;

import java.util.*;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int bno;
	private String id;
	@NotEmpty
	private String title;
	@NotEmpty
	private String content;
	private Date writeDate;
	private int readCnt;
}








