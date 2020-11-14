package com.ssafy.myboard.service;

import java.util.List;


import com.ssafy.myboard.dto.BoardDTO;

public interface BoardService {

	List<BoardDTO> getAllPosts();

	BoardDTO getOnePost(int id);

	int deleteOnePost(int id);

	int createPost(BoardDTO post);

	int modifyPost(BoardDTO post);

}
