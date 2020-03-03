package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.VerifyCodeUtils;


public class CreateCodeServlet extends HttpServlet {
    
	public CreateCodeServlet() {
		System.out.println("Create Servlet 构造方法 被调用");
	}
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("Create start");
    	resp.setHeader("Pragma", "No-cache");  
        resp.setHeader("Cache-Control", "no-cache");  
        resp.setDateHeader("Expires", 0);  
        resp.setContentType("image/jpeg");  
          
        //生成随机字串  
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);  
        //存入会话session  
        req.getSession().setAttribute("CODE", verifyCode.toLowerCase());  
        
        //生成图片  
        int width = 100;//宽
        int height = 40;//高  
        VerifyCodeUtils.outputImage(width, height, resp.getOutputStream(), verifyCode);  
        System.out.println("Create Done！");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }
}