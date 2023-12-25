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
@WebServlet("/Update")
public class UpdateCar extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int carId=Integer.parseInt(req.getParameter("carId"));
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Car.class);
		   SessionFactory sf=cfg.buildSessionFactory();
		   Session session=sf.openSession();
		   Transaction trans =session.beginTransaction();
		   
		   Car car=session.get(Car.class, carId);
		   
		   trans.commit();
		   session.close();
		   req.setAttribute("car", car);
		   RequestDispatcher dispatcher=req.getRequestDispatcher("Update.jsp");
		   dispatcher.forward(req, resp);
		   
	}

}
