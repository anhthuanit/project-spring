/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faber.servlet;

import com.faber.business.EmployeeBS;
import com.faber.dto.EmployeeDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();
        PrintWriter out = response.getWriter();

        EmployeeBS employeeBS = new EmployeeBS();

        if (path.equals("/ModifyEmployee")) {
            String idemp = request.getParameter("idemp");
            if (idemp != null) {
                // show employee detail
                out.print(employeeBS.getEmployeeById(Integer.parseInt(idemp)));
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        PrintWriter out = response.getWriter();

        EmployeeBS employeeBS = new EmployeeBS();

        if (path.equals("/AddEmployee")) {

            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            String dept = request.getParameter("dept");
            String salary = request.getParameter("salary");

            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(Integer.parseInt(id));
            employeeDTO.setName(name);
            employeeDTO.setDept(dept);
            employeeDTO.setAge(Integer.parseInt(age));
            employeeDTO.setSalary(Integer.parseInt(salary));

            out.print(employeeBS.addEmployee(employeeDTO));

        } else if (path.equals("/ModifyEmployee")) {

            // execute modify employee
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            String dept = request.getParameter("dept");
            String salary = request.getParameter("salary");

            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(Integer.parseInt(id));
            employeeDTO.setName(name);
            employeeDTO.setDept(dept);
            employeeDTO.setAge(Integer.parseInt(age));
            employeeDTO.setSalary(Integer.parseInt(salary));

            out.print(employeeBS.modifyEmployee(employeeDTO));

        } else if (path.equals("/DeleteEmployee")) {

            String id = request.getParameter("id");
            out.print(employeeBS.deleteEmployee(Integer.parseInt(id)));
            
        } else if (path.equals("/AllEmployee")) {
            
            out.print(employeeBS.getAllEmployee());
            
        }
    }

}
