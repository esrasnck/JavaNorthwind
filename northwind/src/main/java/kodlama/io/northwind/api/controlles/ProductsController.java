package kodlama.io.northwind.api.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.entities.concretes.Product;

@RestController // sen bir controller'sin demek.

@RequestMapping("api/products")
public class ProductsController {
	
	// service ulasabilmek icin interface injecte ediyoruz.
	
    private ProductService productService;
	
	@Autowired   // Ioc yapilandirmasini yapiyor.
	
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}


	@GetMapping("/getall")    // get mi post mu oldugunu belirten kisim kodlama.io/api/products/getall deyince bu caliscak
	public List<Product> getAll(){
		
		return this.productService.getAll();
	}

}


// kodlama.io => domain => kodlama.io/api/products => boyle bir istek gelirse, bu controller karsilayacak.