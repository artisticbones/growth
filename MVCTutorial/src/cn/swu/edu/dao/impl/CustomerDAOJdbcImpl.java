package cn.swu.edu.dao.impl;

import java.util.List;

import cn.swu.edu.CriteriaCustomer;
import cn.swu.edu.CustomerDAO;
import cn.swu.edu.DAO;
import cn.swu.edu.domain.Customer;

public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO{

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		String sql = "select id,name,address,phone from customers";
		return getForList(sql);
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "insert into customers(name,address,phone) values(?,?,?)";
		update(sql, customer.getName(),customer.getAddress(),customer.getPhone());
	}

	@Override
	public Customer get(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from customers where id = ?";
		return get(sql,id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from customers where id = ?";
		update(sql,id);
	}

	@Override
	public long getCountWithName(String name) {
		// TODO Auto-generated method stub
		
		String sql = "select count(id) from customers where name = ?";
		return getForValue(sql, name);
	}

	@Override
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
		// TODO Auto-generated method stub
		String sql = "SELECT id,name,address,phone FROM customers WHERE" +
		"name LIKE ? AND address LIKE ? AND phone LIKE ?";
		
		return getForList(sql, cc.getName(),cc.getAddress(),cc.getPhone());
	}
	
}