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
public class PrintArgSimple {
	
	@OnMethod(
	        clazz="com.xueqiu.monitor_tuning.controller.BTraceController",
	        method="arg1",
	        location=@Location(Kind.ENTRY)//什么时候拦截，在入口的时候开始拦截
	)
	//ProbeClassName拦截的方法的类名，ProbeMethodName拦截的方法的方法名，args表示拦截的参数
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args) {
		BTraceUtils.printArray(args);
		BTraceUtils.println(pcn+","+pmn);
		BTraceUtils.println();
    }
}
