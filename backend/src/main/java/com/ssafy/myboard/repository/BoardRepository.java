package com.ssafy.myboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.myboard.dto.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	
}
