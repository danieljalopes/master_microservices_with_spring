package eu.danieljalopes.restfulwebservices.post;

public class Post {
	
	private Integer id;
	private Integer userId;
	private String message;
	
	
	public Post(Integer id, Integer userId, String message) {
		super();
		this.id = id;
		this.userId = userId;
		this.message = message;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "Post [id=" + id + ", userId=" + userId + ", message=" + message + "]";
	}

	
	
	
}
