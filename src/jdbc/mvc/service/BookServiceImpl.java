package jdbc.mvc.service;

import java.util.List;

import jdbc.mvc.dao.BookDAOImpl;
import jdbc.mvc.dto.BookDTO;

public class BookServiceImpl implements BookService{
	BookDAOImpl dao = BookDAOImpl.getInstance();
	//1. 도서 추가
	@Override
	public int bookInsert(BookDTO dto) {
		System.out.println("BookServiceImpl-bookInsert()");
		int insertCnt = dao.bookInsert(dto);
		return insertCnt;
	}

	//2. 도서 수정
	@Override
	public int bookUpdate(BookDTO dto) {
		System.out.println("BookServiceImpl-bookUpdate()");
		int updateCnt = dao.bookUpdate(dto);
		return updateCnt;
	}

	//3. 도서 삭제
	@Override
	public int bookDelete(int bookId) {
		System.out.println("BookServiceImpl-bookDelete()");
		int deleteCnt = dao.bookDelete(bookId);
		return deleteCnt;
	}

	//4. 도서아이디 조회
	@Override
	public BookDTO bookSelectById(int bookId) {
		System.out.println("BookServiceImpl-bookSelectById()");
		BookDTO dto = dao.bookSelectById(bookId);
		return dto;
	}
	
	//5. 도서제목 조회
	@Override
	public List<BookDTO> bookSelectByTitle(String title) {
		System.out.println("BookServiceImpl-bookSelectById()");
		List<BookDTO> list = dao.bookSelectByTitle(title);
		return list;
	}
	
	//6. 전체목록 조회
	@Override
	public List<BookDTO> bookSelectAll() {
		System.out.println("BookServiceImpl-bookSelectById()");
		List<BookDTO> dto = dao.bookSelectAll();
		return dto;
	}
	
	

}
