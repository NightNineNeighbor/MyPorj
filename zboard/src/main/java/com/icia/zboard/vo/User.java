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
public class User {
	@Size(min=8, max=10)
	@NotEmpty
	private String id;
	@NotEmpty
	private String irum;
	@Pattern(regexp="^[0-9A-Za-z!@#$]{8,10}$")
	private String pwd;
	private String originalFileName;
	private String savedFileName;
	@Pattern(regexp="^[0-9a-zA-Z]+@[0-9a-zA-Z]+\\.[0-9a-zA-Z]+$")
	private String email;
	@Past									// 대상날짜가 현재보다 과거일 경우만 통과
	private Date birthDate;
}
