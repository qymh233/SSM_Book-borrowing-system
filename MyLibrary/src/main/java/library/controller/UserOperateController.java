package library.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import library.pojo.Book;
import library.pojo.User;
import library.service.Bookservice;
import library.service.UserService;

@Controller
@RequestMapping("/UserOperateController")
public class UserOperateController {
	@Autowired
	UserService userService;
	@Autowired
	Bookservice bookService;
	//�û��޸�����
	@RequestMapping("newpw.action")
	public ModelAndView newpw(HttpSession session,String newpw) {
		
		ModelAndView mav=new ModelAndView();
		String msg;
		String ret;
		User user=(User)session.getAttribute("user");
		int uid=user.getUid();
		//���벻��Ϊ��
		if(newpw.equals("")||newpw==null) {
			msg="������������";
			mav.addObject("msg",msg);
			mav.setViewName("changepw");
			return mav;
		}
		//�û��޸�����
		int i=userService.revise(newpw, uid);
		//�޸�ʧ��
		if(i<=0) {
			if(user.getBname()==null||user.getBname().equals(" ")){
				ret="��ǰδ�����鼮";
				mav.addObject("ret",ret);
			}else {
				ret=user.getBname();
				mav.addObject("ret",ret);
			}
			msg="�޸�����ʧ��";
			mav.addObject("msg",msg);
			mav.setViewName("success");
			return mav;
		}
		//�޸ĳɹ�
		if(user.getBname()==null||user.getBname().equals(" ")){
			ret="��ǰδ�����鼮";
			mav.addObject("ret",ret);
		}else {
			ret=user.getBname();
			mav.addObject("ret",ret);
		}
		msg="�޸�����ɹ�";
		mav.addObject("msg",msg);
		mav.setViewName("success");
		return mav;
	}
	//�û�����
	@RequestMapping("borrow.action")
	public ModelAndView borrow(HttpSession session,String bid) {
		ModelAndView mav=new ModelAndView();
		String msg;
		String ret;
		int bbid=0;
		User user=(User)session.getAttribute("user");
		//�鼮��Ų���Ϊ��
		if(bid.equals("")||bid==null) {
			msg="ͼ���Ų���Ϊ�գ���������ȷ��ͼ����";
			mav.addObject("msg",msg);
			mav.setViewName("borbook");
			return mav;
		}
		//�ж�ͼ�����Ƿ�Ϊ������
		if(!bid.matches("[0-9]+")) {
			msg="ͼ��������";
			mav.addObject("msg",msg);
			mav.setViewName("borbook");
			return mav;
		}
		bbid=Integer.parseInt(bid);		
		Book book=bookService.FindOne(bbid);
		//�鼮��Ŵ���
		if(book==null) {
			msg="����ʧ��,��������ȷ��ͼ����";
			mav.addObject("msg",msg);
			mav.setViewName("borbook");
			return mav;
		}
		//���Ϊ0�����������
		int booknum=book.getQuantity();
		if(booknum==0) {
			msg="����ʧ��,��ǰͼ����Ϊ0�����Ժ����";
			mav.addObject("msg",msg);
			mav.setViewName("borbook");
			return mav;
		}
		String bname=book.getBname();
		int uid=user.getUid();
		//�������
		int i=userService.borrow(bname, uid);
		//����ʧ��
		if(i<=0) {
			ret="��ǰδ�����鼮";
			mav.addObject("ret",ret);
			msg="����ʧ��";
			mav.addObject("msg",msg);
			mav.setViewName("success");
			return mav;
		}
		//����ɹ�
		user.setBname(bname);
		ret=user.getBname();
		mav.addObject("ret",ret);
		msg="����ɹ�";
		mav.addObject("msg",msg);
		mav.setViewName("success");
		return mav;
	}


}
