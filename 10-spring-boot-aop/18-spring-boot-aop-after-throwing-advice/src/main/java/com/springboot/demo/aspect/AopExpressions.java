package com.springboot.demo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


// if you have pointcuts then @Aspect is optional, only required if you add advices in this class @Before @After

@Aspect
public class AopExpressions {
    @Pointcut("execution(* com.springboot.demo.dao.*.*(..))")
    public void forDaoPackage() {
    }

    // create a pointcut for getter methods
    @Pointcut("execution(* com.springboot.demo.dao.*.get*(..))")
    public void getter() {
    }

    // create pointcut for setter methods
    @Pointcut("execution(* com.springboot.demo.dao.*.set*(..))")
    public void setter() {
    }

    // create pointcut: include package ...exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter()||setter())")
    public void forDaoPackageNoGetterSetter() {
    }
}
