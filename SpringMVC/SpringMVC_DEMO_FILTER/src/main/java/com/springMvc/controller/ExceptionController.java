package com.springMvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author wanyu
 * @createTime 2022-03-16 15:51
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = {ArithmeticException.class})
    public String textException(Exception ex, Model model){
        model.addAttribute("ex",ex);
        return "erro";
    }
}
