package kodlama.io.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	// isimlendirme maalesef önemli :( 
	
      Product getByProductName(String productName);
      //=> get'i gördüğü anda, tabloya bakıyor. productName'i bulduğu anda yapıştırıyor. getBy, findBy çokomelli :)
	  
	  Product getByProductNameAndCategory_CategoryId(String productName, int categoryId); // maplemesi için böyle yapmak gerekiyor :/
	  
	  // iki kurala da uyacak
	  
	  List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	  
	  // ikisinden birinin doğru olması yeterli.
	  
	  List<Product> getByCategoryIn(List<Integer> categories);
	  
	  // category id 'si in(1,2,3,4) vs. olan.(birden çok kategori gönderiyoruz. integer türünde kategorileri gönder diyoruz.
	  
	  List<Product> getByProductNameContains(String productName);
	  
	  // ürünün isminde, gönderilen parametreyi içeriyorsa yapacak.
	  
	  List<Product> getByProductNameStartsWith(String productName);
	  
	  // ürün isimleri şununla başlayan, ürün isimleri şununla biten (şu= parametre)
	  
	  @Query("From Product where productName=:productName and ​categoryId=:categoryId") // TODO bu query bende çalışıyor?
	  // altın kural=> sorguyu yazarken, veritabanı tablosunu unutun.
	  List<Product> getByNameAndCategory(String productName, int categoryId);
	  
	  // JPQL => link gibi. ama string formatta yapılan, formata dikkat edilmesi gereken bir yapı. sorguyu objeler üzerinden yapıyoruz. 
	  // istersek de, normal sql queryi si atabiliyoruz.
	
}


//  iterasyon yapısı: dönülebilir. 

// JpaRepository => verdigin veritipi icin yani entity anatasyonlari ile suslenmis nesne icin(product => entity koymazsan problem yasarsin)
// primary key alanin da ne oldugunu bana ver ki sorgulari da ona gore hazirlayim diyor. bu sekilde urunle ilgili crud operasyonlarini
// hazirliyor.

// entityFramework base repository=> JpaRepository => hangi tabloya hangi id veritipi ile sorgularin hazirlanmasi gerektigini soyluyoruz.