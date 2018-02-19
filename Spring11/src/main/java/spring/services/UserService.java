package spring.services;

import java.util.List;
import spring.model.*;

public interface UserService {
	public List<User> list();
	
	public User get(int id);
	
	public void saveOrUpdate(User user);
	
	public void delete(int id);
}