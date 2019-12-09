package com.lh.test;



import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.liuhe.DateUtils;
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class TestDate {

/*	@Test
	public void testDate(){
		DateUtils.compare(null, new Date());
	}*/
	

/*	@Test
	public void testAge(){
		Date date = new Date();
//		assertTrue(0==DateUtils.claculateAge(date));
		
		Date date2 = new Date(17, 8, 9);
		int age = DateUtils.claculateAge(date2);
		System.out.println("age是："+age);
		
	}
	
	@Test
	public void testBOM(){
		Date bom = DateUtils.getBOM(new Date());
		System.out.println("BOM is"+bom);
	}
	
	@Test
	public void testEom(){
		Date eom = DateUtils.getBOM(new Date());
		System.out.println("EOM is"+eom);
	}
	*/
}
