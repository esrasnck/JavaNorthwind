package kodlama.io.northwind.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.core.utilities.results.DataResult;
import kodlama.io.northwind.core.utilities.results.Result;
import kodlama.io.northwind.core.utilities.results.SuccessDataResult;
import kodlama.io.northwind.core.utilities.results.SuccessResult;
import kodlama.io.northwind.dataAccess.abstracts.ProductDao;
import kodlama.io.northwind.entities.concretes.Product;



@Service // bu class service gorevi gorecek diye springe bilgi veriyoruz.

public class ProductManager implements ProductService {
	
	private ProductDao productDao;

	@Autowired // bunu yazmayip, private kisminin ustune yazsak yine yer. ama birden fazla injekte etmek gerekir diye boyle yapiyoruz.
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {

		return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Product Listed !"); // parametre vermedigimizde datalari getirir.
	}

	@Override
	public Result add(Product product) {
	
		this.productDao.save(product);
		
		return new SuccessResult("Product Added !");
	}
	
	@Override
	public DataResult<Product> getByProductName(String productName) {
		
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"Data Listelendi");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		
		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIn(categories),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName,categoryId),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		// findAll'un overloadlarından gidiyoruz.
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize); // listelemeyi 0 dan başlatır.
		
		// data.domain'den geliyor.
		
		return new SuccessDataResult<List<Product>> (this.productDao.findAll(pageable).getContent());
		
		// page türünde birşey döndürdüğü için onu okuyamıyor. biz de bunu getContent'den alıyoruz.
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
       
		// data.domain'den geliyor.
		
		Sort sort = Sort.by(Sort.Direction.DESC,"productName");

		
	 return new SuccessDataResult<List<Product>> (this.productDao.findAll(sort),"Başarılı ");
	}
	
     
	
	/// validatio  kuralları
	
}




