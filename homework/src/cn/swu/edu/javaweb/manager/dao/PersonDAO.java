package cn.swu.edu.javaweb.manager.dao;

import java.util.List;

import cn.swu.edu.javaweb.manager.pojo.CriteriaPerson;
import cn.swu.edu.javaweb.manager.pojo.Person;

public interface PersonDAO {
	
	public List<Person> getAll();
	
	public void save(Person person);
	
	public Person get(Integer id);
	
	public void delete(Integer id);
	
	public void update(Person person);
	
	/**
	 * 返回和name相等的记录数。
	 * @param name
	 * @return
	 */
	public long getCountWithName(String name);
	
	public List<Person> getForListWithCriteriaCustomer(CriteriaPerson criteriaPerson);
	
}
