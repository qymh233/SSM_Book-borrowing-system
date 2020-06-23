package library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.mapper.BookInter;
import library.mapper.UserInter;
import library.pojo.User;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserInter userInter;
	@Autowired
	BookInter bookInter;
	//用户登陆
	public User SelectOne(int uid) {
		// TODO Auto-generated method stub
		User user =userInter.SelectOne(uid);
		return user;
	}
	//用户借书
	public int borrow(String bname, int uid) {
		// TODO Auto-generated method stub
		int i=0;
		int j=0;
		//借书操作
		i=userInter.borrow(bname, uid);
		if(i>0) {	
			//图书数量减一
			j=bookInter.ReduceQuantity(bname);
			if(j>0) {
				return j;
			}
			return -1;
		}
		return j;
	}
	//用户还书
	public int give(String bname, int uid) {
		// TODO Auto-generated method stub
		int i=0;
		int j=0;
		//还书操作
		i=userInter.give(bname, uid);
		if(i>0) {	
			//图书数量加一
			j=bookInter.AddQuantity(bname);
			if(j>0) {
				return j;
			}
			return -1;
		}
		return j;
	}
	//用户修改密码
	public int revise(String newpw, int uid) {
		// TODO Auto-generated method stub
		int i=0;
		//判断用户是否存在
		User user=SelectOne(uid);
		if(user==null) {
			return i;
		}
		//用户存在的情况下
		i=userInter.revise(newpw, uid);
		return i;
	}
	//查询所有用户
	public List<User> SelectAll() {
		// TODO Auto-generated method stub
		List<User> list=userInter.FindAll();
		return list;
	}
	//添加用户
	public int insertOne(int uid, String upw, String uname) {
		// TODO Auto-generated method stub
		int i=userInter.InsertOne(uid,upw,uname);
		return i;
	}
	//删除用户
	public int deleteOne(int uid) {
		// TODO Auto-generated method stub
		int i=userInter.deleteOne(uid);
		return i;
	}

}
