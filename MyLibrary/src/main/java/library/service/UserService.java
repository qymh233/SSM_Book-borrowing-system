package library.service;

import java.util.List;

import library.pojo.User;

public interface UserService {
	//用户登陆
	User SelectOne(int uid);
	//用户借书
	int borrow(String bname,int uid);
	//用户还书
	int give(String bname,int uid);
	//用户修改密码
	int revise(String newpw,int uid);
	//查询所有用户
	List<User> SelectAll();
	//添加用户
	int insertOne(int uid,String upw,String uname);
	//删除用户
	int deleteOne(int uid);
}
