package spring.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.UserDAO;
import spring.model.*;

@Service //Servicios
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired //Inyecta userDAO
	private UserDAO userDAO;
	
	/*
	public UserServiceImpl(){
		
	}
	
	public UserServiceImpl(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}
	*/


	@Override
	public List<User> list() {

		return userDAO.list();
	}

	@Override
	public User get(int id) {
		return userDAO.get(id);
	}

	@Override
	public void saveOrUpdate(User user) {
		userDAO.saveOrUpdate(user);

	}

	@Override
	public void delete(int id) {
		userDAO.delete(id);
	}

}
