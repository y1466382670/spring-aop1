package cn.yu.dao;

public interface IndexDao {

    void query();

    void annotationQuery();

    void aroundAdvice(String name, String remark);

}
