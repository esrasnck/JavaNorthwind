package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.core.entities.User;
import kodlama.io.northwind.core.utilities.results.DataResult;
import kodlama.io.northwind.core.utilities.results.Result;

public interface UserService {

	Result add(User user);
	
	DataResult<User> findByEmail(String email);
}
