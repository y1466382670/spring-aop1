package cn.yu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 在启用@Aspect]支持的情况下
 * 在应用程序上下文中定义的任何具有@Aspecty aspect(具有@Aspect注释)类的bean都会被Spring自动检测到
 * 并用于配置Spring AOP
 */
@Aspect
@Component
public class MyAspectJ {

    @Pointcut("execution(* cn.yu.dao.IndexDaoImpl.query(..)))")
    private void executionPointCut(){}

    //表示所有带有cn.yu.anno.AspectAnnotation注解的方法都横切
    @Pointcut("@annotation(cn.yu.anno.AspectAnnotation)")
    private void annotationPointCut(){}

    @Pointcut("execution(* cn.yu.dao.IndexDaoImpl.aroundAdvice(..)))")
    private void executionAroundAdvicePointCut(){}


//    @Before("cn.yu.aspect.MyAspectJ.executionPointCut()") //在不同类中把横切点的全路径写上
    @Before("executionPointCut()") //在同一个类中直接写方发明
    public void doExecutionPointCut(){
        System.out.println("AOP before : 执行execution横切点");
    }

    @Before("annotationPointCut()")
    public void doAnnotationPointCut(){
        System.out.println("AOP before : 横切所有带cn.yu.anno.AspectAnnotation注解的方法");
    }


    @Around("executionAroundAdvicePointCut()")
    public void doExecutionAroundAdvicePointCut(ProceedingJoinPoint pjp){
        System.out.println("开始aroundAdvice");

        Object args[] = pjp.getArgs();
        if (!StringUtils.isEmpty(args) && args.length>0){
            for (int i = 0; i < args.length; i++) {
                args[i] += "zhiyu";
            }
        }
        try {
            pjp.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("结束aroundAdvice");
    }

}
