package com.danieldonato.model.dao;

import com.danieldonato.db.DB;
import com.danieldonato.model.dao.impl.DepartmentDaoJDBC;
import com.danieldonato.model.dao.impl.SellerDaoJDBC;

public interface DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}

	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
	
}
