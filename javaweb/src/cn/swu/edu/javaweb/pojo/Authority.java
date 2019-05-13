package cn.swu.edu.javaweb.pojo;

public class Authority {
	//显示到页面上的权限的名字
	private String displayName;
	
	//权限对应的URL地址：权限对应着一个URL，例如Article-1 -> /article-1.jsp
	private String url;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Authority(String displayName, String url) {
		super();
		this.displayName = displayName;
		this.url = url;
	}
	
	public Authority() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Authority other = (Authority) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

}
