package library.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import library.pojo.User;
import library.service.UserService;

@Controller
@RequestMapping("/AdminOperateController")
public class AdminOperateController {

	@Autowired
	UserService userService;
	//����û�
	@RequestMapping("adduser.action")
	public ModelAndView adduser(HttpSession session,String uid,String upw,String uname) {
		ModelAndView mav=new ModelAndView();
		String msg;
		int uuid=0;
		//�ж������Ƿ�Ϊ��
		if(uid.equals("")||uid==null||upw.equals("")||upw==null||uname.equals("")||uname==null) {
			msg="���������б�Ҫ��Ϣ";
			mav.addObject("msg",msg);
			mav.setViewName("adduser");
			return mav;
		}
		//�ж��˺��Ƿ�Ϊ������
		if(!uid.matches("[0-9]+")) {
			msg="�˺ű���Ϊ������";
			mav.addObject("msg",msg);
			mav.setViewName("adduser");
			return mav;
		}
		uuid=Integer.parseInt(uid);
		//��ѯ�û��Ƿ��Ѿ�����
		User user=userService.SelectOne(uuid);
		if(user!=null) {
			msg="���û��Ѿ�����ע��";
			mav.addObject("msg",msg);
			mav.setViewName("adduser");
			return mav;
		}
		//�û������ھ�����û�
		int i=userService.insertOne(uuid, upw, uname);
		if(i<=0) {
			msg="�û����ʧ��";
			mav.addObject("msg",msg);
			mav.setViewName("adduser");
			return mav;
		}
		msg="�û���ӳɹ�";
		mav.addObject("msg",msg);
		mav.setViewName("manage");
		return mav;
	}
	//ɾ���û�
	@RequestMapping("deluser.action")
	public ModelAndView deluser(HttpSession session,String uid) {
		ModelAndView mav=new ModelAndView();
		String msg;
		int uuid=0;
		//�ж������Ƿ�Ϊ��
		if(uid.equals("")||uid==null) {
			msg="���������б�Ҫ��Ϣ";
			mav.addObject("msg",msg);
			mav.setViewName("deluser");
			return mav;
		}
		//�ж��˺��Ƿ�Ϊ������
		if(!uid.matches("[0-9]+")) {
			msg="�˺ű���Ϊ������";
			mav.addObject("msg",msg);
			mav.setViewName("deluser");
			return mav;
		}
		uuid=Integer.parseInt(uid);
		//�ж��û��Ƿ����
		User user=userService.SelectOne(uuid);
		if(user==null) {
			msg="���û�������";
			mav.addObject("msg",msg);
			mav.setViewName("deluser");
			return mav;
		}
		//���û����ڣ��ͽ���ɾ��
		int i=userService.deleteOne(uuid);
		if(i<=0) {
			msg="�û�ɾ��ʧ��";
			mav.addObject("msg",msg);
			mav.setViewName("deluser");
			return mav;
		}
		msg="�û�ɾ���ɹ�";
		mav.addObject("msg",msg);
		mav.setViewName("manage");
		return mav;
	}
	//�޸��û���Ϣ
	@RequestMapping("chanceuser.action")
	public ModelAndView chanceuser(HttpSession session,String uid,String newpw) {
		ModelAndView mav=new ModelAndView();
		String msg;
		int uuid=0;
		//�ж������Ƿ�Ϊ��
		if(uid.equals("")||uid==null||newpw.equals("")||newpw==null) {
			msg="���������б�Ҫ��Ϣ";
			mav.addObject("msg",msg);
			mav.setViewName("chanceuser");
			return mav;
		}
		//�ж��˺��Ƿ�Ϊ������
		if(!uid.matches("[0-9]+")) {
			msg="�˺ű���Ϊ������";
			mav.addObject("msg",msg);
			mav.setViewName("chanceuser");
			return mav;
		}
		uuid=Integer.parseInt(uid);
		//�ж��û��Ƿ����
		User user=userService.SelectOne(uuid);
		if(user==null) {
			msg="���û�������";
			mav.addObject("msg",msg);
			mav.setViewName("chanceuser");
			return mav;
		}
		//�û����ھ��޸��û�
		int i=userService.revise(newpw, uuid);
		if(i<=0) {
			msg="�û��޸�ʧ��";
			mav.addObject("msg",msg);
			mav.setViewName("chanceuser");
			return mav;
		}
		msg="�û��޸ĳɹ�";
		mav.addObject("msg",msg);
		mav.setViewName("manage");
		return mav;
	}
}
