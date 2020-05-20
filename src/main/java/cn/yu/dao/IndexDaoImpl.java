package cn.yu.dao;

import cn.yu.anno.AspectAnnotation;
import org.springframework.stereotype.Repository;

@Repository
public class IndexDaoImpl implements IndexDao {

    public void query(){
        System.out.println("execution横切执行方法");
    }

    @AspectAnnotation(value = "横切注解")
    public void annotationQuery(){
        System.out.println("annotation注解横切执行方法");
    }


    public void aroundAdvice(String name, String remark) {
        System.out.println("name="+name);
        System.out.println("remark="+remark);
    }

}
