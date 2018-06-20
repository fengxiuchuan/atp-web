package com.atp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
// mapper 接口类扫描包配置
// 注意：如果使用了tk.mybaits,MapperScan应该使用tk.mybatis包里面的注解
@MapperScan("com.atp.dao")
@EnableWebMvc
public class Application {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");//Disable Restart
		SpringApplication.run(Application.class, args);
	}
}
