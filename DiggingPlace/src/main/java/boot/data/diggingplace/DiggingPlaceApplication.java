package boot.data.diggingplace;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"boot.data.*","boot.data.diggingplace"})
@MapperScan("boot.data.*")
public class DiggingPlaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiggingPlaceApplication.class, args);
	}

}
