package cn.swu.edu.javaweb.manager.pojo;

public class CriteriaPerson {
	private String name;
	
	private String position;
	
	private String office;
	
	private String age;
	
	private String sDate;

	private String salary;

	public String getName() {
		if (name == null) {
			name = "%%";
		}else {
			name = "%" + name + "%";
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		if (position == null) {
			position = "%%";
		}else {
			position = "%" + position + "%";
		}
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getOffice() {
		if (office == null) {
			office = "%%";
		}else {
			office = "%" + office + "%";
		}
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getAge() {
		if (age == null) {
			age = "%%";
		}else {
			age = "%" + age + "%";
		}
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getsDate() {
		if (sDate == null) {
			sDate = "%%";
		}else {
			sDate = "%" + sDate + "%";
		}
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String getSalary() {
		if (salary == null) {
			salary = "%%";
		}else {
			salary = "%" + salary + "%";
		}
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public CriteriaPerson(String name, String position, String office, String age, String sDate, String salary) {
		super();
		this.name = name;
		this.position = position;
		this.office = office;
		this.age = age;
		this.sDate = sDate;
		this.salary = salary;
	}



	
	
}
