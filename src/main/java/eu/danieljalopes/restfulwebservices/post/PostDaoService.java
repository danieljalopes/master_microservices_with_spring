package eu.danieljalopes.restfulwebservices.post;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class PostDaoService {
	
	private static List<Post> posts = new ArrayList<>();
	private static int postCounter = 3;
	
	static {
		posts.add(new Post(1, 1, "Post 1 of user 1"));
		posts.add( new Post(2, 1, "Post 2 of user 1"));
		posts.add( new Post(3, 2, "Post 1 of user 2"));
	}
	
	
	public List<Post> findAll(){
		return posts;
	}
	
	public Post save(Post post) {
		if(Objects.isNull(post.getId())) {
			post.setId(++postCounter);
		}
		
		posts.add(post);
		
		return post;
	}
	
	public Post findOne(int id) {
		for(Post post : posts) {
			if(post.getId() == id) {
				return post;
			}
		}
		
		return null;
	}
	
	
	public List<Post> findPostsOfUser(int userId){
		List<Post> userPost = new ArrayList<Post>();
		for(Post post : posts) {
			if(post.getUserId() == userId) {
				userPost.add(post);
			}
		}
		
		return userPost;
	}
	
	
	

}
