package com.xueqiu.monitor_tuning.controller;
import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;
import com.sun.btrace.annotations.Return;

@BTrace
public class PrintReturn {
	
	@OnMethod(
	        clazz="com.xueqiu.monitor_tuning.controller.BTraceController",
	        method="arg1",
	        location=@Location(Kind.RETURN)//获取返回值或执行时间就要用 Kind.Return
	)
	//ProbeClassName拦截的方法的类名，ProbeMethodName拦截的方法的方法名，加@Return注解，表示是返回值，如果不加代表的是参数
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, @Return AnyType result) {
		BTraceUtils.println(pcn+","+pmn+","+result);
		BTraceUtils.println();
    }
}
