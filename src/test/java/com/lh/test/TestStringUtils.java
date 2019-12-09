package com.lh.test;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StreamUtils;

import com.liuhe.StringUtils;


@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class TestStringUtils {

	/*@Autowired
	private CompanyService service;
	//添加1万条数据
	@Test
	public void testAdd(){
		for (int i = 0; i <= 10000; i++) {
			service.add(new Company(null,new StringUtils().add(),new StringUtils().getRandomCn(3),"北京"+new StringUtils().randomChineseString(),new StringUtils().RandomCapital(),new StringUtils().RandomReg_no("1101"),new StringUtils().RandomNum(),new StringUtils().randomHireday1(),new StringUtils().randomHireday2(),null));

		}
	}*/
	
/*	@Test
	public void testIsBlank(){
		
		//断言 真
//		assertTrue(StringUtils.isBlank(""));
		
	}
	
	@Test
	public void testIsBlank2(){
		//断言 假
//		assertFalse(StringUtils.isBlank("aaaa"));
		
		
	}
	@Test
	public void testRandom(){
		String s = StringUtils.getRandomStr(10);
		System.out.println();
		
	}
	
	@Test
	public void testStrland(){
		
		
	}
	
	@Test
	public void testStrCn(){
		
		
	}*/
	
	@Test
	public void testUrl(){
		String url = "www.中国.com";
		boolean httpUrl = StringUtils.isHttpUrl(url);
		System.out.println(httpUrl);
		
	}
	
	
	@Test
	public void testNum(){
		String randomNum = StringUtils.getRandomNum(9);
		
		
	}
}
