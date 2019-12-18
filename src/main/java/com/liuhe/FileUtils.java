package com.liuhe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



public class FileUtils {

	//上传文件
	public static List<String> readFile(String fileName) throws IOException{
		List<String> lines = new ArrayList<String>();
		File file = new File(fileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
		
		String str = null;
		while((str=reader.readLine())!=null){
			lines.add(str);
		}
		
		return lines;
		
	}
	
	
	/*@Autowired
	private CompanyService service;
	//添加1万条数据
	@Test
	public void testAdd(){
		for (int i = 0; i <= 10000; i++) {
			service.add(new Company(null,new StringUtils().add(),new StringUtils().getRandomCn(3),"北京"+new StringUtils().randomChineseString(),new StringUtils().RandomCapital(),new StringUtils().RandomReg_no("1101"),new StringUtils().RandomNum(),new StringUtils().randomHireday1(),new StringUtils().randomHireday2(),null));

		}
	}*/
	
	//
			/*Driver login = (Driver) request.getSession().getAttribute("user");
			//
			DriverType dtype = dtService.getCode(login.getDriverType());
			String drivable="";
			if(StringUtils.isBlank(dtype.getInclude())){
				drivable = login.getDriverType()+","+dtype.getInclude();
			}else{
				drivable = login.getDriverType();
			}
			
			drivable = drivable.replaceAll(",", "','");
			List<Car> carlist = dtService.listCar(drivable);
			request.setAttribute("carlist", carlist);
			return "carlist";*/
}
