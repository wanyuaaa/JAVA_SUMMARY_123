package com.test.spring.dao;

import com.test.spring.pojo.Book;

import java.util.List;

/**
 * @author wanyu
 * @createTime 2022-03-13 17:26
 */
public interface BookDao {
    void add(Book book);

    Book findBookInfo(int id);

    List<Book>  findAllBook();

    void batchAddBook(List<Object[]> batchArgs);

    void addMoney();

    void reduceMoney();
}
