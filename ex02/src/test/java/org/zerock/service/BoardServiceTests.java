package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	/*    메서드를 선택하고 Ctrl + F11을 누르면 해당 메서드 한개만 테스트 할 수 있다.       */
	@Test
	//@Ignore
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	//@Ignore
	public void testRegister() {
		
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		service.register(board);
		
		log.info("생성된 게시물의 번호 : " + board.getBno());
	}
	
	@Test
	//@Ignore
	public void testGetList() {
		service.getList().forEach(board->log.info(board));
	}
	
	@Test
	public void testGet() {
		log.info(service.get(1L));
	}
	
	@Test
	//@Ignore
	public void testDelete() {
		// 게시물 번호의 존재 여부를 확인하고 테스트할 것
		log.info("REMOVE RESULT: " + service.remove(4L));
	}
	
	@Test
	//@Ignore
	public void testUpdate() {
		BoardVO board = service.get(30L);
		
		if(board == null) {
			return;
		}
		
		board.setTitle("제목을 수정합니다.");
		log.info("MODIFY RESULT: " + service.modify(board));
	}
}
