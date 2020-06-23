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
		//判断用户选择的操作
		if(submit.equals("借用书籍")) {
			//当前没有书的时候允许借书
			if(user.getBname()==null||user.getBname().equals(" ")){
				List<Book> list=bookService.SelectAll();
				mav.addObject("books", list);
				mav.addObject("user",user);
				mav.setViewName("borbook");
				return mav;
			}
			//当前用户持有书籍，无法借用书籍
			ret=user.getBname();
			mav.addObject("ret",ret);
			msg="请先退还当前所借书籍";
			mav.addObject("msg",msg);
			mav.setViewName("success");
			return mav;
			
		}else if(submit.equals("归还书籍")) {
			//当前没有书的时候不允许操作
			if(user.getBname()==null||user.getBname().equals(" ")){
				ret="当前未借用书籍";
				mav.addObject("ret",ret);
				msg="未曾借用书籍";
				mav.addObject("msg",msg);
				mav.setViewName("success");
				return mav;
			}
			String bname=user.getBname();
			int uid=user.getUid();
			//用户还书操作
			int i=userService.give(bname, uid);
			if(i>0) {
				user.setBname(null);
				ret="当前未借用书籍";
				mav.addObject("ret",ret);
				msg="归还书籍成功";
				mav.addObject("msg",msg);
				mav.setViewName("success");
				return mav;
			}else {
				ret=user.getBname();
				mav.addObject("ret",ret);
				msg="归还书籍失败";
				mav.addObject("msg",msg);
				mav.setViewName("success");
				return mav;
			}
		}else if(submit.equals("修改密码")) {
			mav.addObject("user",user);
			mav.setViewName("changepw");
			return mav;
		}
		//退出登陆
		mav.setViewName("home");
		return mav;
	}
}
