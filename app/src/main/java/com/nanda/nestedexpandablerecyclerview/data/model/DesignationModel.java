package com.nanda.nestedexpandablerecyclerview.data.model;

import java.util.List;

public class DesignationModel {

    private String designationId;
    private String designation;
    private List<EmployeeModel> employeeModelList;
    private boolean isExpanded;

    public DesignationModel(String designationId, String designation, List<EmployeeModel> employeeModelList) {
        this.designationId = designationId;
        this.designation = designation;
        this.employeeModelList = employeeModelList;
    }

    public String getDesignationId() {
        return designationId;
    }

    public void setDesignationId(String designationId) {
        this.designationId = designationId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<EmployeeModel> getEmployeeModelList() {
        return employeeModelList;
    }

    public void setEmployeeModelList(List<EmployeeModel> employeeModelList) {
        this.employeeModelList = employeeModelList;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
