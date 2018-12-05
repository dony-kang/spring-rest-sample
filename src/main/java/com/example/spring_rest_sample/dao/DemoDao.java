package com.example.spring_rest_sample.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoDao {
    @Autowired
    SqlSession sqlSession;

    public int save(String name) {
        Map<String, Object> param = new HashMap<>();
        param.put("name", name);
        sqlSession.insert("tmp.save", param);
        return new Integer(param.get("id").toString());
    }

    public int getMaxId() {
        return sqlSession.selectOne("tmp.maxId");
    }
}