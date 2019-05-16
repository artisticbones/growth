package cn.swu.edu.javaweb.listener;


public class ClassTest {

	public void test() {

		Customer customer1 = new Customer();
		Customer customer2 = new Customer();
		
		System.out.println(customer1.getClass() == customer2.getClass());
	}

}
