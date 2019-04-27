package cn.swu.edu.javaweb;

public class Student {
	
	//典型的javaBean
	private Integer id;
	private String name;
	private String age;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
		System.out.println("Student constructor...");
	}

}
