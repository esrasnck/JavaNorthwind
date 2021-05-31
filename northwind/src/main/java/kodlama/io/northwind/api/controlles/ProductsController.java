package kodlama.io.northwind.api.controlles;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.core.utilities.results.DataResult;
import kodlama.io.northwind.core.utilities.results.Result;
import kodlama.io.northwind.entities.concretes.Category;
import kodlama.io.northwind.entities.concretes.Product;
import kodlama.io.northwind.entities.dtos.ProductWithCategoryDto;

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
	
	
	@GetMapping("/getByProductName")    // get mi post mu oldugunu belirten kisim kodlama.io/api/products/getall deyince bu caliscak
	public DataResult<Product> getByProductName(@RequestParam String productName){
		
		
		return this.productService.getByProductName(productName);
	}

	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> 
	getByProductNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
		System.out.println(productName); //=> nice debugging <3
		System.out.println(categoryId);
		
		return this.productService.getByProductNameAndCategoryId
				(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	
	@GetMapping("/getAllByPage")
	DataResult<List<Product>> getAll(int pageNo, int pageSize){
		return this.productService.getAll(pageNo, pageSize);
	}

	
	@GetMapping("/getAllDesc")
    public DataResult<List<Product>> getAllSorted() {
  	return this.productService.getAllSorted();
	}
	
	//TODO Umut düzeltti yeniden... gerekirse refactor edilir.
	
	@PostMapping("/getByCategoryIdIn")
	public  DataResult<List<Product>> getByCategoryIdIn(@RequestBody List<Category> categories){

		
		return this.productService.getByCategoryIdIn(categories);
	}
	
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>>getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
	
	
	

}


// @RequestBody => hem istek yapıyor. hem datan budur diyor. bu classdaki alanları arayıp buluyor.
// bir product nesnesine dönüştürüp/ json formatında gönderiyor

// @RequestParam => yapılan isteğin parametrelerine bak. onu oku demek.

 
// kodlama.io => domain => kodlama.io/api/products => boyle bir istek gelirse, bu controller karsilayacak.