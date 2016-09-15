package com.faber.dao;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.faber.connectionDB.DBConnect;
import com.faber.dto.EmployeeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//</editor-fold>

/**
 *
 * @author Ho Anh Thuan
 */
public class EmployeeDAO {

    //<editor-fold defaultstate="collapsed" desc="GET ALL EMPLOYEE">
    public List<EmployeeDTO> getAllEmployee() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<EmployeeDTO> listResult = new ArrayList<>();

        String sql = "SELECT * FROM EMPLOYEE";
        try {
            con = DBConnect.connect();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EmployeeDTO employeeDTO = new EmployeeDTO();
                employeeDTO.setId(rs.getInt("ID"));
                employeeDTO.setName(rs.getString("NAME"));
                employeeDTO.setAge(rs.getInt("AGE"));
                employeeDTO.setDept(rs.getString("DEPT"));
                employeeDTO.setSalary(rs.getInt("SALARY"));
                listResult.add(employeeDTO);
            }
        } catch (Exception e) {
        } finally {
            try {
                if(con != null){
                    con.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(rs != null){
                    rs.close();
                }
            } catch (Exception ex) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listResult;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GET EMPLOYEE BY ID">
    public EmployeeDTO getEmployeeById(Integer id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        EmployeeDTO employeeDTO = new EmployeeDTO();
        
        String sql = "SELECT * FROM EMPLOYEE WHERE ID=?";
        try {
            con = DBConnect.connect();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                employeeDTO.setId(rs.getInt("ID"));
                employeeDTO.setName(rs.getString("NAME"));
                employeeDTO.setAge(rs.getInt("AGE"));
                employeeDTO.setDept(rs.getString("DEPT"));
                employeeDTO.setSalary(rs.getInt("SALARY"));
            }
        } catch (Exception e) {
        } finally {
            try {
                if(rs != null){
                    rs.close();
                }
                if(con!=null){
                con.close();
                }
            } catch (Exception ex) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return employeeDTO;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ADD EMPLOYEE">
    public Integer addEmployee(EmployeeDTO employeeDTO) {
        Integer result = 0;
        Connection con = null;
        PreparedStatement ps = null;

        String sql = "INSERT INTO EMPLOYEE(ID,NAME,AGE,DEPT,SALARY) VALUES(?,?,?,?,?)";
        try {
            con = DBConnect.connect();
            PreparedStatement addStatetment = con.prepareStatement(sql);
            addStatetment.setInt(1, employeeDTO.getId());
            addStatetment.setString(2, employeeDTO.getName());
            addStatetment.setInt(3, employeeDTO.getAge());
            addStatetment.setString(4, employeeDTO.getDept());
            addStatetment.setInt(5, employeeDTO.getSalary());

            result = addStatetment.executeUpdate();
        } catch (Exception e) {
        } finally {
            try {
                if(con != null){
                    con.close();
                }
                if(ps != null){
                    ps.close();
                }
            } catch (Exception ex) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    //</editor-fold>
    

    //<editor-fold defaultstate="collapsed" desc="MODIFY EMPLOYEE">
    public Integer modifyEmployee(EmployeeDTO employeeDTO) {
        Integer result = 0;
        Connection con = null;
        PreparedStatement ps = null;

        String sql = "UPDATE EMPLOYEE SET NAME=?,AGE=?,DEPT=?,SALARY=? WHERE ID=?";
        try {
            con = DBConnect.connect();
            PreparedStatement updateStatetment = con.prepareStatement(sql);
            updateStatetment.setString(1, employeeDTO.getName());
            updateStatetment.setInt(2, employeeDTO.getAge());
            updateStatetment.setString(3, employeeDTO.getDept());
            updateStatetment.setInt(4, employeeDTO.getSalary());
            updateStatetment.setInt(5, employeeDTO.getId());
            result = updateStatetment.executeUpdate();
        } catch (Exception e) {
        } finally {
            try {
                if(con != null){
                    con.close();
                }
                if(ps != null){
                    ps.close();
                }
            } catch (Exception ex) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Delete Employee">
    public Integer deleteEmployee(Integer id) {
        Integer result = 0;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM EMPLOYEE WHERE ID=?";
        try {
            con = DBConnect.connect();
            PreparedStatement deleteStatetment = con.prepareStatement(sql);
            deleteStatetment.setInt(1, id);
            result = deleteStatetment.executeUpdate();
        } catch (Exception e) {
        } finally {
            try {
                if(con != null){
                    con.close();
                }
                if(ps != null){
                    ps.close();
                }
            } catch (Exception ex) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    //</editor-fold>
    
}
