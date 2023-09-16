package com.Mst.SpringRESTAPIDemo.entity;

public class Students {

    private int id;
    private String name;
    private String department;

    public Students() {
    }

    public Students(String name, String department, int id) {
        this.name = name;
        this.department = department;
        this.id=id;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
