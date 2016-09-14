/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faber.business;

import com.faber.dao.EmployeeDAO;
import com.faber.dto.EmployeeDTO;
import com.google.gson.Gson;

/**
 *
 * @author root
 */
public class EmployeeBS {
    
    EmployeeDAO employeeDAO = new EmployeeDAO();
    
    public String getAllEmployee(){
        String result;
        
        Gson gson = new Gson();
        result = gson.toJson(employeeDAO.getAllEmployee());
        
        return result;
    }
    
    public String getEmployeeById(Integer id){
        String result;
        
        Gson gson = new Gson();
        result = gson.toJson(employeeDAO.getEmployeeById(id));
        
        return result;
    }
    
    public String addEmployee(EmployeeDTO employeeDTO){
        if(1 == employeeDAO.addEmployee(employeeDTO)){
            return "success";
        }
        else{
            return "fail";
        }
    }
    
    public String modifyEmployee(EmployeeDTO employeeDTO){
        if(1 == employeeDAO.modifyEmployee(employeeDTO)){
            return "success";
        }
        else{
            return "fail";
        }
    }
    
    public String deleteEmployee(Integer id){
        if(1 == employeeDAO.deleteEmployee(id)){
            return "success";
        }
        else{
            return "fail";
        }
    }
}
