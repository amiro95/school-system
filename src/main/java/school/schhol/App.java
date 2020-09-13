package school.schhol;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import school.schhol.dto.Student;
import school.schhol.repository.StudentRepository;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Configuration
@ComponentScan
public class App extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
	}

	@Override

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	private static Class<App> applicationClass = App.class;
	
	@Bean
	CommandLineRunner runner(StudentRepository studentRepository) {

		return args -> {
			studentRepository.save(new Student(1,"Amir", 1001, "Bahasa Melayu"));
			studentRepository.save(new Student(2,"Akmal", 1002, "Mathematics"));
			studentRepository.save(new Student(3,"Calven", 1003, "Science"));
			studentRepository.save(new Student(4,"Jon", 1004, "History"));
			studentRepository.save(new Student(5,"Jason", 1004, "History"));
			studentRepository.save(new Student(6,"Azim", 1001, "Bahasa Melayu"));
		};
		
	}
}
