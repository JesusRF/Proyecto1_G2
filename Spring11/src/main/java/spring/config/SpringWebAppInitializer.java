package spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//Implementa la interfaz WebApplicationInitializer, para abrir la Aplicación
public class SpringWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        
        appContext.register(ApplicationContextConfig.class);
        //Creamos un servlet base para toda la aplicación, y le asociamos un contexto.
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                "SpringDispatcher", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1); //No haría falta que se anteponga, pero quiere decir que arranque al inicio (>0)
        dispatcher.addMapping("/"); //Mapee también las barras.
        
	}

}