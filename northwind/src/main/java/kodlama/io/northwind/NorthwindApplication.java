package kodlama.io.northwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NorthwindApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindApplication.class, args);
	}

}

// projenin baslangic dosyasi. Ama veritabani configurasiyonu var. onun icin de  src/main/resources => application.properties
