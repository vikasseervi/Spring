package com.vikas.rest.project.dao;

import com.vikas.rest.project.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImple implements EmployeeDAO {
    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOJpaImple(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    // @Transactional will be handled by Service layer instead of DAO layer

    @Override
    public Employee save(Employee employee) {
        // merge will update and create with new id if the object is not found
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee employee = findById(id);
        entityManager.remove(employee);
    }

}
