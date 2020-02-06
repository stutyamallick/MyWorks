package com.avaya.ngm.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class JoinPointConfiguration {

	@Pointcut("execution(* com.avaya.ngm.service.*.*(..))")
	public void serviceLayerGenericBeforeExecution() {
	}
	
	@Pointcut("execution(* com.avaya.ngm.service.*.*(..))")
	public void serviceLayerGenericAfterExecution() {
	}
	
	@Pointcut("execution(* com.avaya.ngm.repository.*.*(..))")
	public void repositoryLayerGenericBeforeExecution() {
	}
	
	@Pointcut("execution(* com.avaya.ngm.repository.*.*(..))")
	public void repositoryLayerGenericAfterExecution() {
	}

	@Pointcut("execution(* com.avaya.ngm.service.EmployeeService.create*(..))")
	public void serviceLayerCreateExecution() {
	}
	
	@Pointcut("execution(* com.avaya.ngm.service.EmployeeService.update*(..))")
	public void serviceLayerUpdateExecution() {
	}
	
	@Pointcut("execution(* com.avaya.ngm.service.EmployeeService.delete*(..))")
	public void serviceLayerDeleteExecution() {
	}
	
	
	
}
