package com.team.zhihu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.team.zhihu.bean.User;
import com.team.zhihu.mapper.UserMapper;
import com.team.zhihu.service.UserService;
import com.team.zhihu.utils.MsgPrintUtil;


@Controller
public class LoginController {
	
	 @Autowired
	 private UserService userService;
	 
	//用户登录
	 @RequestMapping("user/login")
     public String userLogin(User user,HttpServletRequest req,HttpServletResponse resp) throws IOException {
	 	 User loginUser = userService.selectByUser(user);
	 	 HttpSession session = req.getSession();
	 	 // 将当前用户放到session中 名为curUser
	 	 session.setAttribute("curUser", loginUser);
	 	 if(loginUser!=null) {
	 		//传递userid
		 	 session.setAttribute("currId", loginUser.getId());
	 		 return "redirect:/index";
	 	 }else {
	 		MsgPrintUtil.doResponse(resp, "登录失败，用户名或密码错误", "/");
	 		return "login";
	 	 }
     }
	 
	 //用户注册
	 @RequestMapping("/user/doRegister")
	 public String userRegister(User user,HttpServletResponse resp) throws IOException {
		 User cherkPhonenumberUser = userService.selectByphonenumber(user.getPhonenumber());
		 User checkNameUser        = userService.selectByUserName(user.getUsername());
		 //电话号码和用户名不相同 就插入
		 if(checkNameUser==null) {
			 if(cherkPhonenumberUser==null) {
			 int i =  userService.insertUser(user);
				 if(i>0) {
					 MsgPrintUtil.doResponse(resp, "注册成功", "/");
					 return "login";
				 }else {
					 MsgPrintUtil.doResponse(resp, "注册失败", "/user/register");
					 return "register";
				 }
			 }else {
				 // 存在要注册的电话号码 则注册失败
				 MsgPrintUtil.doResponse(resp, "该电话号码已被注册", "/user/register");
				 return "register";
			 }
		 }else {
			 // 用户名已存在  则注册失败
			 MsgPrintUtil.doResponse(resp, "该用户名已被注册", "/user/register");
			 return "register";
		 }
	 }
	 //用户注销
	 @RequestMapping("/user/logout")
	 public String toLogout(HttpServletRequest req,HttpServletResponse resp) {
		 HttpSession session=req.getSession();
		 session.invalidate();
		return "login";
		 
	 }
	 
}
