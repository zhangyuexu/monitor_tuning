package com.xueqiu.monitor_tuning.controller;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Duration;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

@BTrace
public class PrintDuration {
	//打印耗时超过100ms的方法
	@OnMethod(
	        clazz="/com\\.xueqiu\\.monitor_tuning\\.controller\\..*/",
	        method="/.*/",
	        location=@Location(Kind.RETURN)
	)
	//ProbeClassName拦截的方法的类名，ProbeMethodName拦截的方法的方法名，这里监控的是业务逻辑service层中的getCount方法的执行时间(看是否大于100ms)
	public static void printMethodRunTime(@ProbeClassName String pcn,@ProbeMethodName String pmn,@Duration long duration) {
		//duration是以纳秒为单位的,所以换算成 MS 比较好看一点
		if(duration > 1000000*100) {
			BTraceUtils.println(pcn+","+pmn+" method run time:"+duration / 1000000 + " ms");
		}
    }
	
	
//	@OnMethod(
//	        clazz="com.xueqiu.monitor_tuning.service.CountService",
//	        method="getCount",
//	        location=@Location(Kind.RETURN)
//	)
//	//ProbeClassName拦截的方法的类名，ProbeMethodName拦截的方法的方法名，这里监控的是业务逻辑service层中的getCount方法的执行时间(看是否大于100ms)
//	public static void printMethodRunTime(@ProbeClassName String pcn,@ProbeMethodName String pmn,@Duration long duration) {
//		if(duration > 1000000*100) {
//			BTraceUtils.println(pcn+","+pmn+" method run time:"+duration / 1000000 + " ms");
//		}
//		
//		//duration是以纳秒为单位的,所以换算成 MS 比较好看一点
//		BTraceUtils.println(pcn+","+pmn+" method run time:"+duration / 1000000 + " ms");
//    }
}
