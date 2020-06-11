package com.dm.sso.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * <p>标题：切面示例</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年06月11日 14:52</p>
 * <p>类全名：com.dm.sso.aspect.DemoAspect</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Aspect
@Component
public class DemoAspect
{
	private final        Logger logger         = LoggerFactory.getLogger(DemoAspect.class);
	/** 换行符 */
	private static final String LINE_SEPARATOR = System.lineSeparator();
	/** 声明切面 */
	// public static final  String POINTCUT       = "execution(* com.dm.sso.service.*.*(..))";
	public static final  String POINTCUT       = "execution(* com.dm.sso.service.UserService.queryAllUsers(..))";

	@Before(POINTCUT)
	public void doBefore(JoinPoint joinPoint)
	{
		logger.info("========== DemoAspect Before ==========" + LINE_SEPARATOR);
	}

	@Around(POINTCUT)
	public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
	{
		logger.info("========== DemoAspect Around start ==========" + LINE_SEPARATOR);
		Object result = proceedingJoinPoint.proceed();
		logger.info("========== DemoAspect Around end   ==========" + LINE_SEPARATOR);
		return result;
	}

	@AfterReturning(POINTCUT)
	public void doAfterReturning(JoinPoint joinPoint)
	{
		logger.info("========== DemoAspect AfterReturning ==========" + LINE_SEPARATOR);
	}

	@AfterThrowing(POINTCUT)
	public void afterThrowing(JoinPoint joinPoint)
	{
		logger.info("========== DemoAspect AfterThrowing ==========" + LINE_SEPARATOR);
	}

	@After(POINTCUT)
	public void doAfter(JoinPoint joinPoint)
	{
		logger.info("========== DemoAspect After ==========" + LINE_SEPARATOR);
	}
}
