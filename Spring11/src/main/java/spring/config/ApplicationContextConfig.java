package spring.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import spring.model.User;

@Configuration // Anotación para la configuración
@ComponentScan("spring.controller") //Busca en carpetas y subcarpetas
@EnableTransactionManagement // Habilitamos la transacción
public class ApplicationContextConfig {
    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() { //Método para la vista
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/"); //Para definir donde buscar los jsp.
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    //aaaaa
    // Método para añadir los recursos css de static
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		///registry.addResourceHandler("/css/**").addResourceLocations("/static/css/");	    
	}
     
    //Creamos objeto con Bean. Para bases de datos. Hacemos la conexión para mysql.
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    	dataSource.setUrl("jdbc:mysql://localhost:3306/spring11");
    	dataSource.setUsername("root");
    	dataSource.setPassword("1111");
    	
    	return dataSource;
    }
    
    //Por defecto, para hibernate se pone esto.
    private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    	return properties;
    }
    
    //Se crea un objeto con Bean, con esas características, y todo objeto igual será inyectado.
    //A la base de datos se le asocia una base datos.
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties()); //Añadimos propiedades Hibernate a nuestra sesión.
    	sessionBuilder.addAnnotatedClasses(User.class); //Actúa con la clase User.class
    	return sessionBuilder.buildSessionFactory(); //Construye la sesión.
    }
    
    //Transacción de datos con la base de datos, por eso llama a sessionFactory.
	@Autowired 
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}
    

}
