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
	//添加用户
	@RequestMapping("adduser.action")
	public ModelAndView adduser(HttpSession session,String uid,String upw,String uname) {
		ModelAndView mav=new ModelAndView();
		String msg;
		int uuid=0;
		//判断输入是否为空
		if(uid.equals("")||uid==null||upw.equals("")||upw==null||uname.equals("")||uname==null) {
			msg="请输入所有必要信息";
			mav.addObject("msg",msg);
			mav.setViewName("adduser");
			return mav;
		}
		//判断账号是否为纯数字
		if(!uid.matches("[0-9]+")) {
			msg="账号必须为纯数字";
			mav.addObject("msg",msg);
			mav.setViewName("adduser");
			return mav;
		}
		uuid=Integer.parseInt(uid);
		//查询用户是否已经存在
		User user=userService.SelectOne(uuid);
		if(user!=null) {
			msg="该用户已经进行注册";
			mav.addObject("msg",msg);
			mav.setViewName("adduser");
			return mav;
		}
		//用户不存在就添加用户
		int i=userService.insertOne(uuid, upw, uname);
		if(i<=0) {
			msg="用户添加失败";
			mav.addObject("msg",msg);
			mav.setViewName("adduser");
			return mav;
		}
		msg="用户添加成功";
		mav.addObject("msg",msg);
		mav.setViewName("manage");
		return mav;
	}
	//删除用户
	@RequestMapping("deluser.action")
	public ModelAndView deluser(HttpSession session,String uid) {
		ModelAndView mav=new ModelAndView();
		String msg;
		int uuid=0;
		//判断输入是否为空
		if(uid.equals("")||uid==null) {
			msg="请输入所有必要信息";
			mav.addObject("msg",msg);
			mav.setViewName("deluser");
			return mav;
		}
		//判断账号是否为纯数字
		if(!uid.matches("[0-9]+")) {
			msg="账号必须为纯数字";
			mav.addObject("msg",msg);
			mav.setViewName("deluser");
			return mav;
		}
		uuid=Integer.parseInt(uid);
		//判断用户是否存在
		User user=userService.SelectOne(uuid);
		if(user==null) {
			msg="该用户不存在";
			mav.addObject("msg",msg);
			mav.setViewName("deluser");
			return mav;
		}
		//若用户存在，就进行删除
		int i=userService.deleteOne(uuid);
		if(i<=0) {
			msg="用户删除失败";
			mav.addObject("msg",msg);
			mav.setViewName("deluser");
			return mav;
		}
		msg="用户删除成功";
		mav.addObject("msg",msg);
		mav.setViewName("manage");
		return mav;
	}
	//修改用户信息
	@RequestMapping("chanceuser.action")
	public ModelAndView chanceuser(HttpSession session,String uid,String newpw) {
		ModelAndView mav=new ModelAndView();
		String msg;
		int uuid=0;
		//判断输入是否为空
		if(uid.equals("")||uid==null||newpw.equals("")||newpw==null) {
			msg="请输入所有必要信息";
			mav.addObject("msg",msg);
			mav.setViewName("chanceuser");
			return mav;
		}
		//判断账号是否为纯数字
		if(!uid.matches("[0-9]+")) {
			msg="账号必须为纯数字";
			mav.addObject("msg",msg);
			mav.setViewName("chanceuser");
			return mav;
		}
		uuid=Integer.parseInt(uid);
		//判断用户是否存在
		User user=userService.SelectOne(uuid);
		if(user==null) {
			msg="该用户不存在";
			mav.addObject("msg",msg);
			mav.setViewName("chanceuser");
			return mav;
		}
		//用户存在就修改用户
		int i=userService.revise(newpw, uuid);
		if(i<=0) {
			msg="用户修改失败";
			mav.addObject("msg",msg);
			mav.setViewName("chanceuser");
			return mav;
		}
		msg="用户修改成功";
		mav.addObject("msg",msg);
		mav.setViewName("manage");
		return mav;
	}
}
