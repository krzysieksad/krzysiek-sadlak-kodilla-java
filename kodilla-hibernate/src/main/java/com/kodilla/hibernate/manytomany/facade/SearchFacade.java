package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchFacade {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    public List<Company> findCompaniesByPartOfName(final String partOfName) {
        return companyDao.findCompaniesByPartOfName(partOfName);
    }

    public List<Employee> findEmployeesByPartOfLastName(final String lastNamePart) {
        return employeeDao.findEmployeesByPartOfLastName(lastNamePart);
    }
}