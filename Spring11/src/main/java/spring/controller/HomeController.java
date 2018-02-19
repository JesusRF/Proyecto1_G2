package spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ejemplos.spring.model.User;
import com.ejemplos.spring.services.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller //Anotación de controlador
public class HomeController {
	
	//Inyectamos la Clase UserService.
	@Autowired
	private UserService userService;

	//Recoge los archivos que vengan con /
	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
		List<User> listUsers = userService.list(); 
		ModelAndView model = new ModelAndView("UserList"); //UserList, es el jsp al que llamar.
		model.addObject("userList", listUsers); //Con nombre userList, añadirmos al modelo una lista.
		return model;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET) // 2 condiciones, get y carpeta con new delante.
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("user", new User());
		return model;		
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET) //Se edita por id.
	public ModelAndView editUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = userService.get(userId);
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("user", user);
		return model;		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET) //Se elimina por id.
	public ModelAndView deleteUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		userService.delete(userId);
		return new ModelAndView("redirect:/");	//Volvemos al eliminar a la lista	
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST) //Post para guardar del formulario
	public ModelAndView saveUser(@ModelAttribute User user) {
		userService.saveOrUpdate(user);
		return new ModelAndView("redirect:/");
	}
	
}
