package org.jl.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jl.to.EmployeeTo;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class EmployeeDAOImpl extends HibernateDaoSupport
implements EmployeeDAO{

	

	@Override
	public EmployeeTo isValidUser(String fname, String lname) {
		
		 Object[] params = {fname,lname};
	     List users = getHibernateTemplate().find("FROM EmployeeTo where first_name=? and last_name=?",params);
	     if(users.size()<=0){
	            System.out.println("null ");
	            return null;
	      }else{
	            System.out.println("not null ");
	            return (EmployeeTo)users.get(0);
	      }
		
		
	}

	@Override
	public List getAllEmployees() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("From EmployeeTo");
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		EmployeeTo emp = getHibernateTemplate().load(EmployeeTo.class, id);
		getHibernateTemplate().delete(emp);
		
	}

	@Override
	public void addEmployee(EmployeeTo emp) {
		getHibernateTemplate().persist(emp);
		
	}

	@Override
	public EmployeeTo getEmployee(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(EmployeeTo.class, id);
	}

	@Override
	public void updateEmployee(EmployeeTo emp) {
		getHibernateTemplate().update(emp);
		
	}

	@Override
	public EmployeeTo emailAlreadyExists(final EmployeeTo emp) {
		// TODO Auto-generated method stub
		 List results = getHibernateTemplate().executeFind(new HibernateCallback() {
	            public Object doInHibernate(Session session) throws HibernateException, SQLException {
	                Query query = session.createQuery("from EmployeeTo e where e.email=?");
	                query.setString(0, emp.getEmail());
	               
	                return query.list();
	            }
	        });
		 if(results.size()>0 ){
			 return (EmployeeTo)results.get(0);
		 }else
			 return null;
	}

	@Override
	public List getJobIds(final String jobId) {
		// TODO Auto-generated method stub
		 List results = getHibernateTemplate().executeFind(new HibernateCallback() {
	            public Object doInHibernate(Session session) throws HibernateException, SQLException {
	                Query query = session.createQuery("Select distinct jobId from EmployeeTo where jobId like ?");
	                query.setString(0, "%"+jobId+"%");
	               
	                return query.list();
	            }
	        });
		 return results;
	}
	
	
	
	

}
