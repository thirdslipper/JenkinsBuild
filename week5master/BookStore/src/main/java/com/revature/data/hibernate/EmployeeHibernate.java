package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Employee;
import com.revature.data.EmployeeDAO;
import com.revature.utils.HibernateUtil;

public class EmployeeHibernate implements EmployeeDAO{
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public void addEmployee(Employee employee) {
		Session s = hu.getSession();
		Transaction t = s.beginTransaction();
		try {
			s.save(employee);
			t.commit();
		} catch (HibernateException e) {
			t.rollback();
		} finally {
			s.close();
		}
	}

	@Override
	public Employee getEmployee(Employee emp) {
		Session s = hu.getSession();
		Employee e;
		if (emp.getId() != 0) {
			// this means we're going to retrieve by id
			e = s.get(Employee.class, emp.getId());
		} else {
			// this means we're getting by user/pass
			String query = "from Employee e where e.username=:username and e.password=:password";
			Query<Employee> q = s.createQuery(query, Employee.class);
			q.setParameter("username", emp.getUsername());
			q.setParameter("password", emp.getPassword());
			e = q.uniqueResult();
		}
		return e;
	}

	@Override
	public Set<Employee> getEmployees() {
		Session s = hu.getSession();
		String query = "FROM Employee";
		Query<Employee> q = s.createQuery(query, Employee.class);
		List<Employee> empList = q.getResultList();
		Set<Employee> empSet = new HashSet<Employee>();
		empSet.addAll(empList);
		return empSet;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		Session s = hu.getSession();
		Transaction t = s.beginTransaction();
		s.delete(employee);
		t.commit();
		s.close();
	}

	@Override
	public void updateEmployee(Employee employee) {
		Session s = hu.getSession();
		Transaction t = s.beginTransaction();
		s.update(employee);
		t.commit();
		s.close();
	}
}
