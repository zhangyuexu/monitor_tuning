package com.xueqiu.monitor_tuning.controller;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xueqiu.monitor_tuning.entry.User;
import com.xueqiu.monitor_tuning.service.CountService;

@RestController
public class BTraceController {
	
	@Autowired
	CountService countService;
	
	//@RequestMapping(value="/arg1",method=RequestMethod.GET)
	@GetMapping("/arg1")
	public String arg1(@RequestParam("name")String name) {
		return "Hello "+name;
	}
	
	@GetMapping("/constructor")
	public User constructor(User user) {
		return user;
	}
	
	//@RequestMapping(value="/constructor",method=RequestMethod.POST)
	//@PostMapping("/constructor")
	//public User constructor(@RequestBody User user) {//传参加上@RequestBody，要求以Body json的格式传参，即{"id":3,"name":"zyx"};而且要求实体类的构造函数必须有个无参的构造函数
	//public User constructor(User user) {
	//	return user;
	//}
	
	
	/**
	 * 拦截同名函数
	 */
	@GetMapping("/same1")
	public String same(@RequestParam("name")String name) {
		return "hello "+name;
	}
	
	@GetMapping("/same2")
	public String same(@RequestParam("name")String name,@RequestParam("id")int id) {
		return "hello "+name+","+id;
	}
	
	@GetMapping("/exception")
	public String exception() {
		//模拟异常没有外抛，异常被吞的情况
		try {
			System.out.println("start......");//模拟业务逻辑
			System.out.println(1/0);//业务中的异常
			System.out.println("end.....");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "success";
	}
	
	
	@GetMapping("/arg2")
	public User arg2(User user) {
		return user;
	}
	
	@PostMapping("/count")
	public String count(@RequestParam("a")String a,@RequestParam("b")String b) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "a+b="+countService.getCount(Integer.valueOf(a), Integer.valueOf(b));
	}
}
