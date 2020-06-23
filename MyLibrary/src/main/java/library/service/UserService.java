package library.service;

import java.util.List;

import library.pojo.User;

public interface UserService {
	//�û���½
	User SelectOne(int uid);
	//�û�����
	int borrow(String bname,int uid);
	//�û�����
	int give(String bname,int uid);
	//�û��޸�����
	int revise(String newpw,int uid);
	//��ѯ�����û�
	List<User> SelectAll();
	//����û�
	int insertOne(int uid,String upw,String uname);
	//ɾ���û�
	int deleteOne(int uid);
}
