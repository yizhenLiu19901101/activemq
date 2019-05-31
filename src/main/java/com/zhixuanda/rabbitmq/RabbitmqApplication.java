package com.zhixuanda.rabbitmq;

import com.zhixuanda.rabbitmq.entity.User;
import com.zhixuanda.rabbitmq.service.ProducerService;
import oracle.jvm.hotspot.jfr.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqApplication.class, args);
	}

}
