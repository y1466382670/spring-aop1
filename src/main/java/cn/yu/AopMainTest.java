package cn.yu;

import cn.yu.config.AppConfig;
import cn.yu.dao.IndexDao;
import cn.yu.dao.IndexDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopMainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        IndexDaoImpl indexdao = annotationConfigApplicationContext.getBean(IndexDaoImpl.class);
        System.out.println(indexdao instanceof IndexDaoImpl);
        indexdao.query();
        indexdao.annotationQuery();
    }
}
