package com.allianz.shopping.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.allianz.shopping.dao.CustomerDAO;
import com.allianz.shopping.dao.CustomerDAOImpl;
import com.allianz.shopping.model.Customer;
/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
 private static final long serialVersionUID = 1L;
 
 CustomerDAOImpl cimpl = new CustomerDAOImpl();
 /**
  * @see HttpServlet#HttpServlet()
  */
 public CustomerController() {
  super();
  // TODO Auto-generated constructor stub
 }
 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
  *      response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
  // TODO Auto-generated method stub
  
  Customer customer = new Customer();
    String user = request.getParameter("username");
    String pass = request.getParameter("password");
    if (user.isEmpty() || pass.isEmpty()) {
     RequestDispatcher req = request.getRequestDispatcher("login.jsp");
     req.include(request, response);
    } else {
     boolean flag =cimpl.CustomerLogin(user, pass);
     if (flag == true) {
      HttpSession session=request.getSession();
      session.setAttribute("username",user);
      
      RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
      rd.forward(request, response);
     } else {
      RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
      rd.forward(request, response);
     }
    }
  response.getWriter().append("Served at: ").append(request.getContextPath());
  
  
 }
 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
  *      response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
  // TODO Auto-generated method stub
  // doGet(request, response);
  int id = Integer.parseInt(request.getParameter("id"));
  String username = request.getParameter("username");
  String password = request.getParameter("password");
  String address = request.getParameter("address");
  String emailid = request.getParameter("email");
  Customer customer = new Customer();
  
  customer.setId(id);
  customer.setUsername(username);
  customer.setPassword(password);
  customer.setAddress(address);
  customer.setEmail(emailid);
  boolean flag = cimpl.addCustomer(customer);
  if (flag) {
   System.out.println("sucess");
   response.sendRedirect("login.jsp");
  }
  // response.sendRedirect("LoginCustomer.jsp");
 }
}