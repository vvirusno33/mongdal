package com.mongdal.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

//@Aspect
//@Component
public class PerformanceAspect {

	/**
	 * 시작전에 동작하는 어드바이스
	 * @param jp
	 */
	//@Before("execution(* *..sendMail(..))")
	public void before(JoinPoint jp) {
		System.out.println("=====> CALL before() START =====");
//		Signature sig = jp.getSignature();
//		Object[] o = jp.getArgs();
//		System.out.println("-----> Method Name：" + sig.getName());
//		System.out.println("-----> Args：" + o[0]);
	}

	/**
	 * 종료후에 동작하는 어드바이스(실행결과에 상관없이 무조건 호출)
	 */
	//@After("execution(* *..sendMail(..))")
	public void after() {
		System.out.println("=====> CALL after() START =====");
	}

	/**
	 * 종료후에 동작하는 어드바이스 (실행결과가 성공인 경우 호출)
	 * @param jp
	 * @param obj
	 */
	//@AfterReturning(value="execution(* *..sendMail(..))", returning="obj")
	public void afterReturning(JoinPoint jp, Object obj) {
		System.out.println("=====> CALL afterReturning() START =====");
//		Signature sig = jp.getSignature();
//		Object[] o = jp.getArgs();
//		System.out.println("-----> Method Name：" + sig.getName());
//		System.out.println("-----> Args：" + o[0]);
	}

	/**
	 *  호출 전후에 동작하는 어드바이스
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	//@Around("execution(* *..sendMail(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {

		System.out.println("=====> CALL around() START =====");

		// AOP around가 적용되는 메소드 정보
		//
		Signature sig = pjp.getSignature();
		String className = sig.getDeclaringTypeName();
		String methodName = sig.getName();

		// 실행시간 측정
		//
		long startTime = System.currentTimeMillis(); // 측정하는 시작시점
		Object obj = pjp.proceed();         // 실행
		long endTime = System.currentTimeMillis();   // 측정하는 종료시점

		System.out.println( "*** 측정결과 : " + className + "." + methodName + "() 소요시간[" + (endTime - startTime) + "ms]");

		return obj;
	}

	/**
	 * 예외가 발생한 경우 동작하는 어드바이스
	 * @param ex
	 */
	//@AfterThrowing(value="execution(* *..sendMail(..))", throwing="ex")
	public void afterThrowing(Throwable ex) {
		// 메서드 호출이 예외를 던졌을 때 동작하는 어드바이스
		System.out.println("=====> CALL afterThrowing() START =====");
		System.out.println("Throwable ex - " + ex.toString());
	}

}