package com.qwi.josemi.ticketsRestaurant.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

public class TicketsRestaurantContextListener implements WebApplicationInitializer {
	private static Logger logger=LoggerFactory.getLogger(TicketsRestaurantContextListener.class);

	@Override 
	public void onStartup(ServletContext context) throws ServletException {
		// TODO Auto-generated method stub
		Dynamic registration=context.addServlet("DispatcherServlet", DispatcherServlet.class);
		/*if (registration != null){
			registration.addMapping("/");
			registration.setInitParameter("contextConfigLocation", "classpath:spring/*.xml");
			registration.setLoadOnStartup(1);
		}*/
		
		logger.info("Initialized the web application context");
	}

}
