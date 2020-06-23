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
		//�ж��˺Ż��������Ƿ�Ϊ��
		if(uid.equals("")||uid==null||upw.equals("")||upw==null) {
			msg="�˺Ų���Ϊ�ջ����벻��Ϊ��";
			mav.addObject("msg",msg);
			mav.setViewName("home");
			return mav;
		}
		//�ж��˺��Ƿ�Ϊ������
		if(!uid.matches("[0-9]+")) {
			msg="�˺ű���Ϊ������";
			mav.addObject("msg",msg);
			mav.setViewName("home");
			return mav;
		}
		uuid=Integer.parseInt(uid);		
		User user=userService.SelectOne(uuid);
		
		if(user==null||!user.getUpw().equals(upw)) {//�û���ѯʧ��
			mav.setViewName("home");
			mav.addObject("msg","�û���½ʧ��");
			return mav;
		}else if(user.getUid()==666666&&user.getUpw().equals(upw)) {//����Ա��½
			mav.addObject("user",user);
			mav.setViewName("manage");
			return mav;
		}
		//��ͨ�û���½
		String ret;
		if(user.getBname()==null||user.getBname().equals(" ")){
			ret="��ǰδ�����鼮";
		}else 
			ret=user.getBname();
		mav.addObject("ret",ret);
		mav.addObject("user",user);
		mav.setViewName("success");
		return mav;
	}
}
