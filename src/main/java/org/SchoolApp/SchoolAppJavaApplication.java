package org.SchoolApp;

import org.SchoolApp.Services.Impl.NoteService;
import org.SchoolApp.Services.Impl.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.SchoolApp.Datas.Repository")
@EntityScan(basePackages = "org.SchoolApp.Datas.Entity")

public class SchoolAppJavaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SchoolAppJavaApplication.class, args);

		NoteService noteService = (NoteService) context.getBean(NoteService.class);

		noteService.getAllNotes();

		UserService userService = (UserService) context.getBean(UserService.class);

		userService.getAllUsersWithDetails();
	}

}
