package com.nanda.nestedexpandablerecyclerview.data.mapper;

import com.nanda.nestedexpandablerecyclerview.data.model.CompanyModel;
import com.nanda.nestedexpandablerecyclerview.data.model.DesignationModel;
import com.nanda.nestedexpandablerecyclerview.data.model.EmployeeModel;

import java.util.ArrayList;
import java.util.List;

public class CompanyMapper {

    public static List<CompanyModel> getCompanyModelList() {
        List<CompanyModel> companyModelList = new ArrayList<>();

        companyModelList.add(new CompanyModel("1", "Android", getDesignationList(2)));
        companyModelList.add(new CompanyModel("1", "iOS", getDesignationList(1)));
        companyModelList.add(new CompanyModel("1", "Web", getDesignationList(3)));

        return companyModelList;
    }

    public static List<DesignationModel> getDesignationList(int type) {
        switch (type) {
            case 1:
                return getDesignationListBySize(type, 4);
            case 2:
                return getDesignationListBySize(type, 6);
            case 3:
                return getDesignationListBySize(type, 2);
        }
        return new ArrayList<>();
    }

    public static List<DesignationModel> getDesignationListBySize(int type, int size) {
        List<DesignationModel> designationModelList = new ArrayList<>(10);
        for (int i = 0; i < size; i++) {
            designationModelList.add(new DesignationModel("" + i, "Designation - " + i, getEmployeeList(type)));
        }
        return designationModelList;
    }

    public static List<EmployeeModel> getEmployeeList(int type) {
        switch (type) {
            case 1:
                return getEmployeeListBySize(10);
            case 2:
                return getEmployeeListBySize(5);
            case 3:
                return getEmployeeListBySize(4);
        }
        return new ArrayList<>();
    }

    public static List<EmployeeModel> getEmployeeListBySize(int size) {
        List<EmployeeModel> employeeModelList = new ArrayList<>(10);
        for (int i = 0; i < size; i++) {
            employeeModelList.add(new EmployeeModel("" + i, "User - " + i));
        }
        return employeeModelList;
    }


}
