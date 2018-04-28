package com.kodilla.hibernate.manytomany.facade;

import org.springframework.stereotype.Service;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

//@NamedQueries({
        /*@NamedQuery(
                name = "com.kodilla.hibernate.manytomany.Company.findCompaniesByNamePart",
                query = "FROM COMPANIES WHERE COMPANY_NAME like :NAMEPART"
        ),*/

@NamedQuery(
        name = "Employee.findEmployeesWithLastNamePart",
        query = "FROM Employee WHERE lastname like :LASTNAMEPART"
)
/*})*/

@Service
public class SearchFacade {
}
