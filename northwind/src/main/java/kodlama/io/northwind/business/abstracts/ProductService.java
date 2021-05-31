package kodlama.io.northwind.business.abstracts;

import java.util.List;

import kodlama.io.northwind.core.utilities.results.DataResult;
import kodlama.io.northwind.core.utilities.results.Result;
import kodlama.io.northwind.entities.concretes.Category;
import kodlama.io.northwind.entities.concretes.Product;
import kodlama.io.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {

	DataResult<List<Product>> getAll();
	
	  DataResult<List<Product>> getAllSorted(); // datayı istediğim şarta göre sırala.
	
	DataResult<List<Product>> getAll(int pageNo, int pageSize);
	
	Result add(Product product);
	
    DataResult <Product> getByProductName(String productName);
	
    DataResult<Product> getByProductNameAndCategoryId(String productName,int categoryId);
	
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName,int categoryId);
	
	DataResult<List<Product>> getByCategoryIdIn(List<Category> categories);
	
	DataResult<List<Product>> getByProductNameContains(String productName);
	
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	
	DataResult<List<Product>> getByNameAndCategory(String productName,int categoryId);
	
	
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
