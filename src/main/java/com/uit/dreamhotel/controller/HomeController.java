package com.uit.dreamhotel.controller;


import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.uit.dreamhotel.util.HibernateUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) {
		SessionFactory sessionfactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		String hql = "FROM room";
		Query query = session.createQuery(hql);
		java.util.List results = query.list();		
		ModelAndView mv = new ModelAndView("home");  
        mv.addObject("displayRoom", results);
        session.getTransaction().commit();
		return mv;
	}
	
}
