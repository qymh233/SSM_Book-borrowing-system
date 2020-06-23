package library.bean;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import library.mapper.BookInter;
import library.mapper.UserInter;
import library.pojo.Book;
import library.pojo.User;
import library.service.Bookservice;
import library.service.UserService;
import library.service.UserServiceImpl;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestDemo {
		// TODO Auto-generated method stub
//		@Test
//		public void test() {
//			ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
//			People people=(People)ac.getBean("People");
//			System.out.println(people);
//			Car car=(Car)ac.getBean("Car");
//			System.out.println(car);
//			//销毁对象
//			((ClassPathXmlApplicationContext)ac).close();
//		}
//		@Test
//		public void tets2() throws IOException {
////			String resource = "spring_mybatis.xml";
////			InputStream inputStream = Resources.getResourceAsStream(resource);
////			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
////			System.out.println(sqlSessionFactory);
//			UserInter userInter=new UsersMapper();
//			User user=userInter.SelectOne(1230001);
//			System.out.println(user);
//		}
		@Autowired
		UserInter UserInter;
		@Autowired
		UserService userService;
		@Autowired
		BookInter bookInter;
		@Autowired
		Bookservice bookService;
		@Test
		public void test1() {
			
			int uid=123005;
			String upw="123456swk";
			String uname="孙悟空";
			String bname="《雪中悍刀行》";
			int bid=2020016;
			int quantity=18;
			List<User> ii=userService.SelectAll();
			for(int i=0;i<ii.size();i++) {
				System.out.println(ii.get(i));
			}
			
		}
}
