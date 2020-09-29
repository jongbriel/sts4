package com.itwill3.dao.guest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill3.dao.guest.GuestDao;
import com.itwill3.dao.guest.GuestDaoImplMyBatis;

public class GuestDaoimplMyBatisTestMain {

	public static void main(String[] args)throws Exception {
		/*
		GuestDao guestDao=new GuestDaoImplMyBatis();
		System.out.println("### "+guestDao.selectAll());
		System.out.println("### "+guestDao.selectByNo(81));
		*/
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext(
						"com/itwill3/dao/guest/guest-dao-mybatis.xml");
		GuestDao guestDao=(GuestDao)applicationContext.getBean("guestDao");
		System.out.println("### "+guestDao.selectAll());
		System.out.println("### "+guestDao.selectByNo(51));
		
	}

}
