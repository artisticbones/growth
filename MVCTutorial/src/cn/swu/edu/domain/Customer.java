package cn.swu.edu.domain;

public class Customer {
	
	private Integer id;
	
	private String name;
	
	private String address;
	
	private String phone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getAddress() {
		if (address == null) {
			address = "%%";
		}else {
			address = "%" + address + "%";
		}
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		if (phone == null) {
			phone = "%%";
		}else {
			phone = "%" + phone + "%";
		}
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
	
	
}
