package kodlama.io.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
 // constructor injection : bir bağımlılığı constructor üzerinden enjekte etmek.
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

	
}

//spring nasil calisir ? => normal sartlarda bunlarin injection'inini kullanabilmek icin,generic olarak calisiyor. arka planda jpaRepository de
// spring bir repository clasi olusturuyor. (bir instance olusturup buraya veriyor. ama ona ait bir bilgi yok. bunun icin @Autowired notation'i)
// kullaniliyor.

// beans => javada proje classi
// factory => arka planda tasarim deseni dedigimiz bir yapiyi calistirir. bir instance verir acikcasi. Autowired'da spring arka planda
// buna karsilik gelecek projenin bir instance i olacak ( productDao 'nun) bir instance'i olabilecek sinifi uretip/ ona veriyor. 
// o zaten spring tarafinda tanimli.

// autowired genellikle bir bagimlilik olur. tek instance uzerinden gider. bunu configure de edebiliriz. ama java dunyasinde bu yaygindir.

// autofac business module da bunun autowired yapiyor. gidiyor. projeyi taniyor. ona karsilik gelen ne varsa, buraya veriyor.






