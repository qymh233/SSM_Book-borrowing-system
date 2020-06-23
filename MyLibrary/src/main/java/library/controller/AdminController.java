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
		if(submit.equals("添加用户")) {
			mav.setViewName("adduser");
			return mav;
		}else if(submit.equals("删除用户")) {
			mav.setViewName("deluser");
			return mav;
		}else if(submit.equals("修改用户信息")) {
			mav.setViewName("chanceuser");
			return mav;
		}else if(submit.equals("添加图书")) {
			mav.setViewName("addbook");
			return mav;
		}else if(submit.equals("删除图书")) {
			mav.setViewName("delbook");
			return mav;
		}else if(submit.equals("修改图书信息")) {
			mav.setViewName("chancebook");
			return mav;
		}
		//退出登陆
		mav.setViewName("home");
		return mav;
	}
}
