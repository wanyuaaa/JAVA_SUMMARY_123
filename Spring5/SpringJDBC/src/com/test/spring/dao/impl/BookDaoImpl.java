package com.test.spring.dao.impl;

import com.test.spring.pojo.Book;
import com.test.spring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wanyu
 * @createTime 2022-03-13 17:26
 */
@Repository
public class BookDaoImpl implements BookDao {

    //注入 JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {
        String sql = "insert into t_user values(?,?,?,?)";
        Object[] args = {book.getId(), book.getUsername(), book.getPassword(), book.getEmail()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    //查询返回对象
    @Override
    public Book findBookInfo(int id) {
        String sql = "select * from t_user where id=?";
        //调用方法
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
    }

    //查询返回集合
    @Override
    public List<Book> findAllBook() {
        String sql = "select * from t_user";
        //调用方法
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        String sql = "insert into t_user values(?,?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void addMoney() {
        String sql = "update t_money set money = money - ? where username = ?";
        jdbcTemplate.update(sql, 100, "lucy");
    }

    @Override
    public void reduceMoney() {
        String sql = "update t_money set money = money + ? where username = ?";
        jdbcTemplate.update(sql, 100, "mary");
    }

}
