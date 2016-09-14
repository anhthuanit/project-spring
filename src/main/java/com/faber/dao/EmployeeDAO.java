/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faber.dao;

import com.faber.connectionDB.DBConnect;
import com.faber.dto.EmployeeDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class EmployeeDAO {

    public List<EmployeeDTO> getAllEmployee() {
        List<EmployeeDTO> listResult = new ArrayList<EmployeeDTO>();

        DBConnect db = new DBConnect();
        String sql = "SELECT * FROM EMPLOYEE";
        try {
            db.connect();
            ResultSet rs = db.getStatement().executeQuery(sql);
            while (rs.next()) {
                EmployeeDTO employeeDTO = new EmployeeDTO();
                employeeDTO.setId(rs.getInt("ID"));
                employeeDTO.setName(rs.getString("NAME"));
                employeeDTO.setAge(rs.getInt("AGE"));
                employeeDTO.setDept(rs.getString("DEPT"));
                employeeDTO.setSalary(rs.getInt("SALARY"));
                listResult.add(employeeDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                db.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listResult;
    }

    public EmployeeDTO getEmployeeById(Integer id) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        ResultSet rs = null;
        // call db
        DBConnect db = new DBConnect();
        String sql = "SELECT * FROM EMPLOYEE WHERE ID=?";
        try {
            db.connect();

            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                employeeDTO.setId(rs.getInt("ID"));
                employeeDTO.setName(rs.getString("NAME"));
                employeeDTO.setAge(rs.getInt("AGE"));
                employeeDTO.setDept(rs.getString("DEPT"));
                employeeDTO.setSalary(rs.getInt("SALARY"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                db.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return employeeDTO;
    }

    public Integer addEmployee(EmployeeDTO employeeDTO) {
        Integer result = 0;
        // call db
        DBConnect db = new DBConnect();

        String sql = "INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)";
        try {
            db.connect();
            PreparedStatement addStatetment = db.getConnection().prepareStatement(sql);
            addStatetment.setInt(1, employeeDTO.getId());
            addStatetment.setString(2, employeeDTO.getName());
            addStatetment.setInt(3, employeeDTO.getAge());
            addStatetment.setString(4, employeeDTO.getDept());
            addStatetment.setInt(5, employeeDTO.getSalary());

            result = addStatetment.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                db.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public Integer modifyEmployee(EmployeeDTO employeeDTO) {
        Integer result = 0;
        // call db
        DBConnect db = new DBConnect();

        String sql = "UPDATE EMPLOYEE SET NAME=?,AGE=?,DEPT=?,SALARY=? WHERE ID=?";
        try {
            db.connect();
            PreparedStatement updateStatetment = db.getConnection().prepareStatement(sql);
            updateStatetment.setString(1, employeeDTO.getName());
            updateStatetment.setInt(2, employeeDTO.getAge());
            updateStatetment.setString(3, employeeDTO.getDept());
            updateStatetment.setInt(4, employeeDTO.getSalary());
            updateStatetment.setInt(5, employeeDTO.getId());
            result = updateStatetment.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                db.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public Integer deleteEmployee(Integer id) {
        Integer result = 0;
        // call db
        DBConnect db = new DBConnect();
        String sql = "DELETE FROM EMPLOYEE WHERE ID=?";
        try {
            db.connect();
            PreparedStatement deleteStatetment = db.getConnection().prepareStatement(sql);
            deleteStatetment.setInt(1, id);
            result = deleteStatetment.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                db.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
}
