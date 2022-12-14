package io.dinixweb.SpringbootgraphQL;

import io.dinixweb.SpringbootgraphQL.model.Guardian;
import io.dinixweb.SpringbootgraphQL.model.Students;
import io.dinixweb.SpringbootgraphQL.model.Subjects;
import io.dinixweb.SpringbootgraphQL.repository.GuardianRepository;
import io.dinixweb.SpringbootgraphQL.repository.StudentRepository;
import io.dinixweb.SpringbootgraphQL.repository.SubjectRepository;
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
	ApplicationRunner applicationRunner (StudentRepository studentRepository, SubjectRepository subjectRepository, GuardianRepository guardianRepository){
		return args -> {
			Students student1 = new Students(1, "James", "Mike", "Grade 12");
			Students student2 = new Students(2, "Olu", "Hillary", "Grade 12");
			Students student3 = new Students(3, "Bisi", "Jacobs", "Grade 8");
			List<Students> students = new ArrayList<>(Arrays.asList(student1, student2, student3));
			studentRepository.saveAll(students);
			subjectRepository.saveAll(List.of(
					new Subjects(2, "Physics", "Mr James", 1),
					new Subjects(3, "Chemistry", "Mrs Jessica",2),
					new Subjects(4, "Mathematics", "Mr Mike",3)));
			guardianRepository.saveAll(List.of(
					new Guardian(1,"Modupe", "Akinlola","modupe@gmail.com", 1),
					new Guardian(2,"Faith", "John","faith23@gmail.com", 2),
					new Guardian(2,"Moses", "Asie","moses@gmail.com", 3)
			));

		};

	}

}
