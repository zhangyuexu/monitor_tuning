package com.xueqiu.monitor_tuning.service;

import org.springframework.stereotype.Service;

@Service
public class CountService {

	public int getCount(int a,int b) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a+b;
	}
}
