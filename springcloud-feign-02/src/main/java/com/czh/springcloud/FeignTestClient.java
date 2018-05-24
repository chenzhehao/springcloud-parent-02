package com.czh.springcloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * Title: FeignClient.java
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
 * @date 2018年4月16日
 * @version 1.0
 */
@FeignClient(value="spring-cloud-zookeeper-client-app")
public interface FeignTestClient {
	@RequestMapping(method = RequestMethod.GET, value = "/hello2")
	String hello2(@RequestParam(value = "name") String name);
}
