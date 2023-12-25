package com.jsp.CarManagementSystem;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.query.*;
import java.util.*;
@WebServlet("/deleteCar")
public class DeleteCarServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     int carId=Integer.parseInt(req.getParameter("carId"));
     Configuration cfg=new Configuration();
     cfg.configure();
     cfg.addAnnotatedClass(Car.class);
     SessionFactory sf=cfg.buildSessionFactory();
     Session session=sf.openSession();
     Transaction trans=session.beginTransaction();
     
     Car car=session.get(Car.class, carId);
     session.delete(car);
     
     Query<Car> query=session.createQuery("FROM Car");
     List<Car> cars=query.list();
     req.setAttribute("carList", cars);
     RequestDispatcher dispatcher=req.getRequestDispatcher("DisplayCar.jsp");
     dispatcher.forward(req, resp);
	}

}
