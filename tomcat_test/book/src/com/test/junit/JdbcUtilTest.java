package com.test.junit;

import com.test.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author wanyu
 * @createTime 2022-03-07 1:58
 */
public class JdbcUtilTest {
    @Test
    public void test1(){
        Connection connection = JdbcUtils.getConnection();

        JdbcUtils.close(connection);
    }
}
