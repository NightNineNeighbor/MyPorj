package com.icia.zboard.controller;

public interface ZBoard {
	public final static String ALREADY_LOGIN = "이미 로그인되어 있습니다. 정상적인 사이트 사용을 바랍니다";
	public final static String SEND_MAIL = "메일이 발송되었습니다. 확인해주십시오";
	public final static String SEND_MAIL_FAILURE = "메일 발송에 실패했습니다. 관리자에게 이메일 또는 전화로 도움을 요청하십시오.";
	public final static String NEED_ID = "ID 정보가 필요합니다";
	public final static String NEED_IRUM = "이름 정보가 필요합니다";
	public final static String NEED_EMAIL = "이메일 정보가 필요합니다";
	public final static String NEED_BNO = "글번호가 필요합니다";
}
