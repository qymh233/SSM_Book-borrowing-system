package library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import library.pojo.User;

public interface UserInter {
	//�û���½
	User SelectOne(int uid);
	//�û�����
	int borrow(@Param("bname")String bname,@Param("uid")int uid);
	//�û�����
	int give(@Param("bname")String bname,@Param("uid")int uid);
	//�û��޸�����
	int revise(@Param("newpw")String newpw,@Param("uid")int uid);
	//��ѯ�����û�
	List<User> FindAll();
	//����û�
	int InsertOne(@Param("uid")int uid,@Param("upw")String upw,@Param("uname")String uname);
	//ɾ���û�
	int deleteOne(int uid);
}
