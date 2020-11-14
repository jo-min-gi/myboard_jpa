package com.ssafy.myboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.myboard.dto.BoardDTO;

public interface BoardMapper {
	public List<BoardDTO> getAllPosts();

	public BoardDTO getOnePost(int id);

	public int deleteOnePost(int id);

	public int createPost(BoardDTO post);

	public int modifyPost(BoardDTO post);

}
