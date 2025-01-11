package com.Main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Department;
import com.entity.Employee;

public class MainClass {
	
	public static void main(String[] args) {
		
	     Configuration cfg=new Configuration();
	      cfg.configure("hibernate.cfg.xml");
	      cfg.addAnnotatedClass(Employee.class);
	      cfg.addAnnotatedClass(Department.class);
	      SessionFactory sf=cfg.buildSessionFactory();
	      Session ss=sf.openSession();
	      Transaction tr=ss.beginTransaction();
	      
	      Department d=new Department();
	      d.setD_id(102);
	      d.setD_name("Aws");
	      ss.persist(d);
	      
	      Employee e1= new Employee();
	      e1.setId(13);
	      e1.setName("Jija");
	      e1.setDept(d);
	      ss.persist(e1);
	      
	      Employee e2= new Employee();
	      e2.setId(14);
	      e2.setName("Kiaan");
	      e2.setDept(d);
	      ss.persist(e2);
	      
	      List<Employee> emp = new ArrayList<>();
	        emp.add(e1);
	        emp.add(e2);
	        d.setEmp(emp);
	        
	        tr.commit();
	        ss.close();
	      
	      
	      
	      
	      
	      
	      
}
}
