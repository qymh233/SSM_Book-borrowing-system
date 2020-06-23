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
	//��ѯ����ͼ��
	public List<Book> SelectAll() {
		// TODO Auto-generated method stub
		List<Book> list=bookInter.FindAll();
		return list;
	}
	//��ѯһ��ͼ��
	public Book FindOne(int bid) {
		// TODO Auto-generated method stub
		Book book=bookInter.FindOne(bid);
		return book;
	}
	//����ͼ��
	public int insertOne(int bid, String bname, int quantity) {
		// TODO Auto-generated method stub
		int i=bookInter.InsertOne(bid, bname, quantity);
		return i;
	}
	//ɾ��ͼ��
	public int deleteOne(int bid) {
		// TODO Auto-generated method stub
		int i=bookInter.deleteOne(bid);
		return i;
	}
	//�޸�ͼ������
	public int chanceBook(int bid, int quantity) {
		// TODO Auto-generated method stub
		int i=bookInter.chanceBook(bid, quantity);
		return i;
	}

}
