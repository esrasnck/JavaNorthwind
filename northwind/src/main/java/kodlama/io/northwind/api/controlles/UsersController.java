package kodlama.io.northwind.api.controlles;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.northwind.business.abstracts.UserService;
import kodlama.io.northwind.core.entities.User;
import kodlama.io.northwind.core.utilities.results.ErrorDataResult;


@RestController
@RequestMapping(value="/api/users")
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@PostMapping(value="/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user) {
		
		
		return ResponseEntity.ok(this.userService.add(user));
	}
	
	
	// global hata yönetimi
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handeValidationException(MethodArgumentNotValidException exceptions){
		
		Map<String,String> validationErrors = new HashMap<String,String>();
		for(FieldError fieldError :exceptions.getBindingResult().getFieldErrors()) { // userda oluşan tüm hatalar için o alanları oku
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		
		return errors;
	}
	
	// object tip olduğundan O'su büyük 
	// bu sistemde bir hata olursa, bunu devreye sok diyorum. => exceptionHandler => spring validationdan gelen tüm
	// validasyon hatalarını verir.
	// tipi vermek için type.of yerine .class diyerek veriyoruz.
	// hangi alanda hata oldu ve hata ne? email alanında hata oldu nboş geçmişsiniz gibi...bu yüzden map yapısını => c#daki dictionary
	// yapısı kullanılacak.
	
	//(spring validation dökümantasyonunda var)
	// hashmap => map implemantasyonu. kendisi bir map => dictionary yapısının kendisi. oluşan bir metot olursa, metot parametresi olarak geçiyor.
}


// ResponseEntity<?> => işareti unknown anlamında. ne verirsen onu döndürür.
