package com.ssafy.myboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myboard.dto.BoardDTO;
import com.ssafy.myboard.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDTO> getAllPosts() {
		return boardMapper.getAllPosts();
	}

	@Override
	public BoardDTO getOnePost(int id) {
		return boardMapper.getOnePost(id);
	}

	@Override
	public int deleteOnePost(int id) {
		return boardMapper.deleteOnePost(id);
	}

	@Override
	public int createPost(BoardDTO post) {
		return boardMapper.createPost(post);
	}

	@Override
	public int modifyPost(BoardDTO post) {
		return boardMapper.modifyPost(post);
	}

}
