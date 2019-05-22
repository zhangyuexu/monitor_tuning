package com.xueqiu.monitor_tuning.controller;
import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

@BTrace
public class PrintConstructor {
	
	@OnMethod(
	        clazz="com.xueqiu.monitor_tuning.entry.User",//因为是要拦截User的构造函数，所以类一定是User类
	        method="<init>",
	        location=@Location(Kind.ENTRY)//什么时候拦截，在入口的时候开始拦截
	)
	//ProbeClassName拦截的方法的类名，ProbeMethodName拦截的方法的方法名，args即参数
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args) {
		BTraceUtils.printArray(args);
		BTraceUtils.println(pcn+","+pmn);
		BTraceUtils.println();
    }
}
