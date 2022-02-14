package fr.formation.inti.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.dao.IEmployeeDao;
import fr.formation.inti.entity.Employee;

@Service
@Transactional
public class EmployeeService implements IEmployeeService {
	private final Log log = LogFactory.getLog(EmployeeService.class);
    private String Message;
	
//    @Autowired
	private IEmployeeDao dao;

	public EmployeeService() {
		log.info("create new EmployeeService()");
	
	}
//	@Autowired -> injection par constructeur 
	public EmployeeService(IEmployeeDao dao) {
		log.info("------------------------- new EmployeeService(dao)");
		this.dao = dao;
	}

	
	

	@Override
	public Integer save(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public void update(Employee employee) {
		dao.update(employee);

	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public Employee findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Employee> findAll() {
	
		List<Employee> list = dao.findAll();
		
		return list;
	}

	public IEmployeeDao getDao() {
		return dao;
	}
// Setter pour la config xml
	@Autowired
	public void setDao(IEmployeeDao dao) {
		log.info("injection par setteur " +dao);
		this.dao = dao;
	}
	public String getMessage() {
		return Message;
	}
	
	// Setter pour le Message xml
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
