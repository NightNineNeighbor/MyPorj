package com.icia.zboard.service;

import java.io.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.util.*;
import org.springframework.web.multipart.*;

import lombok.extern.slf4j.*;

@Service
@Slf4j
public class AsyncService {
	@Value("d:/service/upload")
	private String uploadPath;
	@Async
	public void fileSave(MultipartFile sajin, String savedFileName) {
		long startTime = System.currentTimeMillis();
		File file = new File(uploadPath, savedFileName);
		try {
			FileCopyUtils.copy(sajin.getBytes(), file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		log.info("파일 저장 완료 : {}msec 소요", (endTime-startTime));
	}
}
