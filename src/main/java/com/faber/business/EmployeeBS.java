package com.faber.business;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.faber.dao.EmployeeDAO;
import com.faber.dto.EmployeeDTO;
import com.google.gson.Gson;
//</editor-fold>

/**
 *
 * @author Ho Anh Thuan
 */
public class EmployeeBS {

    EmployeeDAO employeeDAO = new EmployeeDAO();

    //<editor-fold defaultstate="collapsed" desc="GET ALL EMPLOYEE">
    public String getAllEmployee() {
        String result;

        Gson gson = new Gson();
        result = gson.toJson(employeeDAO.getAllEmployee());

        return result;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GET EMPLOYEE BY ID">
    public String getEmployeeById(Integer id) {
        String result;

        Gson gson = new Gson();
        result = gson.toJson(employeeDAO.getEmployeeById(id));

        return result;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ADD EMPLOYEE">
    public String addEmployee(EmployeeDTO employeeDTO) {
        if (1 == employeeDAO.addEmployee(employeeDTO)) {
            return "success";
        } else {
            return "fail";
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="MODIFY EMPLOYEE">
    public String modifyEmployee(EmployeeDTO employeeDTO) {
        if (1 == employeeDAO.modifyEmployee(employeeDTO)) {
            return "success";
        } else {
            return "fail";
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="DELETE EMPLOYEE">
     public String deleteEmployee(Integer id) {
        if (1 == employeeDAO.deleteEmployee(id)) {
            return "success";
        } else {
            return "fail";
        }
    }
    //</editor-fold>
   
}
