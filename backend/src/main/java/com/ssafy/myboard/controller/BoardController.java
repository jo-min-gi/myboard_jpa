package com.ssafy.myboard.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

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
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.ssafy.myboard.dto.Board;
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

	@ApiOperation(value = "모든 게시글을 반환한다.", response = List.class)
	@GetMapping("")
	public ResponseEntity<List<Board>> findAll() throws Exception {
		logger.debug("findAll - 호출");
		return new ResponseEntity<List<Board>>(boardService.findAll(), HttpStatus.OK);
	}

	@ApiOperation(value = "하나의 게시글을 작성한다.", response = Integer.class)
	@PostMapping("")
	public ResponseEntity<Board> save(@RequestBody Board post) throws Exception {
		logger.debug("createPost - 호출");
		return new ResponseEntity<Board>(boardService.save(post), HttpStatus.OK);
	}

	@ApiOperation(value = "하나의 게시글을 수정한다.", response = Integer.class)
	@PutMapping("")
	public ResponseEntity<Board> update(@RequestBody Board post) throws Exception {
		logger.debug("modifyPost - 호출");
		return new ResponseEntity<Board>(boardService.update(post, post.getBid()), HttpStatus.OK);
	}

	@ApiOperation(value = "하나의 게시글을 반환한다.", response = Board.class)
	@GetMapping("/{bid}")
	public ResponseEntity<Board> findByBid(@PathVariable Long bid) throws Exception {
		logger.debug("findByBid - 호출");
		return new ResponseEntity<Board>(boardService.findByBid(bid), HttpStatus.OK);
	}

	@ApiOperation(value = "하나의 게시글을 삭제한다.", response = Integer.class)
	@DeleteMapping("/{bid}")
	public ResponseEntity<Integer> deleteByBid(@PathVariable Long bid) throws Exception {
		logger.debug("deleteByBid - 호출");
		boardService.deleteByBid(bid);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

	public void createQR(Board post) throws Exception {
		System.out.println(post);
		File path = new File("/myboard/qrcode/images/");
		String fileName = UUID.randomUUID().toString().replace("-", "");
		if (!path.exists())
			path.mkdirs();

		QRCodeWriter writer = new QRCodeWriter();
		BitMatrix qrCode = writer.encode("http://localhost:8081/read?bid=6" + post.getBid(), BarcodeFormat.QR_CODE, 200,
				200);
		BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(qrCode);
		ImageIO.write(qrImage, "PNG", new File(path, fileName + ".png"));
	}

}
