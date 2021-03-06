package eu.danieljalopes.restfulwebservices.user;

import  static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import eu.danieljalopes.restfulwebservices.post.Post;
import eu.danieljalopes.restfulwebservices.post.PostDaoService;
import eu.danieljalopes.restfulwebservices.post.PostNotFoundException;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userService;

	@Autowired
	private PostDaoService postService;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userService.findAll();
	}

	@GetMapping("/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		User user = userService.findOne(id);

		if (Objects.isNull(user))
			throw new UserNotFoundException("id - " + id);

		//"all-users", SERVER_PATH + "/users"
		Resource<User> resource = new Resource<User>(user);
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userService.save(user);

		// Fills the location on the header of the response with the uri of the user
		// created
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		// return with status 201 --> created
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/users/{id}/posts")
	public List<Post> retrieveAllPostsOfUser(@PathVariable int id) {
		User user = userService.findOne(id);

		if (Objects.isNull(user))
			throw new UserNotFoundException("id - " + id);

		List<Post> posts = postService.findPostsOfUser(id);

		return posts;
	}

	@GetMapping("/users/{id}/posts/{post_id}")
	public Post postDetailOfUser(@PathVariable int id, @PathVariable int post_id) {
		User user = userService.findOne(id);

		if (Objects.isNull(user))
			throw new UserNotFoundException("id - " + id);

		List<Post> posts = postService.findPostsOfUser(id);
		Post userPost = null;

		for (Post post : posts) {
			if (post.getId() == post_id)
				userPost = post;
			break;
		}

		if (Objects.isNull(userPost)) {
			throw new PostNotFoundException("user id - " + id + ", post_id - " + post_id);
		}

		return userPost;
	}

	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> createPostForUser(@PathVariable int id, @RequestBody Post post) {
		User user = userService.findOne(id);

		if (Objects.isNull(user))
			throw new UserNotFoundException("id - " + id);

		post.setUserId(id);

		post = postService.save(post);

		// Fills the location on the header of the response with the uri of the user and its post created
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand( post.getId()).toUri();
		
		// return with status 201 --> created
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userService.deleteById(id);
		
		if(Objects.isNull(user)) {
			throw new UserNotFoundException("id: " + id);
		}
		
		
	}
}
