package com.nanda.nestedexpandablerecyclerview.data.model;

import java.util.List;

public class CompanyModel {

    private String companyId;
    private String companyName;
    private List<DesignationModel> designationModelList;

    public CompanyModel(String companyId, String companyName, List<DesignationModel> designationModelList) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.designationModelList = designationModelList;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<DesignationModel> getDesignationModelList() {
        return designationModelList;
    }

    public void setDesignationModelList(List<DesignationModel> designationModelList) {
        this.designationModelList = designationModelList;
    }
}
