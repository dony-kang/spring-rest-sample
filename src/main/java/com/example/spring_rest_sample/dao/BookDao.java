package com.example.spring_rest_sample.dao;

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
        Book book = null;
        try {
            book = sqlSession.selectOne("book.findById", id);
        } catch (Exception e) {
            System.out.println("record not found!");
        }
        return Optional.ofNullable(book);
    }

    public void delete(Long id) {
        int updateCnt = sqlSession.delete("book.delete", id);
        if (updateCnt != 0)
            System.out.println("delete a record.");
    }

    public void update(Book book) {
        int updateCnt = sqlSession.update("book.update", book);
        if (updateCnt != 0)
            System.out.println("update a record.");
    }

}