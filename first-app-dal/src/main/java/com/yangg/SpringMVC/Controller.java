package com.yangg.SpringMVC;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //说明这个Controller  能放到那个里面
@Retention(RetentionPolicy.RUNTIME)//的周期 在runtime
@Documented //生成vpi
public @interface Controller {
	
	String value() default "";
	
}
