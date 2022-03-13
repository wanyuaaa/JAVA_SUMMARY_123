package com.test.spring.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wanyu
 * @createTime 2022-03-14 1:50
 */
public class Log4j2Test {
    private static final Logger log = LoggerFactory.getLogger(Log4j2Test.class);

    public static void main(String[] args) {
        log.info("hello log4j2?");
        log.debug("hello log4j2!");
    }
}
