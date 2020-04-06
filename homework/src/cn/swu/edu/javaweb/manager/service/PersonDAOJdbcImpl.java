package cn.swu.edu.javaweb.manager.service;

import java.util.List;

import cn.swu.edu.javaweb.dao.DAO;
import cn.swu.edu.javaweb.manager.dao.PersonDAO;
import cn.swu.edu.javaweb.manager.pojo.CriteriaPerson;
import cn.swu.edu.javaweb.manager.pojo.Person;

public class PersonDAOJdbcImpl extends DAO<Person> implements PersonDAO{

	@Override
	public List<Person> getAll() {
		// TODO Auto-generated method stub
		String sql = "select * from person";
		return getForList(sql);
	}

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub
		String sql = "insert into person(name,position,office,age,start_date,salary) values(?,?,?,?,?,?)";
		update(sql, person.getName(),person.getPosition(),person.getOffice(),person.getAge(),person.getsDate(),person.getSalary());
	}

	@Override
	public Person get(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from person where id = ?";
		return get(sql,id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from person where id = ?";
		update(sql,id);
	}

	@Override
	public long getCountWithName(String name) {
		// TODO Auto-generated method stub
		
		String sql = "select count(id) from person where name = ?";
		return getForValue(sql, name);
	}


	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub
		String sql = "update person set name = ? , position = ? , office = ? , age = ? , start_date = ? , salary = ? where id = ?";
		update(sql,person.getName(),person.getPosition(),person.getOffice(),person.getAge(),person.getsDate(),person.getSalary(),person.getId());
	}

	@Override
	public List<Person> getForListWithCriteriaCustomer(CriteriaPerson criteriaPerson) {
		String sql = "SELECT * FROM person WHERE " +
				"name LIKE ? AND position LIKE ? AND office LIKE ? AND age LIKE ? AND start_date LIKE ? AND salary LIKE ?";
				
		return getForList(sql, criteriaPerson.getName(),criteriaPerson.getPosition(),criteriaPerson.getOffice(),criteriaPerson.getAge(),criteriaPerson.getsDate(),criteriaPerson.getSalary());
	}

	
	
}