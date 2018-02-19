package spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ejemplos.spring.model.User;

@Repository //Repositorio
public class UserDAOImpl implements UserDAO {
	
	//Inyectamos la sesión.
	@Autowired
	private SessionFactory sessionFactory;
	//Constructor
	public UserDAOImpl() {	
	}
	
	//Constructor, con parámetro de entrada de la sesión. 
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override //Sobreescrimos.
	@Transactional //Para las transacciones
	public List<User> list() {
		@SuppressWarnings("unchecked") //Suprimimos avisos que sean de tipo unchecked.
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession() // ListUser creado similar al ListUsers de la clase HomeController.
				.createCriteria(User.class) //
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list(); //Query con joins de one a varios.
		return listUser;
	}

	@Override
	@Transactional
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	@Transactional
	public void delete(int id) {
		User userToDelete = new User(); //Crea un objeto para que sea eliminarado.
		userToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(userToDelete);
	}

	@Override
	@Transactional
	public User get(int id) {
		String hql = "from User where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		
		return null;
	}
}