package library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import library.bean.Car;
import library.bean.People;
import library.controller.UserController;
public class Libtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		UserController userController=new UserController();
//		userController.login("123", 123);
		
//		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
//		People people=(People)ac.getBean("People");
//		System.out.println(people);
//		Car car=(Car)ac.getBean("Car");
//		System.out.println(car);
//		//Ïú»Ù¶ÔÏó
//		((ClassPathXmlApplicationContext)ac).close();
		String aString="123456";
		String cString="123456ll";
		if(aString.matches("[0-9]+")) {
		int b=Integer.parseInt(aString);
		System.out.println(b);
		}
		if(!cString.matches("[0-9]+")) {
		//int d=Integer.parseInt(cString);
		System.out.println("adad");
		}
	}

}
