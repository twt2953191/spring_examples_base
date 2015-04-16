import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import dw.spring3.rest.bean.Employee;
import dw.spring3.rest.bean.EmployeeList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/rest-client.xml"})
public class RestTestCase {
//	JdbcTemplate;
//	JmsTemplate;
	@Resource
	RestTemplate restTemplate;
	@Test
	public void test() {
		String uri;
		uri = "http://localhost:8088/spring_rest/service/employees";
		EmployeeList list = restTemplate.getForObject(uri, EmployeeList.class);
		List<Employee> employees = list.getEmployees();
		for(Employee emp:employees){
			System.out.println(emp.getName());
		}
	}
	@Test
	public void test2(){
		String uri;
		uri = "http://localhost:8088/spring_rest/service/employee/{id3}";		
		Employee e = restTemplate.getForObject(uri, Employee.class, 2);
		System.out.println(e.getId());
		System.out.println(e.getName());
	}
	
}
