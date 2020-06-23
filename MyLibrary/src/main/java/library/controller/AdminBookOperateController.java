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
	//���ͼ��
	@RequestMapping("addbook.action")
	public ModelAndView addbook(HttpSession session,String bid,String bname,String quantity) {
		ModelAndView mav=new ModelAndView();
		String msg;
		int bbid=0;
		int qquantity=0;
		String bbname="";
		//�ж������Ƿ�Ϊ��
		if(bid.equals("")||bid==null||bname.equals("")||bname==null||quantity.equals("")||quantity==null) {
			msg="���������б�Ҫ��Ϣ";
			mav.addObject("msg",msg);
			mav.setViewName("addbook");
			return mav;
		}
		//�ж��˺��Ƿ�Ϊ������
		if(!bid.matches("[0-9]+")) {
			msg="�˺ű���Ϊ������";
			mav.addObject("msg",msg);
			mav.setViewName("addbook");
			return mav;
		}
		//�ж�ͼ�������Ƿ�Ϊ������
		if(!quantity.matches("[0-9]+")) {
			msg="ͼ����������Ϊ������";
			mav.addObject("msg",msg);
			mav.setViewName("addbook");
			return mav;
		}
		bbid=Integer.parseInt(bid);
		//��ѯͼ���Ƿ��Ѿ�����
		Book book=bookService.FindOne(bbid);
		if(book!=null) {
			msg="�ֿ��Ѿ��и�ͼ��";
			mav.addObject("msg",msg);
			mav.setViewName("addbook");
			return mav;
		}
		//ͼ�鲻���ھ����ͼ��
		qquantity=Integer.parseInt(quantity);
		bbname="��"+bname+"��";
		int i=bookService.insertOne(bbid, bbname, qquantity);
		if(i<=0) {
			msg="ͼ�����ʧ��";
			mav.addObject("msg",msg);
			mav.setViewName("addbook");
			return mav;
		}
		msg="ͼ����ӳɹ�";
		mav.addObject("msg",msg);
		mav.setViewName("manage");
		return mav;
	}
	//ɾ��ͼ��
	@RequestMapping("delbook.action")
	public ModelAndView delbook(HttpSession session,String bid) {
		ModelAndView mav=new ModelAndView();
		String msg;
		int bbid=0;
		//�ж������Ƿ�Ϊ��
		if(bid.equals("")||bid==null) {
			msg="������ͼ����";
			mav.addObject("msg",msg);
			mav.setViewName("delbook");
			return mav;
		}
		//�ж�ͼ�����Ƿ�Ϊ������
		if(!bid.matches("[0-9]+")) {
			msg="ͼ���ű���Ϊ������";
			mav.addObject("msg",msg);
			mav.setViewName("delbook");
			return mav;
		}
		bbid=Integer.parseInt(bid);
		//�ж�ͼ���Ƿ����
		Book book=bookService.FindOne(bbid);
		if(book==null) {
			msg="��ͼ�鲻����";
			mav.addObject("msg",msg);
			mav.setViewName("delbook");
			return mav;
		}
		//��ͼ����ڣ��ͽ���ɾ��
		int i=bookService.deleteOne(bbid);
		if(i<=0) {
			msg="ͼ��ɾ��ʧ��";
			mav.addObject("msg",msg);
			mav.setViewName("delbook");
			return mav;
		}
		msg="ͼ��ɾ���ɹ�";
		mav.addObject("msg",msg);
		mav.setViewName("manage");
		return mav;
	}
	//�޸�ͼ����Ϣ
	@RequestMapping("chancebook.action")
	public ModelAndView chancebook(HttpSession session,String bid,String quantity) {
		ModelAndView mav=new ModelAndView();
		String msg;
		int bbid=0;
		int qquantity=0;
		//�ж������Ƿ�Ϊ��
		if(bid.equals("")||bid==null||quantity.equals("")||quantity==null) {
			msg="���������б�Ҫ��Ϣ";
			mav.addObject("msg",msg);
			mav.setViewName("chancebook");
			return mav;
		}
		//�ж��˺��Ƿ�Ϊ������
		if(!bid.matches("[0-9]+")) {
			msg="�˺ű���Ϊ������";
			mav.addObject("msg",msg);
			mav.setViewName("chancebook");
			return mav;
		}
		//�ж�ͼ�������Ƿ�Ϊ������
		if(!quantity.matches("[0-9]+")) {
			msg="ͼ����������Ϊ������";
			mav.addObject("msg",msg);
			mav.setViewName("chancebook");
			return mav;
		}
		bbid=Integer.parseInt(bid);
		Book book=bookService.FindOne(bbid);
		if(book==null) {
			msg="��ͼ�鲻����";
			mav.addObject("msg",msg);
			mav.setViewName("chancebook");
			return mav;
		}
		//��ͼ����ڣ��ͽ����޸�
		qquantity=Integer.parseInt(quantity);
		int i=bookService.chanceBook(bbid, qquantity);
		if(i<=0) {
			msg="ͼ�������޸�ʧ��";
			mav.addObject("msg",msg);
			mav.setViewName("chancebook");
			return mav;
		}
		msg="ͼ�������޸ĳɹ�";
		mav.addObject("msg",msg);
		mav.setViewName("manage");
		return mav;
	}
}
