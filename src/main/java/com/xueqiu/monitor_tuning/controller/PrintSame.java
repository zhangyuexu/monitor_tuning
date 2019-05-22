package com.xueqiu.monitor_tuning.controller;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

@BTrace
public class PrintSame {
	
	@OnMethod(
	        clazz="com.xueqiu.monitor_tuning.controller.BTraceController",//因为是要拦截User的构造函数，所以类一定是User类
	        method="same"
	        //location=@Location(Kind.ENTRY)//什么时候拦截，在入口的时候开始拦截
	)
	//这个脚本拦截只能拦截带两个参数的
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, String name,int id) {
		BTraceUtils.println(pcn+","+pmn+","+name+","+id);
		BTraceUtils.println();
    }
}
