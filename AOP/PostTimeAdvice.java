package chap03;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * 模拟业务对象
 * @author zhaogy
 *
 */
public class PostTimeAdvice implements MethodBeforeAdvice,AfterReturningAdvice{
	long start;
	//具体业务
	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		start=System.currentTimeMillis();
	}

	@Override
	public void afterReturning(Object returnValue, Method method,Object[] args, Object target) throws Throwable {
		System.out.println("开始于:"+start);
		long endTime = System.currentTimeMillis();
		System.out.println("结束于:"+endTime);
		System.out.println("一共消耗时间(ms):"+(endTime-start));
	}
}
