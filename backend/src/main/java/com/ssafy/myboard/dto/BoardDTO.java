package com.ssafy.myboard.dto;

import lombok.Data;

@Data
public class BoardDTO {
	private int bid;
	private String title;
	private String writer;
	private String contents;
	private String createdAt;
}
