package com.he.springboot.Controller;

import com.he.springboot.dao.DepartmentDao;
import com.he.springboot.dao.EmployeeDao;
import com.he.springboot.entities.Department;
import com.he.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String findAll(Map<String,Object> map){
        Collection<Employee> employees = employeeDao.getAll();
        map.put("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddEmp(Map<String,Object> map){
        Collection<Department> department = departmentDao.getDepartments();
        map.put("deps",department);
        return "emp/add";
    }

//    springmvc会将请求参数和入参对象一一绑定，前提是请求参数名字和javabean入参对象里面的属性名相同
    @PostMapping("emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
//        redirect是重定向    /代表当前项目路径
//        forward是转发
//        直接发送emps请求到list页面
        return "redirect:/emps";
    }

//    @PathVariable("id")会将路径中的id值当成参数传进方法
    @GetMapping("emp/{id}")
    public String toEditPage(@PathVariable("id") int id, Model model){
//        查出对应id的员工
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
//        查出部门并添加
        Collection<Department> department = departmentDao.getDepartments();
        model.addAttribute("deps",department);
//        返回添加页面，将添加页面和修改页面二合一
        return "emp/add";
    }

//    接收put请求
    @PutMapping("emp")
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("emp/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        employeeDao.delete(id);
        System.out.println(id);
        return "redirect:/emps";
    }

}
