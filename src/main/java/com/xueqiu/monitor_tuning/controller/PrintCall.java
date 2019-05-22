package com.xueqiu.monitor_tuning.controller;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Duration;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;
import com.sun.btrace.annotations.Self;
import com.sun.btrace.annotations.TargetInstance;
import com.sun.btrace.annotations.TargetMethodOrField;
import com.sun.btrace.annotations.Where;

@BTrace
public class PrintCall {
	/**
	 * Kind.Call 表示被监控的方法调用了哪些其他方法
	 * 监控指定函数中所有外部调用的耗时情况
	 */
	@OnMethod(
	        clazz="com.xueqiu.monitor_tuning.controller.BTraceController",
	        method="count",
	        location=@Location(value=Kind.CALL,clazz="/com.xueqiu.monitor_tuning.service.*/",method="/.*/",where=Where.AFTER)
	)
	//这里是监控 countService 类中 getCount 方法内的外部方法调用情况并打印出响应时间大于 5 MS 的外部调用方法名 。
	//通过注入 @TargetInstance 和 @TargetMethodOrField 参数，告诉脚本实际匹配到的外部函数调用的类及方法名(或属性名)
	public static void printMethodCallTime(@Self Object self,@TargetInstance Object instance,@TargetMethodOrField String method,@Duration long duration) {
		if( duration > 5000000L ){
			//如果耗时大于 5 毫秒则打印出来 这个条件建议加 否则打印的调用函数太多 具体数值可以自己调控
			BTraceUtils.println("self:"+self);
			BTraceUtils.println("instance:"+instance);
            BTraceUtils.println(instance+","+method + ",cost:" + duration / 1000000 + " ms");
 
        }
    }
	
//	
//	//Kind.Call 表示被监控的方法调用了哪些其他方法，例如：
//	@OnMethod(clazz="com.xueqiu.monitor_tuning.controller.BTraceController",
//			  method="count",
//			  location=@Location(value=Kind.CALL,clazz="com.xueqiu.monitor_tuning.service.CountService",method="getCount",where=Where.AFTER))
//	//@Self表示当前监控的函数所在类，如果是静态类则为空，@TargetInstance 表示函数中调用的方法或属性所在的类，如果是静态方法则为空，@TargetMethodOrField 表示调用的方法或属性，如果要获取执行时间，那么 where 必须设置为 Where.AFTER
//	public static void printMethodCallTime(@Self Object self,@TargetInstance Object instance,@TargetMethodOrField String methon,@Duration long duration) {
//		if( duration > 5000000L ){
//			//如果耗时大于 5 毫秒则打印出来 这个条件建议加 否则打印的调用函数太多 具体数值可以自己调控
//			BTraceUtils.println("self:"+self);
//			BTraceUtils.println("instance:"+instance);
//            BTraceUtils.println(instance+","+methon + ",cost:" + duration / 1000000 + " ms");
// 
//        }
//    }
	
	
}
