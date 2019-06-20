package cn.swu.edu.javaweb.login.pojo;

public class LoginUser {

    private Integer id;

    private String username;

    private String password;
    
    private String phone;
    
    private String address;
    
    private String realName;

    public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public LoginUser(Integer id, String username, String password, String phone, String address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LoginUser() {
		super();
	}

	public LoginUser(String username) {
		super();
		this.username = username;
	}

	public LoginUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public LoginUser(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
	public String toString() {
		return "LoginUser [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone
				+ ", address=" + address + ", realName=" + realName + "]";
	}
}
