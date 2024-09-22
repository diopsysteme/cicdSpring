package org.SchoolApp;


import org.SchoolApp.Datas.Entity.EmargementEntity;
import org.SchoolApp.Datas.Entity.UserEntity;
import org.SchoolApp.Datas.Repository.EmargementRepository;
import org.SchoolApp.Datas.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.SchoolApp.Datas.Repository")
@EntityScan(basePackages = "org.SchoolApp.Datas.Entity")

public class SchoolAppJavaApplication implements WebMvcConfigurer {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SchoolAppJavaApplication.class, args);

		NoteService noteService = (NoteService) context.getBean(NoteService.class);

		noteService.getAllNotes();
	}


}
