package com.myproject.server;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "/")
public class MyGetMethodController{
	/**
	 * 带有cookies信息的响应
	 */
	@RequestMapping(value = "/getcookies",method = RequestMethod.GET)
	@ApiOperation(value = "通过这方法可获取Cookies",httpMethod = "GET")
	//是一个用来处理请求地址映射的注解,可用来处理多个 URI,可用在类、方法、参数中
	public String getCookies(HttpServletResponse response) {
		//HttpServerletRequest 装请求信息的类
		//HttpServerletResponse 装响应信息的类
		Cookie c = new Cookie("login", "true");
		response.addCookie(c);
		return "恭喜你获得cookies信息成功";
	}
	
	/**
	 * 要求客户端携带cookies信息访问
	 */
	@RequestMapping(value = "/loginbyget/cookies",method = RequestMethod.GET)
	@ApiOperation(value = "要求客户端携带cookies请求",httpMethod = "GET")
	public String setCookies(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(Objects.isNull(cookies)) {
			return "必须携带cookies来";
		}
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("login") && cookie.getValue().equals("true")) {
				return "恭喜你携带cookies访问成功";
			}
		}
		return "必须携带cookies来";
	}
	
	/**
	 * 第一种：携带参数发起请求
	 * 模拟获取商品列表，参数为起始位置、结束位置
	 * url:ip:port/getWithList?start=10&end=20
	 */
	@RequestMapping(value = "/getWithList",method = RequestMethod.GET)
	@ApiOperation(value = "需要携带参数才可发请求的方式1",httpMethod = "GET")
	public Map<String, Integer> getList(@RequestParam Integer start,@RequestParam Integer end){
		Map<String,Integer> myList = new HashMap<String, Integer>();
		myList.put("水杯", 50);
		myList.put("套碗",100);
		myList.put("锅", 200);
		return myList;
	}
	
	/**
	 * 第二种：携带参数发起请求
	 * url:ip:port/getWithList/10/20
	 */
	@RequestMapping(value = "/myGetList/{start}/{end}",method = RequestMethod.GET)
	@ApiOperation(value = "需要携带参数发起请求的方式2",httpMethod = "GET")
	public Map<String,Integer> myGetList(@PathVariable Integer start,@PathVariable Integer end){
		Map<String,Integer> myList = new HashMap<String, Integer>();
		myList.put("水杯", 50);
		myList.put("套碗",100);
		myList.put("锅", 200);
		return myList;
	}
}
