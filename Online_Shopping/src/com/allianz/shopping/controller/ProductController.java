package com.allianz.shopping.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allianz.shopping.dao.CategoryDAO;
import com.allianz.shopping.dao.CategoryDAOImpl;
import com.allianz.shopping.dao.ProductDAO;
import com.allianz.shopping.dao.ProductDAODatabaseImpl;
import com.allianz.shopping.dao.ProductDAOImpl;
import com.allianz.shopping.model.Category;
import com.allianz.shopping.model.Product;
import com.allianz.shopping.utility.DateUtility;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProductDAO dao=new ProductDAOImpl();
	ProductDAO productdb=new ProductDAODatabaseImpl();
	static CategoryDAO categorydao=new CategoryDAOImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		
		
		String action=request.getParameter("action");
		if(action!=null && action.equals("delete"))
		{
			String id=request.getParameter("id");
			boolean flag=productdb.deleteProduct(Integer.parseInt(id));
			if(flag)
			{
				response.sendRedirect("ProductController");
			}
		}
		else if(action!=null && action.equals("edit"))
		{
			
			String id=request.getParameter("id");
			Product product=productdb.getProductById(Integer.parseInt(id));
			if(product!=null)
			{
				RequestDispatcher dispatcher=request.getRequestDispatcher("product.jsp");
				request.setAttribute("product", product);
				dispatcher.forward(request, response);
			}
		}
		else if(action!=null && action.equals("productDetails"))
		{
			
			String id=request.getParameter("id");
			Product product=productdb.getProductById(Integer.parseInt(id));
			if(product!=null)
			{
				RequestDispatcher dispatcher=request.getRequestDispatcher("productDetails.jsp");
				request.setAttribute("product", product);
				dispatcher.forward(request, response);
			}
		}
		else if(action!=null && action.equals("deleteFromCart"))
		{
			
			String index=request.getParameter("index");
			List<Product> productList=new ArrayList<Product>();
			if(request.getSession().getAttribute("productList")!=null)
			{
				productList=(List<Product>)request.getSession().getAttribute("productList");
				productList.remove(Integer.parseInt(index));
				request.getSession().removeAttribute("productList");
				request.getSession().setAttribute("productList", productList);
			}
			RequestDispatcher dispatcher=request.getRequestDispatcher("addToCart.jsp");
			dispatcher.forward(request, response);

		}
		else if(action!=null && action.equals("addToCart"))
		{
			
			int id=(Integer.parseInt(request.getParameter("id")));
			Product product=productdb.getProductById(id);
			if(product!=null)
			{
				List<Product> productList=new ArrayList<Product>();
				if(request.getSession().getAttribute("productList")!=null)
				{
					productList=(List<Product>)request.getSession().getAttribute("productList");
//					boolean flag=false;
//					for (int i = 0; i < productList.size(); i++) {
//						Product pros=productList.get(i);
//						//System.out.println(productList.get(i));
//						if(pros.getId()==id)
//						{
//							flag=true;
//						}
//					}
//					if(flag==false) {
//						productList.add(product);
//
//					}
					productList.add(product);

					request.getSession().setAttribute("productList",	 productList);
				}
				else {
					productList.add(product);
					request.getSession().setAttribute("productList",	 productList);
				}
				RequestDispatcher dispatcher=request.getRequestDispatcher("addToCart.jsp");
				request.setAttribute("productList", productList);
				dispatcher.forward(request, response);
			}
		}
		else if(action!=null && action.equals("Add"))
		{
			
			String id=request.getParameter("id");
			Product product=productdb.getProductById(Integer.parseInt(id));
			if(product!=null)
			{
				RequestDispatcher dispatcher=request.getRequestDispatcher("product.jsp");
				request.setAttribute("product", product);
				dispatcher.forward(request, response);
			}
		}
		
		else
		{
		List<Product> productList=productdb.getAllProducts();
		List<Category> categoryList=categorydao.getAllCategory();
		RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
		request.setAttribute("productlist", productList);
		request.setAttribute("categorylist", categoryList);
		dispatcher.forward(request, response);
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		String action=request.getParameter("action");
		if(action!=null && action.equals("update"))
		{
			String id=request.getParameter("id");
			String code=request.getParameter("code");
			String description=request.getParameter("description");
			String price=request.getParameter("price");
			String mfDate=request.getParameter("mfDate");
			Product product=new Product();
			product.setId(Integer.parseInt(id));
			product.setCode(code);
			product.setDescription(description);
			product.setPrice(Float.parseFloat(price));
			product.setMfDate(DateUtility.convertStringToDate(mfDate));
			boolean flag=false;
			if(productdb.getProductById(Integer.parseInt(id))!=null)
			{	
			 flag=productdb.updateProduct(product);
			}
			else
			{
				flag=productdb.addProduct(product);
			}
			if(flag)
			{
				response.sendRedirect("ProductController");
			}
		}
	}

}
