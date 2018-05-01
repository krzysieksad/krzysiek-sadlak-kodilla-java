package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchFacadeDaoTestSuite {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    CompanyDao companyDao;
    @Autowired
    SearchFacade searchFacade;

    private List<Integer> prepareTestData() {
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");
        Company greenLight = new Company("Green Light");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);
        greenLight.getEmployees().add(stephanieClarckson);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(greenLight);

        List<Integer> companyIds = new ArrayList<>();

        companyDao.save(softwareMachine);
        companyIds.add(softwareMachine.getId());
        companyDao.save(dataMaesters);
        companyIds.add(dataMaesters.getId());
        companyDao.save(greyMatter);
        companyIds.add(greyMatter.getId());
        companyDao.save(greenLight);
        companyIds.add(greenLight.getId());

        return companyIds;
    }

    @Test
    public void testSearchForCompanyNamePart() {
        //Given
        List<Integer> companyIds = prepareTestData();

        //When
        List<Company> companies = searchFacade.findCompaniesByPartOfName("%Ma%");

        //Then
        Assert.assertEquals(3, companies.size());

        //CleanUp
        try {
            for (int companyId : companyIds) {
                companyDao.delete(companyId);
            }
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testSearchForEmployeesWithLastNamePart() {
        //Given
        List<Integer> employeeIds = prepareTestData();

        //When
        List<Employee> employees = searchFacade.findEmployeesByPartOfLastName("%l%");

        //Then
        Assert.assertEquals(2, employees.size());

        //CleanUp
        try {
            for (int employeeId : employeeIds) {
                employeeDao.delete(employeeId);
            }
        } catch (Exception e) {
            //do nothing
        }
    }
}