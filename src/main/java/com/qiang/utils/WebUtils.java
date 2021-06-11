package com.qiang.utils;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class WebUtils {
	/**
	 * 保存文件
	 */
	public static String saveFile(HttpServletRequest request, MultipartFile file) {
		String URI = "";
		String savaDBPath = "";
		if (!file.isEmpty()) {
			try {
				// 保存的文件路径(如果用的是Tomcat服务器
				// 文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中
				String filename = UUID.randomUUID().toString().replaceAll("-", "") + "_" + file.getOriginalFilename();
				String filePath = request.getSession().getServletContext().getRealPath("/") + "/xianhua/" + filename;
				//String filePath= "G:\\JingShui\\src\\main\\webapp" +"/xianhua/"+filename;
				
				savaDBPath = "xianhua/"+ filename;
				File saveDir = new File(filePath);
				if (!saveDir.getParentFile().exists())
					saveDir.getParentFile().mkdirs(); // 注意这里一定是mkdirs
				// 转存文件
				file.transferTo(saveDir);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return savaDBPath;
	}

}
