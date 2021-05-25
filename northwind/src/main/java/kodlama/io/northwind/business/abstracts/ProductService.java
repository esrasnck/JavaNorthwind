package kodlama.io.northwind.business.abstracts;

import java.util.List;

import kodlama.io.northwind.core.utilities.results.DataResult;
import kodlama.io.northwind.core.utilities.results.Result;
import kodlama.io.northwind.entities.concretes.Product;

public interface ProductService {

	DataResult<List<Product>> getAll();
	
	Result add(Product product);
	
}
