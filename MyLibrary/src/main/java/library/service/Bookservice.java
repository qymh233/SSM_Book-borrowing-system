package library.service;

import java.util.List;

import library.pojo.Book;

public interface Bookservice {
	//添加图书
	int insertOne(int bid,String bname,int quantity);
	//删除图书
	int deleteOne(int bid);
	//查询所有图书
	List<Book> SelectAll();
	//查询一本图书
	Book FindOne(int bid);
	//修改图书
	int chanceBook(int bid,int quantity);
}
