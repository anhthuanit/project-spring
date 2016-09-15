package com.faber.dto;

/**
 *
 * @author Ho Anh Thuan
 */
public class EmployeeDTO {
    private Integer id;
    private String name;
    private Integer age;
    private String dept;
    private Integer salary;

    public EmployeeDTO() {
        this.id = 0;
        this.name = "";
        this.age = 0;
        this.dept = "";
        this.salary = 0;
    }
    
    public EmployeeDTO(Integer id, String name, Integer age, String dept, Integer salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dept = dept;
        this.salary = salary;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    
}
