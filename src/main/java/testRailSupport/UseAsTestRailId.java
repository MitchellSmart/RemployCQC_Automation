package testRailSupport;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.*; 
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface UseAsTestRailId
{
	int testRailId() default 0;
	String testRailTestRun() default "";
	String[] tags() default "";
}