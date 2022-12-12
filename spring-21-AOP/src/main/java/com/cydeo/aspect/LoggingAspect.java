package com.cydeo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect // It is used for Aspect class, no bean is created for Aspect
@Component
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class); // logger field is used to put information on console

    //  Creating Pointcut means defining my JoinPoints
//    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void myPointcut() {}
//
//    // This is Advice. Defining here what we need to do
//    @Before("myPointcut()") // this method will run before any method runs in Course Controller
//    public void log() {
//        logger.info("Info log.......");
//    }

//    @Before("execution(* com.cydeo.controller.CourseController.*(..))") // second way without defining Pointcut
//    public void log() {
//        logger.info("Info log.......");
//    }

    // put log information before findById method inside CourseRepository class
//    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))") // single parameter
//    public void courseRepositoryFindByIdPC() {}
//
//    @Before("courseRepositoryFindByIdPC()")
//    public void beforeCourseRepositoryFindById(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
//                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }
    // JoinPoints are the methods that we want to cross counting concerns before or after
    // if {} is used in logger methods, arguments will be replaced
    // the log on the console :
    // Before -> Method: Optional org.springframework.data.repository.CrudRepository.findById(Object), Arguments: [2], Target: org.springframework.data.jpa.repository.support.SimpleJpaRepository@29c127ee

//    @Pointcut("within(com.cydeo.controller..*)") // means anything inside controller package
//    public void anyControllerOperation() {}
//
//    @Pointcut("@within(org.springframework.stereotype.Service)") // means annotation that is on top of classes
//    public void anyServiceOperation() {}
//
//    @Before("anyControllerOperation() || anyServiceOperation()")
//    public void beforeControllerOrServiceAdvice(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
//                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }
    //Before -> Method: CourseDTO com.cydeo.controller.CourseController.getCourseById(Long), Arguments: [2], Target: com.cydeo.controller.CourseController@34eb5d01
    //Before -> Method: CourseDTO com.cydeo.service.impl.CourseServiceImpl.getCourseById(long), Arguments: [2], Target: com.cydeo.service.impl.CourseServiceImpl@5d77be8e

    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)") // before DeleteMapping annotation
    public void anyDeleteControllerOperation() {}

    @Before("anyDeleteControllerOperation()")
    public void beforeDeleteMappingAnnotation(JoinPoint joinPoint) {
        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
    }
    // Before -> Method: void com.cydeo.controller.CourseController.deleteCourseById(Long), Arguments: [2], Target: com.cydeo.controller.CourseController@13c18bba

    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")
    public void loggingAnnotationPC() {}

    @Before("loggingAnnotationPC()")
    public void beforeLoggingAnnotation(JoinPoint joinPoint) {
        logger.info("Before -> Method: {}, Arguments: {}, Target: {}"
                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
    }

}
