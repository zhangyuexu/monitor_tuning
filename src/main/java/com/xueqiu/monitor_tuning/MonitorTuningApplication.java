package com.xueqiu.monitor_tuning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages= {"com.xueqiu.monitor_tuning.controller","com.xueqiu.monitor_tuning.service"})
@SpringBootApplication
public class MonitorTuningApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorTuningApplication.class, args);
	}

}
