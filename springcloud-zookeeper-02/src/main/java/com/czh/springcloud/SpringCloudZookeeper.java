package com.czh.springcloud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Title: SpringCloudZookeeper.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2018
 * </p>
 * <p>
 * Company: www.chenzhehao.com
 * </p>
 * 
 * @author chenzhehao
 * @date 2018年4月14日
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SpringCloudZookeeper extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringCloudZookeeper.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringCloudZookeeper.class, args);
	}

	@Value("${spring.application.name}")
	private String instanceName;

	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping
	public String hello() {
		return "Hello,Zookeeper.";
	}

	@RequestMapping("hello")
	public String hello1() {
		return "Hello11111,Zookeeper.";
	}

	@RequestMapping("hello2")
	public String hello2(String name) {
		System.out.println("zookeeper");
		return "Hello11111,Zookeeper."+name;
	}
	
	@GetMapping("/services")
	public List<String> serviceUrl() {
		List<ServiceInstance> list = discoveryClient.getInstances(instanceName);
		List<String> services = new ArrayList<>();
		if (list != null && list.size() > 0) {
			list.forEach(serviceInstance -> {
				services.add(serviceInstance.getUri().toString());
			});
		}
		return services;
	}
}
