package kodlama.io.northwind.business.abstracts;

import java.util.List;

import kodlama.io.northwind.entities.concretes.Product;

public interface ProductService {

	List<Product> getAll();
	
}
