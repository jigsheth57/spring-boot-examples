package io.pivotal.example.hrapp;

import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.cloud.service.common.AmqpServiceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.ConnectionFactory;

@Configuration
public class RabbitConfig {

	@Bean
	public ConnectionFactory rabbitConnectionFactory() {
		
		ConnectionFactory connFac = null;
		try {
			CloudFactory cloudFactory = new CloudFactory();
			Cloud cloud = cloudFactory.getCloud();

			List<ServiceInfo> serviceInfos = cloud.getServiceInfos();
			for (ServiceInfo si : serviceInfos) {
				System.out.println("serviceID: " + si.getId());
				System.out.println("service class: " + si.getClass().getName());

				if (si instanceof AmqpServiceInfo) {
					String uri = ((AmqpServiceInfo) si).getUri();
					System.out.println(((AmqpServiceInfo) si).getUri());
					connFac = new ConnectionFactory();
					try {
						connFac.setUri(uri);
					} catch (KeyManagementException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (org.springframework.cloud.CloudException ce) {
			connFac = new ConnectionFactory();
		}
		return connFac;
	}

}

