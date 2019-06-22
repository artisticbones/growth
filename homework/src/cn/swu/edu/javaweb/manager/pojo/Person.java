package cn.swu.edu.javaweb.manager.pojo;

public class Person {
	
	private Integer id;
	
	private String name;
	
	private String position;
	
	private String office;
	
	private String age;
	
	private String sDate;

	private String salary;
	
	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", position=" + position + ", office=" + office + ", age=" + age
				+ ", date=" + sDate + ", salary=" + salary + "]";
	}

	public Person(Integer id, String name, String position, String office, String age, String sDate, String salary) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.office = office;
		this.age = age;
		this.sDate = sDate;
		this.salary = salary;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	
}
