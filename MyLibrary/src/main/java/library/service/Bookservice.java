package library.service;

import java.util.List;

import library.pojo.Book;

public interface Bookservice {
	//���ͼ��
	int insertOne(int bid,String bname,int quantity);
	//ɾ��ͼ��
	int deleteOne(int bid);
	//��ѯ����ͼ��
	List<Book> SelectAll();
	//��ѯһ��ͼ��
	Book FindOne(int bid);
	//�޸�ͼ��
	int chanceBook(int bid,int quantity);
}
