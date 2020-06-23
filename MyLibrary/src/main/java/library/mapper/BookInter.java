package library.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import library.pojo.Book;

public interface BookInter {
	//�����鼮����
	int ReduceQuantity(String bname);
	//�����鼮����
	int AddQuantity(String bname);
	//��ѯ�����鼮
	List<Book> FindAll();
	//��ѯһ����
	Book FindOne(int bid);
	//����ͼ��
	int InsertOne(@Param("bid")int bid,@Param("bname")String bname,@Param("quantity")int quantity);
	//ɾ��ͼ��
	int deleteOne(int bid);
	//�޸�ͼ������
	int chanceBook(@Param("bid")int bid,@Param("quantity")int quantity);
}
