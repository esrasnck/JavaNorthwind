package kodlama.io.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.northwind.business.abstracts.UserService;
import kodlama.io.northwind.core.dataAccess.UserDao;
import kodlama.io.northwind.core.entities.User;
import kodlama.io.northwind.core.utilities.results.DataResult;
import kodlama.io.northwind.core.utilities.results.Result;
import kodlama.io.northwind.core.utilities.results.SuccessDataResult;
import kodlama.io.northwind.core.utilities.results.SuccessResult;


@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı ekklendi. ");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
	
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"Kullanıcı bulundu.");
	}

}
