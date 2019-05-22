package com.xueqiu.monitor_tuning.controller;

import java.lang.reflect.Field;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;
import com.xueqiu.monitor_tuning.entry.User;

@BTrace
public class PrintArgComplex {
	
	/**
	 * 获取对象的值:拦截复杂类型：利用反射，类名+属性名
	 */
	@OnMethod(
	        clazz="com.xueqiu.monitor_tuning.controller.BTraceController",
	        method="arg2",
	        location=@Location(Kind.ENTRY)//仅获取参数值，可以用 Kind.Entry
	)
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, User user) {
		//print all fields
		BTraceUtils.printFields(user);
		//print one field
		Field filed2 = BTraceUtils.field("com.xueqiu.monitor_tuning.entry.User", "name");
		BTraceUtils.println(BTraceUtils.get(filed2, user));
		BTraceUtils.println(pcn+","+pmn);
		BTraceUtils.println();
    }
}
