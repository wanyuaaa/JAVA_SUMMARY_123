package com.test.spring.service;

import com.test.spring.pojo.Book;
import com.test.spring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wanyu
 * @createTime 2022-03-13 17:25
 */
@Component
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void add(Book book) {
        bookDao.add(book);
    }

    public void findBookInfo(int id) {
        Book bookInfo = bookDao.findBookInfo(id);
        System.out.println(bookInfo.toString());
    }

    public void findAllBook() {
        List<Book> allBook = bookDao.findAllBook();
        for (Book b : allBook) {
            System.out.println(b.toString());
        }
    }

    public void batchAdd(List<Object[]> batchArgs) {
        bookDao.batchAddBook(batchArgs);
    }

    //propagation：事务传播行为,required有用一个，没有创建新的，required_new 始终创建一个新的，7种
    //isolation：事务隔离级别
    //timeout：超时时间
    //readOnly：是否只读
    //rollbackFor：回滚
    //noRollbackFor：不回滚
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ,
            timeout = -1, readOnly = false)
    public void accountMoney() {
        bookDao.reduceMoney();
        //int a = 10 / 0;

        bookDao.addMoney();
    }
}
