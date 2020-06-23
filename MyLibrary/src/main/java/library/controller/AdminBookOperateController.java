package library.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import library.pojo.Book;
import library.service.Bookservice;

@Controller
@RequestMapping("/AdminBookOperateController")
public class AdminBookOperateController {

	@Autowired
	Bookservice bookService;
	//添加图书
	@RequestMapping("addbook.action")
	public ModelAndView addbook(HttpSession session,String bid,String bname,String quantity) {
		ModelAndView mav=new ModelAndView();
		String msg;
		int bbid=0;
		int qquantity=0;
		String bbname="";
		//判断输入是否为空
		if(bid.equals("")||bid==null||bname.equals("")||bname==null||quantity.equals("")||quantity==null) {
			msg="请输入所有必要信息";
			mav.addObject("msg",msg);
			mav.setViewName("addbook");
			return mav;
		}
		//判断账号是否为纯数字
		if(!bid.matches("[0-9]+")) {
			msg="账号必须为纯数字";
			mav.addObject("msg",msg);
			mav.setViewName("addbook");
			return mav;
		}
		//判断图书数量是否为纯数字
		if(!quantity.matches("[0-9]+")) {
			msg="图书数量必须为纯数字";
			mav.addObject("msg",msg);
			mav.setViewName("addbook");
			return mav;
		}
		bbid=Integer.parseInt(bid);
		//查询图书是否已经存在
		Book book=bookService.FindOne(bbid);
		if(book!=null) {
			msg="仓库已经有该图书";
			mav.addObject("msg",msg);
			mav.setViewName("addbook");
			return mav;
		}
		//图书不存在就添加图书
		qquantity=Integer.parseInt(quantity);
		bbname="《"+bname+"》";
		int i=bookService.insertOne(bbid, bbname, qquantity);
		if(i<=0) {
			msg="图书添加失败";
			mav.addObject("msg",msg);
			mav.setViewName("addbook");
			return mav;
		}
		msg="图书添加成功";
		mav.addObject("msg",msg);
		mav.setViewName("manage");
		return mav;
	}
	//删除图书
	@RequestMapping("delbook.action")
	public ModelAndView delbook(HttpSession session,String bid) {
		ModelAndView mav=new ModelAndView();
		String msg;
		int bbid=0;
		//判断输入是否为空
		if(bid.equals("")||bid==null) {
			msg="请输入图书编号";
			mav.addObject("msg",msg);
			mav.setViewName("delbook");
			return mav;
		}
		//判断图书编号是否为纯数字
		if(!bid.matches("[0-9]+")) {
			msg="图书编号必须为纯数字";
			mav.addObject("msg",msg);
			mav.setViewName("delbook");
			return mav;
		}
		bbid=Integer.parseInt(bid);
		//判断图书是否存在
		Book book=bookService.FindOne(bbid);
		if(book==null) {
			msg="该图书不存在";
			mav.addObject("msg",msg);
			mav.setViewName("delbook");
			return mav;
		}
		//若图书存在，就进行删除
		int i=bookService.deleteOne(bbid);
		if(i<=0) {
			msg="图书删除失败";
			mav.addObject("msg",msg);
			mav.setViewName("delbook");
			return mav;
		}
		msg="图书删除成功";
		mav.addObject("msg",msg);
		mav.setViewName("manage");
		return mav;
	}
	//修改图书信息
	@RequestMapping("chancebook.action")
	public ModelAndView chancebook(HttpSession session,String bid,String quantity) {
		ModelAndView mav=new ModelAndView();
		String msg;
		int bbid=0;
		int qquantity=0;
		//判断输入是否为空
		if(bid.equals("")||bid==null||quantity.equals("")||quantity==null) {
			msg="请输入所有必要信息";
			mav.addObject("msg",msg);
			mav.setViewName("chancebook");
			return mav;
		}
		//判断账号是否为纯数字
		if(!bid.matches("[0-9]+")) {
			msg="账号必须为纯数字";
			mav.addObject("msg",msg);
			mav.setViewName("chancebook");
			return mav;
		}
		//判断图书数量是否为纯数字
		if(!quantity.matches("[0-9]+")) {
			msg="图书数量必须为纯数字";
			mav.addObject("msg",msg);
			mav.setViewName("chancebook");
			return mav;
		}
		bbid=Integer.parseInt(bid);
		Book book=bookService.FindOne(bbid);
		if(book==null) {
			msg="该图书不存在";
			mav.addObject("msg",msg);
			mav.setViewName("chancebook");
			return mav;
		}
		//若图书存在，就进行修改
		qquantity=Integer.parseInt(quantity);
		int i=bookService.chanceBook(bbid, qquantity);
		if(i<=0) {
			msg="图书数量修改失败";
			mav.addObject("msg",msg);
			mav.setViewName("chancebook");
			return mav;
		}
		msg="图书数量修改成功";
		mav.addObject("msg",msg);
		mav.setViewName("manage");
		return mav;
	}
}
