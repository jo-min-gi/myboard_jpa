package com.ssafy.myboard.service;

import java.util.List;


import com.ssafy.myboard.dto.Board;

public interface BoardService {

	List<Board> findAll();

	Board findByBid(Long bid);
	
	Board save(Board board);
	
	Board update(Board board, Long bid);
	
	void deleteByBid(Long bid);

}
