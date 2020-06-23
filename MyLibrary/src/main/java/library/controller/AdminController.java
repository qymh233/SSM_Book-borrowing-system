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
@RequestMapping("/AdminController")
@SessionAttributes(value= {"books","readers"})
public class AdminController {

	@Autowired
	UserService userService;
	@Autowired
	Bookservice bookService;
	@RequestMapping("admin.action")
	public ModelAndView Jump(HttpSession session,String submit) {
		ModelAndView mav=new ModelAndView();
		String msg;
		List<Book> blist=bookService.SelectAll();
		List<User> ulist=userService.SelectAll();
		mav.addObject("books", blist);
		mav.addObject("readers", ulist);
		if(submit.equals("����û�")) {
			mav.setViewName("adduser");
			return mav;
		}else if(submit.equals("ɾ���û�")) {
			mav.setViewName("deluser");
			return mav;
		}else if(submit.equals("�޸��û���Ϣ")) {
			mav.setViewName("chanceuser");
			return mav;
		}else if(submit.equals("���ͼ��")) {
			mav.setViewName("addbook");
			return mav;
		}else if(submit.equals("ɾ��ͼ��")) {
			mav.setViewName("delbook");
			return mav;
		}else if(submit.equals("�޸�ͼ����Ϣ")) {
			mav.setViewName("chancebook");
			return mav;
		}
		//�˳���½
		mav.setViewName("home");
		return mav;
	}
}
