package dao;

import java.util.List;

public interface SimpleDao<T> {
    T findById(int id);

    List<T> query(T condition); // 模糊查询

    int insert(T t);

    int update(T t);

    int delete(int id);

}
