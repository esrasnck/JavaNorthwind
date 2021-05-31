package kodlama.io.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity  

// sen bir veritabani nesnesissin
// entity oldugunu anliyoruz. bunu spring framework sana soruyor. bunu anatasyon dedigimiz yontem ile yapiyor
// bu entity'dir anlaminde. pesistence.entity'i seciyoruz. bizim icin jpa alt yapisini kullanacak.

@Table(name="products") // veritabaninda hangi tabloya karsilik gelecek.

@Data   // => lombok'dan geliyor.
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	// sira bu ucu icin onemli degil. ama anatasyonlar onem arz edebilir.(baska noktalar icin)
	
	@Id // tablodaki id alaninin ne oldugunu soylememiz gerekiyor.Bu islemlerini id'ye gore yapacak. biz aslinda jpa'ya ve bunun da implementasyonu olan
	// hibernate'e bu tablonun id'sinin ne oldugunu bu sekilde veriyoruz. Sorgular bu id ye gore yapilandirilir.
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)// birer birer attirdigimizi nasil uretildigini soylemek gerekiyor. generatedValue bir bir arttirmak demek.
	
	@Column(name="product_id") // bu alan veritabaninda hangi column a karsilik geliyor anlaminda.
	private Integer id;
	
	//@Column(name="category_id")
	//private int categoryId;    => ManyToOne yazdığımız için commentliyoruz.
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="units_in_stock")
	private short unitsInStock;
	
	@Column(name="quantity_per_unit")
	private String quantityPerUnit;
	
    @ManyToOne()    // bir product'ın bir kategorisi var.
    @JoinColumn(name="category_id")
    private Category category;

}








