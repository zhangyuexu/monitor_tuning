package com.xueqiu.monitor_tuning.controller;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

@BTrace
public class PrintLine {
	
	@OnMethod(
	        clazz="com.xueqiu.monitor_tuning.controller.BTraceController",
	        method="exception",
	        location=@Location(value=Kind.LINE,line=55)//什么时候拦截，在55行开始拦截,看第55行有没有被执行;
	)
	//ProbeClassName拦截的方法的类名，ProbeMethodName拦截的方法的方法名，line即拦截的行号
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, int line) {
		BTraceUtils.println(pcn+","+pmn+","+line);
		BTraceUtils.println();
    }
}
