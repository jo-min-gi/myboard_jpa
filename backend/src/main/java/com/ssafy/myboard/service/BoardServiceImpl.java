package com.ssafy.myboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ssafy.myboard.dto.Board;
import com.ssafy.myboard.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Override
	public List<Board> findAll() {
		return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "bid"));
	}

	@Override
	public Board findByBid(Long bid) {
		return boardRepository.findById(bid).orElseThrow(null);
	}

	@Override
	public Board save(Board board) {
		return boardRepository.save(board);
	}

	@Override
	public Board update(Board newBoard, Long bid) {
		return boardRepository.findById(bid).map(board -> {
			board.setWriter(newBoard.getWriter());
			board.setTitle(newBoard.getTitle());
			board.setContents(newBoard.getContents());
			return boardRepository.save(board);
		}).orElseGet(() -> {
			newBoard.setBid(bid);
			return boardRepository.save(newBoard);
		});
	}

	@Override
	public void deleteByBid(Long bid) {
		boardRepository.deleteById(bid);
	}

}
