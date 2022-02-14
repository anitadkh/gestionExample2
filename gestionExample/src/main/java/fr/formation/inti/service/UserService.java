package fr.formation.inti.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.dao.IUserDao;
import fr.formation.inti.dao.UserDao;
import fr.formation.inti.entity.User;

@Service
@Transactional
public class UserService implements IUserService {
	private final Log log = LogFactory.getLog(EmployeeService.class);
	private String Message;

	@Autowired
	private IUserDao dao;

	
	public UserService() {
		dao = new UserDao();
	}


	public User findByLoginAndPassword(String login, String password) {

		User user = dao.findByLoginAndPassword(login, password);

		return user;
	}

	
	public Integer ajouterUser(User user) {
		Integer id = dao.save(user);
		return id;
	}

	public static void main(String[] args) {
		IUserService service = new UserService();

		service.findByLoginAndPassword("root", "123456");
	}

	public IUserDao getDao() {
		return dao;
	}

	@Autowired
	public void setDao(IUserDao dao) {
		this.dao = dao;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	@PostConstruct
	private void postConstruct() {
		log.info("------------ init serviec : @PostConstruct --------------");
	}

	@PreDestroy
	private void preDestroy() {
		log.info("------------ destroy service  --------------");
		if (dao != null) {
			log.info("------------ service : @PreDestroy close sessionFactory --------------");

		}

	}
}
