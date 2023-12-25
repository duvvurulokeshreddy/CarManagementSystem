package com.jsp.CarManagementSystem;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.*;

import org.hibernate.query.*;

@WebServlet("/displayCars")
public class DisplayCarServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Car.class);
		   SessionFactory sf=cfg.buildSessionFactory();
		   Session session=sf.openSession();
		   Transaction trans =session.beginTransaction();


		   Query<Car> query=session.createQuery("from Car");
		   List<Car> cars=query.list();
//		   if(cars==null) {
//			   System.out.println(cars);
//		   }
		   
		   req.setAttribute("carList", cars);
		   RequestDispatcher requestDispatcher=req.getRequestDispatcher("DisplayCar.jsp");
		   requestDispatcher.forward(req, resp);
		   
		   
		   
	}

}
