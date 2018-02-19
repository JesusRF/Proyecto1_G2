package spring.dao;

import java.util.List;

import com.ejemplos.spring.model.User;

//Interfaz, con 
public interface UserDAO {
	public List<User> list();
	
	public User get(int id);
	
	//Método para Guardar o Modificar un objeto de tipo User, definido en la Clase User.
	
	public void saveOrUpdate(User user);
	
	public void delete(int id);
}