package com.ssafy.myboard.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ssafy.myboard.dto.Board;

public interface BoardService {

	List<Board> findAll();

	Page<Board> findAll(Pageable pageable);
	
	Board findByBid(Long bid);
	
	Board save(Board board);
	
	Board update(Board board, Long bid);
	
	void deleteByBid(Long bid);



}
