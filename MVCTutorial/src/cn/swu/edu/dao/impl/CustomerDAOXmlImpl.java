package cn.swu.edu.dao.impl;

import java.util.List;

import cn.swu.edu.CriteriaCustomer;
import cn.swu.edu.CustomerDAO;
import cn.swu.edu.domain.Customer;

public class CustomerDAOXmlImpl implements CustomerDAO{

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		System.out.println("getAll");
		return null;
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("save");
	}

	@Override
	public Customer get(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("get");
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("delete");
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("update");
	}

	@Override
	public long getCountWithName(String name) {
		// TODO Auto-generated method stub
		System.out.println("getCountWithName");
		return 0;
	}

	@Override
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
		// TODO Auto-generated method stub
		System.out.println("getForListWithCriteriaCustomer");
		return null;
	}

}
