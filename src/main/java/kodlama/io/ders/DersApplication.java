package kodlama.io.ders;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DersApplication {

	public static void main(String[] args) {
		SpringApplication.run(DersApplication.class, args);
	}
	@Bean //IOC'ye modelMapper ekledi
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}


}
