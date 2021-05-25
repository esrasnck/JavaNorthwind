package kodlama.io.northwind.api.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.core.utilities.results.DataResult;
import kodlama.io.northwind.core.utilities.results.Result;
import kodlama.io.northwind.entities.concretes.Product;

@RestController // sen bir controller'sin demek. java olmayanlar da beni tanısın anlamında

@RequestMapping("api/products")  // api için mapping
public class ProductsController {
	
	// service ulasabilmek icin interface injecte ediyoruz.
	
    private ProductService productService;
	
	@Autowired   // Ioc yapilandirmasini yapiyor.
	
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}


	@GetMapping("/getall")    // get mi post mu oldugunu belirten kisim kodlama.io/api/products/getall deyince bu caliscak
	public DataResult<List<Product>> getAll(){
		
		
		return this.productService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product); 
	}

}


// kodlama.io => domain => kodlama.io/api/products => boyle bir istek gelirse, bu controller karsilayacak.