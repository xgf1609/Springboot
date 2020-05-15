package com.myproject.server;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.bean.User;

import io.swagger.annotations.Api;

@RestController
@Api(value = "/")
@RequestMapping("V1")
public class MyPostMethodController {
	private static Cookie cookie; //用于保存cookie信息
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(HttpServletResponse response,
						@RequestParam(value = "username",required = true)String userName,
						@RequestParam(value = "password",required = true)String passWord) {
		if(userName.equals("zhangsan")&&passWord.equals("123456")) {
			cookie = new Cookie("login", "true");
			response.addCookie(cookie);
			return "登录成功";
		}
		return "用户名或密码错误";
	}
	
	@RequestMapping(value = "/logindemo",method = RequestMethod.POST)
	public String logindemo(HttpServletResponse response,
							@RequestParam(value = "userName",required = true) String username,
							@RequestParam(value = "password",required = true) String pwd) {
		if(username.equals("wangwu")&&pwd.equals("123456")) {
			cookie = new Cookie("login", "true");
			response.addCookie(cookie);
			return username+"登录成功";
		}
		return "用户名或密码错误，请重试！";
	}
	//返回用户列表
	@RequestMapping(value = "/loginPost",method = RequestMethod.POST)
	public String loginPost(HttpServletRequest request,
							@RequestBody User user) {
		User user2;
		Cookie[] cookie = request.getCookies();
		for (Cookie cookie2 : cookie) {
			if(cookie2.getName().equals("login")&&cookie2.getValue().equals("true")
					&&user.getUsername().equals("zhangsan")&&user.getPassword().equals("123456")) {
				user2 = new User("lisi","20","man");
				return user2.toString();
			}
		}
		return "权限不足！";
	}
	
	

}
