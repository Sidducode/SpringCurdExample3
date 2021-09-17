package com.spring.beans;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class EmployeeDao {

	
	  private HibernateTemplate hibernateTemplate;

	

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	  
	  
	public void saveEmployee(Employee emp) {
		
		hibernateTemplate.save(emp);
	}
	
	
	public void updateEmployee(Employee emp1) {
		hibernateTemplate.update(emp1);
	}
	
	public void deleteEmployee(int id) {
		
		Employee emp2 = hibernateTemplate.get(Employee.class,id);
		hibernateTemplate.delete(emp2);
		
	}
	
	
	public  Employee getEmployee(int id) {
		Employee emp3 =hibernateTemplate.get(Employee.class, id);
		return emp3;
	}
	
	
	
	public List<Employee> getAllEmployee(){
		return hibernateTemplate.execute(new HibernateCallback<List<Employee>>() {
			@Override
			public List<Employee> doInHibernate(Session session) throws HibernateException {
				Query<Employee> query = session.createQuery("from Employee");
				List<Employee> list = query.list();
				return list;
			}
		});
			
		}
	}
	
	
	
	

