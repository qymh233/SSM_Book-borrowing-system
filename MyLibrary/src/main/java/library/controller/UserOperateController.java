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
	//用户修改密码
	@RequestMapping("newpw.action")
	public ModelAndView newpw(HttpSession session,String newpw) {
		
		ModelAndView mav=new ModelAndView();
		String msg;
		String ret;
		User user=(User)session.getAttribute("user");
		int uid=user.getUid();
		//密码不可为空
		if(newpw.equals("")||newpw==null) {
			msg="请输入新密码";
			mav.addObject("msg",msg);
			mav.setViewName("changepw");
			return mav;
		}
		//用户修改密码
		int i=userService.revise(newpw, uid);
		//修改失败
		if(i<=0) {
			if(user.getBname()==null||user.getBname().equals(" ")){
				ret="当前未借用书籍";
				mav.addObject("ret",ret);
			}else {
				ret=user.getBname();
				mav.addObject("ret",ret);
			}
			msg="修改密码失败";
			mav.addObject("msg",msg);
			mav.setViewName("success");
			return mav;
		}
		//修改成功
		if(user.getBname()==null||user.getBname().equals(" ")){
			ret="当前未借用书籍";
			mav.addObject("ret",ret);
		}else {
			ret=user.getBname();
			mav.addObject("ret",ret);
		}
		msg="修改密码成功";
		mav.addObject("msg",msg);
		mav.setViewName("success");
		return mav;
	}
	//用户借书
	@RequestMapping("borrow.action")
	public ModelAndView borrow(HttpSession session,String bid) {
		ModelAndView mav=new ModelAndView();
		String msg;
		String ret;
		int bbid=0;
		User user=(User)session.getAttribute("user");
		//书籍编号不可为空
		if(bid.equals("")||bid==null) {
			msg="图书标号不可为空，请输入正确的图书编号";
			mav.addObject("msg",msg);
			mav.setViewName("borbook");
			return mav;
		}
		//判断图书标号是否为纯数字
		if(!bid.matches("[0-9]+")) {
			msg="图书编号有误";
			mav.addObject("msg",msg);
			mav.setViewName("borbook");
			return mav;
		}
		bbid=Integer.parseInt(bid);		
		Book book=bookService.FindOne(bbid);
		//书籍编号错误
		if(book==null) {
			msg="借书失败,请输入正确的图书编号";
			mav.addObject("msg",msg);
			mav.setViewName("borbook");
			return mav;
		}
		//库存为0，不允许借书
		int booknum=book.getQuantity();
		if(booknum==0) {
			msg="借书失败,当前图书库存为0，请稍后借书";
			mav.addObject("msg",msg);
			mav.setViewName("borbook");
			return mav;
		}
		String bname=book.getBname();
		int uid=user.getUid();
		//借书操作
		int i=userService.borrow(bname, uid);
		//借书失败
		if(i<=0) {
			ret="当前未借用书籍";
			mav.addObject("ret",ret);
			msg="借书失败";
			mav.addObject("msg",msg);
			mav.setViewName("success");
			return mav;
		}
		//借书成功
		user.setBname(bname);
		ret=user.getBname();
		mav.addObject("ret",ret);
		msg="借书成功";
		mav.addObject("msg",msg);
		mav.setViewName("success");
		return mav;
	}


}
