/**
 * 
 */
package io.pivotal.example.hrapp.domain.listener;

import io.pivotal.example.hrapp.RabbitConfig;
import io.pivotal.example.hrapp.domain.Employee;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Listens for change to Employee entity
 * 
 * @author Jig Sheth
 *
 */
public class EmployeeListener {

	ObjectMapper mapper = new ObjectMapper();
	
	final static String queueName = "hr-app.cfapps.io.employee";
	
	RabbitTemplate rabbitTemplate = new RabbitTemplate();
	
	
	/**
	 * 
	 */
	public EmployeeListener() {
		super();
		rabbitTemplate.setConnectionFactory(new CachingConnectionFactory(new RabbitConfig().rabbitConnectionFactory()));
	}

	@PostPersist
	public void postPersist(Employee employee) {
		try {
			String jsonStr = mapper.writeValueAsString(employee);
			String msg = "Created@@" + jsonStr;
			System.out.println(msg);
			publishMsg(msg);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@PostUpdate
	public void postUpdate(Employee employee) {
		try {
			String jsonStr = mapper.writeValueAsString(employee);
			String msg = "Updated@@" + jsonStr;
			System.out.println(msg);
			publishMsg(msg);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@PostRemove
	public void postRemove(Employee employee) {
		try {
			String jsonStr = mapper.writeValueAsString(employee);
			String msg = "Deleted@@" + jsonStr;
			System.out.println(msg);
			publishMsg(msg);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void publishMsg(String message) {
		rabbitTemplate.convertAndSend(queueName, message);	
	}
	  
}