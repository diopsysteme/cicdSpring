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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.SchoolApp.Datas.Repository")
@EntityScan(basePackages = "org.SchoolApp.Datas.Entity")
public class SchoolAppJavaApplication implements CommandLineRunner {

	@Autowired
	private EmargementRepository emargementRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SchoolAppJavaApplication.class, args);
		System.out.println("Hello World!");
	}

	@Override
	public void run(String... args) throws Exception {
		Long userId = 4L; // Repl																																																																																																																																																																																																																																																																																																																																																																																																																		ace with a valid user ID
		LocalDate date = LocalDate.now(); // Current date
		LocalDate startDate = LocalDate.now(); // Replace with actual start date
		LocalDate endDate = LocalDate.now(); // Re

		// Fetch the UserEntity by ID
		UserEntity user = userRepository.findById(userId).orElseThrow(() -> new Exception("User not found"));

		// Retrieve an emargement by user and date
		EmargementEntity emargement = emargementRepository.findByUserAndDate(user, date);
		System.out.println("Emargement: " + emargement);

		// Retrieve absences for a user
		EmargementEntity absences = emargementRepository.findByUserAndEntreeIsNullOrSortieIsNullAndDate(user, date);
		System.out.println("Absences: " + absences);

		// Retrieve presences between two dates
		List<EmargementEntity> presences = emargementRepository.findByUserAndEntreeIsNotNullAndSortieIsNotNullAndDateBetween(user, startDate, endDate);
		System.out.println("Presences: " + presences);

		// Retrieve all emargements for the user
		List<EmargementEntity> allEmargements = emargementRepository.findByUser(user);
		System.out.println("All emargements: " + allEmargements);
	}
}
