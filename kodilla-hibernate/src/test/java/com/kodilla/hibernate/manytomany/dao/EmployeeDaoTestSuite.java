package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
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
public class EmployeeDaoTestSuite {
    @Autowired
    EmployeeDao employeeDao;

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

        List<Integer> employeeIds = new ArrayList<>();

        employeeDao.save(johnSmith);
        employeeIds.add(johnSmith.getId());
        employeeDao.save(stephanieClarckson);
        employeeIds.add(stephanieClarckson.getId());
        employeeDao.save(lindaKovalsky);
        employeeIds.add(lindaKovalsky.getId());

        return employeeIds;
    }

    @Test
    public void testSearchForEmployeesWithLastName() {
        //Given
        List<Integer> employeeIds = prepareTestData();

        //When
        List<Employee> employees = employeeDao.findEmployeesWithLastName("Smith");

        //Then
        Assert.assertEquals(1, employees.size());

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
