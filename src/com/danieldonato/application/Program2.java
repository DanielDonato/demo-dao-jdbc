package com.danieldonato.application;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.danieldonato.model.dao.DaoFactory;
import com.danieldonato.model.dao.SellerDao;
import com.danieldonato.model.dao.impl.SellerDaoJDBC;
import com.danieldonato.model.entities.Department;
import com.danieldonato.model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		System.out.println("===============");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("===============");
		List<Seller> list2 = sellerDao.findAll();
		for(Seller obj : list2) {
			System.out.println(obj);
		}
		System.out.println("===============");
		Seller newSeller = new Seller(null, "Greeg", "greg@gmail.com", new java.util.Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id: " + newSeller.getId());
		System.out.println("===============");
		seller = sellerDao.findById(1);
		seller.setName("Carlos");
		sellerDao.update(seller);
		System.out.println("Completou");
		System.out.println("===============");
		System.out.println("Digite um id para deletar");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deletou");
		sc.close();
	}

}
