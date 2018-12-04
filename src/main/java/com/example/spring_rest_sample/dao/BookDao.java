package com.example.spring_rest_sample.dao;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

    @Autowired
    SqlSession sqlSession;

    public List<Map<String, Object>> findAll() {

        return sqlSession.selectList("book.findAll");
    }

    public Optional<Book> findById(Long id) {
        return sqlSession.select();
    }

}