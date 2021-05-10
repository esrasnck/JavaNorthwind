package kodlama.io.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity  

// sen bir veritabani nesnesissin
// entity oldugunu anliyoruz. bunu spring framework sana soruyor. bunu anatasyon dedigimiz yontem ile yapiyor
// bu entity'dir anlaminde. pesistence.entity'i seciyoruz. bizim icin jpa alt yapisini kullanacak.

@Table(name="products") // veritabaninda hangi tabloya karsilik gelecek.

@Data   // => lombok'dan geliyor.

public class Product {
	
	// sira bu ucu icin onemli degil. ama anatasyonlar onem arz edebilir.(baska noktalar icin)
	
	@Id // tablodaki id alaninin ne oldugunu soylememiz gerekiyor.Bu islemlerini id'ye gore yapacak. biz aslinda jpa'ya ve bunun da implementasyonu olan
	// hibernate'e bu tablonun id'sinin ne oldugunu bu sekilde veriyoruz. Sorgular bu id ye gore yapilandirilir.
	
	@GeneratedValue// birer birer attirdigimizi nasil uretildigini soylemek gerekiyor. generatedValue bir bir arttirmak demek.
	
	@Column(name="product_id") // bu alan veritabaninda hangi column a karsilik geliyor anlaminda.
	private int id;
	
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="units_in_stock")
	private short unitsInStock;
	
	@Column(name="quantity_per_unit")
	private String quantityPerUnit;
	
	public Product() {};
	
	public Product(int id, int categoryId, String productName, double unitPrice, short unitsInStock,
			String quantityPerUnit) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.quantityPerUnit = quantityPerUnit;
	}

}


// anatasyon : bir class'in calisma ya da derleme aninda, onunla ilgili bilgi toplama icin kullanilan yapi
//ona karsilik gelen yapi => c# karsiligi attribute. angular daki karsiligi dekarator (gozlerim kaniyor)





