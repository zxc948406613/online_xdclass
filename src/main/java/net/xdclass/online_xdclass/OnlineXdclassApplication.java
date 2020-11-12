package net.xdclass.online_xdclass;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author suning
 */
@EnableTransactionManagement
@MapperScan(value = {"net.xdclass.online_xdclass.mapper"})
@SpringBootApplication
public class OnlineXdclassApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineXdclassApplication.class, args);
	}

}
