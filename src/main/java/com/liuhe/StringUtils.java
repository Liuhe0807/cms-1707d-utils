package com.liuhe;

import java.sql.Date;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	//字符串工具类
	//判断字符串是否为空
	public static boolean isBlank(String str){
		return (str == null||str.trim().equals(""));

	}
	
	//判断字符串是否有值
	public static boolean haveValue(String str){
		return !(str == null||str.trim().equals(""));

	}
	
	//验证手机号码
	public static boolean isMobile(String str){
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(str);
		return matcher.find();

		
	}
	
	//邮箱验证
	public static boolean isEmail(String str){
		String regex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(str);
		return matcher.find();
		
	}
	
	//获取n位随机英文字符串
	public static String getRandomStr(int n){
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			char c = (char)('A' +random.nextInt(26));
			sb.append(c);
			System.out.println();
		}
		return sb.toString();
		
	}
	//获取n位随机英文和数字字符串
	public static String getRandomStr2(int n){
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			int r = random.nextInt(36);
			if(r<26){
				char c = (char)('A' +r);
			}
			else{
				sb.append(r-26);
			}
			
		}
		return sb.toString();
	}
	//获取随机中文
	public static String getRandomCn(int n){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(getRandomCn());
		}
		return sb.toString();
		
	}
	
	
	//获取随机中文

	public static char getRandomCn(){
		String str = "";
        int hightPos; //
        int lowPos;
        Random random = new Random();

        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("错误");
        }

        	return str.charAt(0);
	}
//	(1)公司名称：以“北京”开头，以“有限公司”或“股份有限公司”或“集团有限公司”结尾，中间使用StringUtil.randomChineseString()方法创建2-4个随机汉字（4分）
	public static String add(){
		
		String [] arr = {"有限公司","股份有限公司","集团有限公司"};
		return "北京"+new StringUtils().getRandomCn(new Random().nextInt(arr.length))+arr[new Random().nextInt(arr.length)];
		
	}
//	(2)法人代表姓名：调用StringUtil.generateChineseName()创建（4分）
	public static String RandomName(){
		int a = (int) (Math.random() * 10);
		return new StringUtils().getRandomCn((a >= 4 ? 3 : (a == 0 ? 2 : a)));
	}
//	(3)注册地址：以“北京市”开头，后面调用StringUtil.randomChineseString()创建20-40个汉字（4分）
	public static String randomChineseString(){
		Random ran = new Random();
		int nextInt = ran.nextInt(20)+20;
		return getRandomCn(nextInt);
	}
	
//	(4)注册资本：调用RandomUtil随机数工具方法生成，值在10万元-10亿元之间（4分）
	public static int getRandomUtil(){
		Random ran = new Random();
		return	(100000 + (ran.nextInt(999900000) * 10));
		
	}	
		
//	(5)营业执照号：调用RandomUtil随机数工具方法生成，以1101开头，加上11位随机数，总共15位。（4分）
	
	public static String RandomUtil(String num){
		return	num + 1000 + (int)(Math.random() * 10000000);
	}
	
//	(6)公司经济类型：调用RandomUtil随机数工具方法，在公司类型表中的所有id中随机抽（4分）
	public static int RandomNum(){
		Random ran = new Random();
		int [] arr = {1,2,3,4,5,6,7,8,9,10,11};
		return	ran.nextInt(arr.length);
	}
	
//	(7)成立时间：模拟从1980年1月1日至今任意随机日期（4分）。
	public static Date randomHireday1() {
		int startYear=1950;
		int endYear=2019;
		int year = (int)(Math.random()*(endYear-startYear+1))+startYear;	//随机年
		int month= (int)(Math.random()*12)+1;								//随机月
		Calendar c = Calendar.getInstance();				//创建Calendar对象
		c.set(year, month, 0);								//设定日期
		int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);		//获取对应年月有几天
		int day=(int)(Math.random()*dayOfMonth+1)	;		//产生随机日
		Date hireday=Date.valueOf(year+"-"+month+"-"+day);	//通过valueOf方法生成Date对象
		return hireday;
	}
	
//	(8)营业期限：在成立时间上延后50年（2分）。
	public static Date randomHireday2() {
		int startYear=1950;
		int endYear=2019;
		int year = (int)(Math.random()*(endYear-startYear+1))+startYear;	//随机年
		int month= (int)(Math.random()*12)+1;								//随机月
		Calendar c = Calendar.getInstance();				//创建Calendar对象
		c.set(year, month, 0);								//设定日期
		int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);		//获取对应年月有几天
		int day=(int)(Math.random()*dayOfMonth+1)	;		//产生随机日
		Date hireday=Date.valueOf(year+"-"+month+"-"+day);	//通过valueOf方法生成Date对象
		c.setTime(hireday);
		c.add(Calendar.YEAR, 50);
		java.util.Date time = c.getTime();
		return new Date(time.getTime()) ;
	}
	
}