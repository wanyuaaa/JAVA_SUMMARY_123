package com.springMvc.controller;

import com.springMvc.bean.Employee;
import com.springMvc.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @author wanyu
 * @createTime 2022-03-15 17:14
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String employee(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("employeeList",all);
        return "employee";
    }
}
