package cn.swu.edu.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import cn.swu.edu.CriteriaCustomer;
import cn.swu.edu.CustomerDAO;
import cn.swu.edu.dao.impl.CustomerDAOJdbcImpl;
import cn.swu.edu.domain.Customer;

class CustomerDAOJdbcImplTest {
	
	
	private CustomerDAO customerDAO = new CustomerDAOJdbcImpl();
	
	@Test
	public void testGetForListWithCriteriaCustomer() {
		CriteriaCustomer criteriaCustomer = new CriteriaCustomer("o", null, null);
		List<Customer> customers = customerDAO.getForListWithCriteriaCustomer(criteriaCustomer);
		
		System.out.println(customers);
	}
	
	@Test
	void testGetAll() {
		List<Customer> customers = customerDAO.getAll();
		System.out.println(customers);
	}

	@Test
	void testSave() {
		Customer customer = new Customer();
		
		customer.setAddress("Beijing");
		customer.setName("Jerry");
		customer.setPhone("199199127283");
		
		customerDAO.save(customer);
	}

	@Test
	public void testGetInteger() {
		
		Customer cust = customerDAO.get(1);
		System.out.println(cust);
	}

	@Test
	void testDelete() {
		customerDAO.delete(1);
	}

	@Test
	void testGetCountWithName() {
		long count = customerDAO.getCountWithName("0");
		System.out.println(count);
	}

}
