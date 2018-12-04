package com.example.spring_rest_sample.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    SqlSession sqlSession;

    public List<Map<String, Object>> getUserList() {
        return sqlSession.selectList("user.list");
    }
}