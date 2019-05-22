package com.xueqiu.monitor_tuning.controller;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
/**
 * 查看谁调用了GC
 *
 */
public class PrintGC {

	@OnMethod(clazz="java.lang.System",method="gc")
	public static void onSystemGC() {
		BTraceUtils.println("****************************************");
		BTraceUtils.println("who call the GC:");
		BTraceUtils.jstack();
		BTraceUtils.println("****************************************");
	}
	
	@OnMethod(clazz="java.lang.System",method="gc",location=@Location(Kind.RETURN))
	public static void endSystemGC() {
		BTraceUtils.println("=========================================");
		BTraceUtils.jstack();
		BTraceUtils.println("=========================================");
	}
}
