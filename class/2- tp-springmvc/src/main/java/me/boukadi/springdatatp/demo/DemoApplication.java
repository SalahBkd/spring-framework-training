package me.boukadi.springdatatp.demo;

import me.boukadi.springdatatp.demo.dao.PatientRepository;
import me.boukadi.springdatatp.demo.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class DemoApplication {

	/*@Autowired
	PatientRepository patientRepository;*/

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

	/*@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"salah", new Date(), 242, false));
	}*/
}
