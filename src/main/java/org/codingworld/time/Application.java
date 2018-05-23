package org.codingworld.time;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// mapper 接口类扫描包配置
//
@MapperScan("org.codingworld.time.dao")
public class Application {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");//Disable Restart
		SpringApplication.run(Application.class, args);
	}
}
