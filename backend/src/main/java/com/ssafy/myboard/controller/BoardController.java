package com.ssafy.myboard.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import com.ssafy.myboard.dto.BoardDTO;
import com.ssafy.myboard.service.BoardService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private BoardService boardService;

	@ApiOperation(value = "모든 게시글을 반환한다 for jenkins", response = List.class)
	@GetMapping("")
	public ResponseEntity<List<BoardDTO>> getAllPosts() throws Exception {
		logger.debug("getAllPosts - 호출");
		System.out.println(boardService.getAllPosts());
		return new ResponseEntity<List<BoardDTO>>(boardService.getAllPosts(), HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "하나의 게시글을 작성한다.", response = Integer.class)
	@PostMapping("")
	public ResponseEntity<Integer> createPost(@RequestBody BoardDTO post) throws Exception {
		System.out.println(post);
		logger.debug("createPost - 호출");
		return new ResponseEntity<Integer>(boardService.createPost(post), HttpStatus.OK);
	}

	@ApiOperation(value = "하나의 게시글을 수정한다.", response = Integer.class)
	@PutMapping("")
	public ResponseEntity<Integer> modifyPost(@RequestBody BoardDTO post) throws Exception {
		logger.debug("modifyPost - 호출");
		return new ResponseEntity<Integer>(boardService.modifyPost(post), HttpStatus.OK);
	}

	@ApiOperation(value = "하나의 게시글을 반환한다.", response = BoardDTO.class)
	@GetMapping("/{id}")
	public ResponseEntity<BoardDTO> getOnePost(@PathVariable int id) throws Exception {
		logger.debug("getOnePost - 호출");
		return new ResponseEntity<BoardDTO>(boardService.getOnePost(id), HttpStatus.OK);
	}

	@ApiOperation(value = "하나의 게시글을 삭제한다.", response = Integer.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deleteOnePost(@PathVariable int id) throws Exception {
		logger.debug("deleteOnePost - 호출");
		return new ResponseEntity<Integer>(boardService.deleteOnePost(id), HttpStatus.OK);
	}

}
