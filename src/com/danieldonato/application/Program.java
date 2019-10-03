package com.danieldonato.application;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.danieldonato.model.dao.DaoFactory;
import com.danieldonato.model.dao.DepartmentDao;
import com.danieldonato.model.dao.SellerDao;
import com.danieldonato.model.dao.impl.SellerDaoJDBC;
import com.danieldonato.model.entities.Department;
import com.danieldonato.model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("=== TEST 1: findById =======");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: findByDepartment =======");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: findAll =======");
		List<Seller> list2 = sellerDao.findAll();
		for(Seller obj : list2) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: insert =======");
		Seller newSeller = new Seller(null, "Greeg", "greg@gmail.com", new java.util.Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id: " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: update =======");
		seller = sellerDao.findById(1);
		seller.setName("Carlos");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 6: delete =======");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
	
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST 1: findById =======");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: findAll =======");
		List<Department> list3 = departmentDao.findAll();
		for (Department d : list3) {
			System.out.println(d);
		}

		System.out.println("\n=== TEST 3: insert =======");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());

		System.out.println("\n=== TEST 4: update =======");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: delete =======");
		System.out.print("Enter id for delete test: ");
		id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
