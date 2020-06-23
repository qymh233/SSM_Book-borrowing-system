package library.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import library.pojo.Book;
import library.pojo.User;
import library.service.Bookservice;
import library.service.UserService;

@Controller
@RequestMapping("/SuccessController")
@SessionAttributes("books")
public class SuccessController {
	@Autowired
	UserService userService;
	@Autowired
	Bookservice bookService;
	@RequestMapping("suc.action")
	public ModelAndView Jump(HttpSession session,String submit) {
		User user=(User)session.getAttribute("user");
		//System.out.println(user.toString());
		ModelAndView mav=new ModelAndView();
		String msg;
		String ret;
		//�ж��û�ѡ��Ĳ���
		if(submit.equals("�����鼮")) {
			//��ǰû�����ʱ���������
			if(user.getBname()==null||user.getBname().equals(" ")){
				List<Book> list=bookService.SelectAll();
				mav.addObject("books", list);
				mav.addObject("user",user);
				mav.setViewName("borbook");
				return mav;
			}
			//��ǰ�û������鼮���޷������鼮
			ret=user.getBname();
			mav.addObject("ret",ret);
			msg="�����˻���ǰ�����鼮";
			mav.addObject("msg",msg);
			mav.setViewName("success");
			return mav;
			
		}else if(submit.equals("�黹�鼮")) {
			//��ǰû�����ʱ���������
			if(user.getBname()==null||user.getBname().equals(" ")){
				ret="��ǰδ�����鼮";
				mav.addObject("ret",ret);
				msg="δ�������鼮";
				mav.addObject("msg",msg);
				mav.setViewName("success");
				return mav;
			}
			String bname=user.getBname();
			int uid=user.getUid();
			//�û��������
			int i=userService.give(bname, uid);
			if(i>0) {
				user.setBname(null);
				ret="��ǰδ�����鼮";
				mav.addObject("ret",ret);
				msg="�黹�鼮�ɹ�";
				mav.addObject("msg",msg);
				mav.setViewName("success");
				return mav;
			}else {
				ret=user.getBname();
				mav.addObject("ret",ret);
				msg="�黹�鼮ʧ��";
				mav.addObject("msg",msg);
				mav.setViewName("success");
				return mav;
			}
		}else if(submit.equals("�޸�����")) {
			mav.addObject("user",user);
			mav.setViewName("changepw");
			return mav;
		}
		//�˳���½
		mav.setViewName("home");
		return mav;
	}
}
