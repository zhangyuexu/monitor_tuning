package com.xueqiu.monitor_tuning.controller;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

@BTrace
public class PrintRegex {
	/**
	 * 拦截BTraceController类中的所有方法，功能非常强大
	 */
	@OnMethod(
	        //clazz="com.xueqiu.monitor_tuning.controller.BTraceController",
			//监控controller包的所有类
//			clazz="/com.xueqiu.monitor_tuning.controller.*/",
			clazz="/com\\.xueqiu\\.monitor_tuning.controller\\..*/",
	        method="/.*/"
	)
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn) {
		BTraceUtils.println(pcn+","+pmn);
		BTraceUtils.println();
    }
}