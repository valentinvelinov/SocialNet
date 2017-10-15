package Social.post;

public class Post {
	private int post_id;
	private String content;
	private int user_id;

	public Post(String content, int user_id) {
		super();
		this.content = content;
		this.user_id = user_id;
	}

	public int getPost_id() {
		return post_id;
	}

	public String getContent() {
		return content;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setPost_id(int post_id) {
		if (post_id > 0) {
			this.post_id = post_id;
		}
	}

	public void setContent(String content) {
		if (content != null && !content.isEmpty()) {
			this.content = content;
		}
	}

	public void setUser_id(int user_id) {
		if (user_id > 0) {
			this.user_id = user_id;
		}
	}

}
