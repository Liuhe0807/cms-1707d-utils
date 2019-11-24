package com.lh.test;


import static org.junit.Assert.*;

import org.junit.Test;

import com.liuhe.StringUtils;


public class TestStringUtils {

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
	
}
