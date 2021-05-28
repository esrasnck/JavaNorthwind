package kodlama.io.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Category {
  
	@Id
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@OneToMany(mappedBy = "category")   // bir category'nin birden çok products'ı olur.
	private List<Product> products;
	
}


// @JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"}) => datayı getirirken, loop'a giriyor. recursive bir yapı varsa, onu en 
// temelde kes. ona göre datayı getir. => lazy loading. iki gözümün çiçeği => benim söylediğim kadar mappingi yap. daha ötesine girme.