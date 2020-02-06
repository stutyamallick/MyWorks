package com.avaya.ngm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.stereotype.Component;

import com.avaya.ngm.util.UtilLogger;
import com.google.gson.Gson;

@Aspect
@Component
public class EmployeeServiceAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	Gson gson = new Gson();

	// TODO: Need to create new Level called AUDIT
	Marker audit = MarkerFactory.getMarker("AUDIT");

	@Before(value = "execution(* com.avaya.ngm.service.EmployeeService.*(..)) and args(name,empId)")
	public void beforeAdvice(JoinPoint joinPoint, String name, String empId) {
		UtilLogger.genericLogger(logger);
	}

	@After(value = "execution(* com.avaya.ngm.service.EmployeeService.*(..)) and args(name,empId)")
	public void afterAdvice(JoinPoint joinPoint, String name, String empId) {
		UtilLogger.auditLogger(logger, joinPoint, "ORIGINAL", "Successfully Created");
	}

	/*
	 * @Around(value =
	 * "execution(* com.avaya.ngm.service.EmployeeService.*(..)) and args(name,empId)"
	 * ) public void aroundAdvice(ProceedingJoinPoint joinPoint, String name, String
	 * empId) throws Throwable { UtilLogger.auditLogger(logger, new Object(), "NA");
	 * logger.info("Around method:" + joinPoint.getSignature());
	 * 
	 * joinPoint.proceed();
	 * logger.debug("Successfully created Employee with name - " + name +
	 * " and id - " + empId); }
	 */

	/*
	 * @Around("execution(* *(..))") public Object
	 * handleAccessToken(ProceedingJoinPoint thisJoinPoint) throws Throwable {
	 * System.out.println(thisJoinPoint); Object[] args = thisJoinPoint.getArgs();
	 * MethodSignature methodSignature = (MethodSignature)
	 * thisJoinPoint.getStaticPart().getSignature(); Method method =
	 * methodSignature.getMethod(); Annotation[][] parameterAnnotations =
	 * method.getParameterAnnotations(); assert args.length ==
	 * parameterAnnotations.length; for (int argIndex = 0; argIndex < args.length;
	 * argIndex++) { for (Annotation annotation : parameterAnnotations[argIndex]) {
	 * if (!(annotation instanceof RequestParam)) continue; RequestParam
	 * requestParam = (RequestParam) annotation; if
	 * (!"accessToken".equals(requestParam.value())) continue;
	 * System.out.println("  " + requestParam.value() + " = " + args[argIndex]); } }
	 * return thisJoinPoint.proceed(); }
	 */

}
