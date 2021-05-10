package kodlama.io.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}


// JpaRepository => verdigin veritipi icin yani entity anatasyonlari ile suslenmis nesne icin(product => entity koymazsan problem yasarsin)
// primary key alanin da ne oldugunu bana ver ki sorgulari da ona gore hazirlayim diyor. bu sekilde urunle ilgili crud operasyonlarini
// hazirliyor.

// entityFramework base repository=> JpaRepository => hangi tabloya hangi id veritipi ile sorgularin hazirlanmasi gerektigini soyluyoruz.