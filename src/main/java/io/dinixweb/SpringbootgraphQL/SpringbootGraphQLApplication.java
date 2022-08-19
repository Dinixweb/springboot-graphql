package io.dinixweb.SpringbootgraphQL;

import io.dinixweb.SpringbootgraphQL.model.Students;
import io.dinixweb.SpringbootgraphQL.model.Subjects;
import io.dinixweb.SpringbootgraphQL.repository.guardianRepository;
import io.dinixweb.SpringbootgraphQL.repository.studentRepository;
import io.dinixweb.SpringbootgraphQL.repository.subjectRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringbootGraphQLApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootGraphQLApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner (studentRepository studentRepository, subjectRepository subjectRepository, guardianRepository guardianRepository){
		return args -> {
			Students student1 = new Students( 1, "James","Mike","Grade 12");
			Students student2 = new Students( 2, "Olu","Hillary","Grade 12");
			Students student3 = new Students( 3, "Bisi","Jacobs","Grade 8");
			List<Students> students = new ArrayList<>(Arrays.asList(student1, student2, student3));
			studentRepository.saveAll(students);
			subjectRepository.saveAll(List.of(
					new Subjects(12, "Maths","Mr Joe"),
					new Subjects(1, "English","Mr Philip")));
		};


	}

}
