package com.czh.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author chenzhehao
 *
 * @SpringBootApplication 使用了@SpringBootApplication注解的话，系统会去入口类的同级包以及下级包中去扫描实体类
 *
 * @EnableEurekaServer注解启动一个服务注册中心提供给其他应用进行对话
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class SpringCloudFeign extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringCloudFeign.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringCloudFeign.class, args);
	}

	@Autowired
	FeignTestClient feignTestClient;
	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	public String add1() {
		return feignTestClient.hello2("chenzhehao");
	}

}
