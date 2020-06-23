package library.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import library.pojo.Book;

public interface BookInter {
	//减少书籍数量
	int ReduceQuantity(String bname);
	//增加书籍数量
	int AddQuantity(String bname);
	//查询所有书籍
	List<Book> FindAll();
	//查询一本书
	Book FindOne(int bid);
	//插入图书
	int InsertOne(@Param("bid")int bid,@Param("bname")String bname,@Param("quantity")int quantity);
	//删除图书
	int deleteOne(int bid);
	//修改图书数量
	int chanceBook(@Param("bid")int bid,@Param("quantity")int quantity);
}
