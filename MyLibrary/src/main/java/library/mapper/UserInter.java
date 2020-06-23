package library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import library.pojo.User;

public interface UserInter {
	//用户登陆
	User SelectOne(int uid);
	//用户借书
	int borrow(@Param("bname")String bname,@Param("uid")int uid);
	//用户还书
	int give(@Param("bname")String bname,@Param("uid")int uid);
	//用户修改密码
	int revise(@Param("newpw")String newpw,@Param("uid")int uid);
	//查询所有用户
	List<User> FindAll();
	//添加用户
	int InsertOne(@Param("uid")int uid,@Param("upw")String upw,@Param("uname")String uname);
	//删除用户
	int deleteOne(int uid);
}
