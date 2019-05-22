package com.xueqiu.monitor_tuning.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xueqiu.monitor_tuning.entry.Metaspace;
import com.xueqiu.monitor_tuning.entry.User;

@RestController
public class MemoryController {
	private List<User>userList=new ArrayList<>();
	private List<Class<?>> classList=new ArrayList<>();
	/**
	 * 设置堆的最大内存  最小内存
	 * -Xmx32M -Xms32M
	 * @return
	 */
	@RequestMapping("/heap")
	public String heap() {
		int i=0;
		while(true) {
			userList.add(new User(i++, UUID.randomUUID().toString()));
		}
	}
	
	/**
	 * -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M
	 * @return
	 */
	@GetMapping("/nonheap")
	public String nonheap() {
		while(true) {
			classList.addAll(Metaspace.createClasses());
		}
	}
}
