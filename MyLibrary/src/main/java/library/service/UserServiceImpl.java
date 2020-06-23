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
	//�û���½
	public User SelectOne(int uid) {
		// TODO Auto-generated method stub
		User user =userInter.SelectOne(uid);
		return user;
	}
	//�û�����
	public int borrow(String bname, int uid) {
		// TODO Auto-generated method stub
		int i=0;
		int j=0;
		//�������
		i=userInter.borrow(bname, uid);
		if(i>0) {	
			//ͼ��������һ
			j=bookInter.ReduceQuantity(bname);
			if(j>0) {
				return j;
			}
			return -1;
		}
		return j;
	}
	//�û�����
	public int give(String bname, int uid) {
		// TODO Auto-generated method stub
		int i=0;
		int j=0;
		//�������
		i=userInter.give(bname, uid);
		if(i>0) {	
			//ͼ��������һ
			j=bookInter.AddQuantity(bname);
			if(j>0) {
				return j;
			}
			return -1;
		}
		return j;
	}
	//�û��޸�����
	public int revise(String newpw, int uid) {
		// TODO Auto-generated method stub
		int i=0;
		//�ж��û��Ƿ����
		User user=SelectOne(uid);
		if(user==null) {
			return i;
		}
		//�û����ڵ������
		i=userInter.revise(newpw, uid);
		return i;
	}
	//��ѯ�����û�
	public List<User> SelectAll() {
		// TODO Auto-generated method stub
		List<User> list=userInter.FindAll();
		return list;
	}
	//����û�
	public int insertOne(int uid, String upw, String uname) {
		// TODO Auto-generated method stub
		int i=userInter.InsertOne(uid,upw,uname);
		return i;
	}
	//ɾ���û�
	public int deleteOne(int uid) {
		// TODO Auto-generated method stub
		int i=userInter.deleteOne(uid);
		return i;
	}

}
