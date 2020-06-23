package library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.mapper.BookInter;
import library.pojo.Book;
@Service
public class BookServiceImpl implements Bookservice {
	@Autowired
	BookInter bookInter;
	//查询所有图书
	public List<Book> SelectAll() {
		// TODO Auto-generated method stub
		List<Book> list=bookInter.FindAll();
		return list;
	}
	//查询一本图书
	public Book FindOne(int bid) {
		// TODO Auto-generated method stub
		Book book=bookInter.FindOne(bid);
		return book;
	}
	//插入图书
	public int insertOne(int bid, String bname, int quantity) {
		// TODO Auto-generated method stub
		int i=bookInter.InsertOne(bid, bname, quantity);
		return i;
	}
	//删除图书
	public int deleteOne(int bid) {
		// TODO Auto-generated method stub
		int i=bookInter.deleteOne(bid);
		return i;
	}
	//修改图书数量
	public int chanceBook(int bid, int quantity) {
		// TODO Auto-generated method stub
		int i=bookInter.chanceBook(bid, quantity);
		return i;
	}

}
