package com.liuhe;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;


public class DateUtils {

	static final long millionSecondsPerDay = 1000*60*60*24;
	
	
	//Logger log = Logger.getLogger(UserController.class);
	
	/*
	@Value("${upload.path}")
	static String updloadPath;
	*/
	
	//计算从开始日期计算到现在的年龄
	public static int getAge(Date birthday){
		Calendar now = Calendar.getInstance();
		//创建日期格式化日历对象
		//将日期格式化
		now.setTime(new Date());
		
		//用户生日
		Calendar bir = Calendar.getInstance();
		bir.setTime(birthday);
		
		//定义变量
		int age;
		//判断生日是不是当前日期之后
		if(bir.after(now)){
			throw new RuntimeException("Please enter the correct date of birth");
		}else{
			//生日减去当前日期的年 得出年龄
			age = now.get(Calendar.YEAR) - bir.get(Calendar.YEAR);
			//判断年龄  DAY_OF_YEAR获取当前日期是今年的第几天  要是大于  就+1
			if(now.get(Calendar.DAY_OF_YEAR) > bir.get(Calendar.DAY_OF_YEAR)){
				age += 1;
			}
		}
		return age;
	}
	
	/*@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		Driver login = (Driver) request.getSession().getAttribute("user");
		if(login==null){
			request.getRequestDispatcher("/login").forward(request, response);
			return false;
		}
		drtiverypte	car_type	1125car	t_driver_type	code	CASCADE	CASCADE	

		code	driver_type	1125car	t_driver_type	code	CASCADE	CASCADE	

		return true;
	}*/
	
	//上传工具类
	public static String processFile(MultipartFile file,String updloadPath) throws Exception{
		String suffixName =  file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
    	String fileNamePre = UUID.randomUUID().toString();
    	// 计算出新的文件名称
    	String fileName = fileNamePre + suffixName;
    	
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    	String path = dateFormat.format(new Date());
    	File pathFile  = new File(updloadPath + "/" + path);
    	if(!pathFile.exists()) {
    		pathFile.mkdirs();
    	}
    	
    	// 最终的新的文件名称
    	String newFileName = updloadPath + "/"+ path + "/" + fileName;
    	file.transferTo(new File(newFileName));
    	
    	return path + "/" + fileName ;
	}
	
	//日期排序
	public static int compare(Date date1,Date date2){
		if(date1 == null||date2 == null)
			throw new RuntimeException("参数不能为空");
		
		return date1.compareTo(date2);
		
	}
	
	//计算年龄生日转年龄
	public static int claculateAge(Date birthday){
		if(birthday.compareTo(new Date())>0){
			throw new RuntimeException("给定的生日不能大于当前日期"+ birthday);
			
		}
		
		
		//计算生日的年月日
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(birthday);
		int bdYear = calendar.get(Calendar.YEAR);//出生的年份
		int bdMonth = calendar.get(Calendar.MONTH);//出生的月份
		int bdDay = calendar.get(Calendar.DAY_OF_MONTH);//出生的天
		
		System.out.println("bdYear"+bdYear+"bdMonth:"+bdMonth+"bdDay:"+bdDay);
		//计算当前生日的年月日
		calendar.setTime(new Date());
		int currentYear = calendar.get(Calendar.YEAR);//出生的年份
		int currentMonth = calendar.get(Calendar.MONTH);//出生的月份
		int currentDay = calendar.get(Calendar.DAY_OF_MONTH);//出生的天
		
		System.out.println("currentYear"+currentYear+"currentMonth:"+currentMonth+"currentDay:"+currentDay);

		int age = currentYear-bdYear;
		if(currentMonth<bdMonth){
			age--;
		}
		else if(currentMonth==bdMonth&&currentDay<bdDay){
			age--;
		}
		
		
		return age;
	}
	//计算到将来一个日期 还剩余多少天 
	public static int remainDays(Date futureDate) throws CmsException{
		//给定的参数是否合法，小于当前日期则认为不合法，抛出异常
		if(futureDate.compareTo(new Date())<0){
			throw new CmsException("未来日期不能小于当前日期"+futureDate);
		}
		
		int days = (int) ((futureDate.getTime()-new Date().getTime())/millionSecondsPerDay);
		return days;
		
	}
	/*<table>

	<tr>
	<td>收藏地址：</td>
	</tr>
	<tr>
	<c:forEach items="${list }" var="l">

	<td><a href="">${l.title }</a></td>
	</c:forEach>
	</tr>
	</table>*/
	//判断是否为今天
	public static boolean isToday(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		//获取日期的字符串
		String dateStr = sdf.format(date);
		//获取今天的字符串
		String todayStr = sdf.format(new Date());
		return (dateStr.equals(todayStr));
		
	}
	
	
	
	//判断是否为本月
	public boolean isThisMonth(Date date){
		
		return false;
		
	}
	
	public static boolean isThisWeek(Date date) {
		
	    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	    Calendar firstDayOfWeek = Calendar.getInstance(Locale.getDefault());
	    firstDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);
	    int day = firstDayOfWeek.get(Calendar.DAY_OF_WEEK);
	    firstDayOfWeek.add(Calendar.DATE, -day+1+1);// 后面的+1是因为从周日开始
	    // 本周一的日期
	    System.out.println(format.format(firstDayOfWeek.getTime()));
	     
	    Calendar lastDayOfWeek = Calendar.getInstance(Locale.getDefault());
	    lastDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);
	    day = lastDayOfWeek.get(Calendar.DAY_OF_WEEK);
	    lastDayOfWeek.add(Calendar.DATE, 7-day+1);
	    // 本周星期天的日期
	    System.out.println(format.format(lastDayOfWeek.getTime()));
	    
	    return (date.getTime()<lastDayOfWeek.getTime().getTime() && date.getTime()>firstDayOfWeek.getTime().getTime() );
	}
	
	//给定时间对象，初始化到该月初的1日0时0分0秒0毫秒
	//BOM:begin of month(月初)
	public static Date getBOM(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
		
	}
	//月末
	public static Date getEOM(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		//先求出下一个月的月初，然后减疫苗，就是本月月末
		calendar.add(Calendar.MONTH, 1);
		
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		//减1秒
		calendar.add(Calendar.SECOND, -1);
		
		return calendar.getTime();
	}
	
}
