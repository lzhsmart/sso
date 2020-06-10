package com.dm.sso.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年06月10日 18:49</p>
 * <p>类全名：com.dm.sso.aspect.MyLogAspect</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Aspect
@Component
public class MyLogAspect
{
	private final        Logger logger         = LoggerFactory.getLogger(MyLogAspect.class);
	/** 换行符 */
	private static final String LINE_SEPARATOR = System.lineSeparator();

	/** 以自定义 @WebLog 注解为切点 */
	@Pointcut("@annotation(com.dm.sso.aspect.MyLog)")
	public void webLog()
	{
	}

	/**
	 * 在切点之前织入
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable
	{
		// 开始打印请求日志
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 获取 @WebLog 注解的描述信息
		String methodDescription = getAspectLogDescription(joinPoint);
		// 打印请求相关参数
		logger.info("========================================== Start ==========================================");
		// 打印请求 url
		logger.info("URL            : {}", request.getRequestURL().toString());
		// 打印描述信息
		logger.info("Description    : {}", methodDescription);
		// 打印 Http method
		logger.info("HTTP Method    : {}", request.getMethod());
		// 打印调用 controller 的全路径以及执行方法
		logger.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
		// 打印请求的 IP
		logger.info("IP             : {}", request.getRemoteAddr());
		// 打印请求入参
		// logger.info("Request Args   : {}", new Gson().toJson(joinPoint.getArgs()));
		logger.info("Request Args   : {}", joinPoint.getArgs().toString());
	}

	/**
	 * 在切点之后织入
	 * @throws Throwable
	 */
	@After("webLog()")
	public void doAfter() throws Throwable
	{
		// 接口结束后换行，方便分割查看
		logger.info("=========================================== End ===========================================" + LINE_SEPARATOR);
	}

	/**
	 * 环绕
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("webLog()")
	public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
	{
		long startTime = System.currentTimeMillis();
		Object result = proceedingJoinPoint.proceed();
		// 打印出参
		// logger.info("Response Args  : {}", new Gson().toJson(result));
		logger.info("Response Args  : {}", result.toString());
		// 执行耗时
		logger.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
		return result;
	}

	/**
	 * 获取切面注解的描述
	 *
	 * @param joinPoint 切点
	 * @return 描述信息
	 * @throws Exception
	 */
	public String getAspectLogDescription(JoinPoint joinPoint) throws Exception
	{
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		StringBuilder description = new StringBuilder("");
		for (Method method : methods)
		{
			if (method.getName().equals(methodName))
			{
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length)
				{
					description.append(method.getAnnotation(MyLog.class).description());
					break;
				}
			}
		}
		return description.toString();
	}
}
