package library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import library.pojo.User;
import library.service.UserService;

@Controller
@RequestMapping("/UserController")
@SessionAttributes("user")
public class UserController {
	
	@Autowired
	UserService userService;
	@RequestMapping("one.action")
	public ModelAndView SelectOne(String uid,String upw) {
		ModelAndView mav=new ModelAndView();
		int uuid=0;
		String msg;
		//判断账号或者密码是否为空
		if(uid.equals("")||uid==null||upw.equals("")||upw==null) {
			msg="账号不可为空或密码不可为空";
			mav.addObject("msg",msg);
			mav.setViewName("home");
			return mav;
		}
		//判断账号是否为纯数字
		if(!uid.matches("[0-9]+")) {
			msg="账号必须为纯数字";
			mav.addObject("msg",msg);
			mav.setViewName("home");
			return mav;
		}
		uuid=Integer.parseInt(uid);		
		User user=userService.SelectOne(uuid);
		
		if(user==null||!user.getUpw().equals(upw)) {//用户查询失败
			mav.setViewName("home");
			mav.addObject("msg","用户登陆失败");
			return mav;
		}else if(user.getUid()==666666&&user.getUpw().equals(upw)) {//管理员登陆
			mav.addObject("user",user);
			mav.setViewName("manage");
			return mav;
		}
		//普通用户登陆
		String ret;
		if(user.getBname()==null||user.getBname().equals(" ")){
			ret="当前未借用书籍";
		}else 
			ret=user.getBname();
		mav.addObject("ret",ret);
		mav.addObject("user",user);
		mav.setViewName("success");
		return mav;
	}
}
