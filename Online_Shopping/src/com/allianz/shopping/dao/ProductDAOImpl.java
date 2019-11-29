package com.allianz.shopping.dao;

import java.util.ArrayList;
import java.util.List;
import static com.allianz.shopping.utility.DateUtility.*;

import com.allianz.shopping.model.Product;

public class ProductDAOImpl implements ProductDAO{

	private static List<Product> productList=new ArrayList<Product>();
	static
	{
		 productList.add(new Product(101,"colgate","colgate tube",50,convertStringToDate("11/11/2019")));
		 productList.add(new Product(102,"colgate1","colgate1 tube",40,convertStringToDate("12/10/2019")));
		 productList.add(new Product(103,"colgate2","colgate2 tube",30,convertStringToDate("08/09/2019")));
		 productList.add(new Product(104,"colgate3","colgate3 tube",60,convertStringToDate("11/06/2019")));
	}
	
	
	@Override
	public boolean addProduct(Product product) {
		productList.add(product);
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {

		if(productList!=null && productList.size()>0)
		{
			for(int i=0;i<productList.size();i++)
			{
				Product producttemp=productList.get(i);
				if(producttemp.getId()==product.getId())
				{
					productList.set(i, product);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		if(productList!=null && productList.size()>0)
		{
			for(int i=0;i<productList.size();i++)
			{
				Product producttemp=productList.get(i);
				if(producttemp.getId()==id)
				{
					productList.remove(i);
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productList;
	}

	@Override
	public List<Product> getAllProductsByName(String namePattern) {
		 List<Product> productListTemp=new ArrayList<Product>();
		 if(productList!=null && productList.size()>0)
			{
				for(int i=0;i<productList.size();i++)
				{
					Product producttemp=productList.get(i);
					if(producttemp.getDescription().toLowerCase().contains(namePattern.toLowerCase()))
					{
						productListTemp.add(producttemp);
				
					}
				}
				return productListTemp;
			}

		
		return null;
	}

	@Override
	public List<Product> getAllProductsByPrice(float min, float max) {
			 List<Product> productListTemp=new ArrayList<Product>();
			 if(productList!=null && productList.size()>0)
				{
					for(int i=0;i<productList.size();i++)
					{
						Product producttemp=productList.get(i);
						if(producttemp.getPrice()>=min && producttemp.getPrice()<=max)
						{
							productListTemp.add(producttemp);
					
						}
					}
					return productListTemp;
				}

		return null;
	}

	@Override
	public Product getProductById(int id) {
		
		if(productList!=null && productList.size()>0)
		{
			for(int i=0;i<productList.size();i++)
			{
				Product producttemp=productList.get(i);
				if(producttemp.getId()==id)
				{
					return producttemp;
				}
			}
		}
		return null;
	}

}
