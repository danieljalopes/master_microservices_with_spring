package eu.danieljalopes.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	private static int usersCount = 3;
	
	
	
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));
	}
	
	
	public List<User> findAll(){
		return users;
	}
	
	
	public User save(User user) {
		if( Objects.isNull(user.getId())) {
			user.setId(++usersCount);
			
		}
		
		users.add(user);
		return user;
	}
	
	
	public User findOne(int id) {
		for(User u: users) {
			if(u.getId() == id) {
				return u;
			}
		}
		return null;
	}

}
