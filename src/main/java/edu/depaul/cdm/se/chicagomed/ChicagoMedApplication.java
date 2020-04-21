package edu.depaul.cdm.se.chicagomed;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.depaul.cdm.se.chicagomed.model.PatientMedHistory;
import edu.depaul.cdm.se.chicagomed.repository.PatientMedHistoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChicagoMedApplication {


	public static void main(String[] args) {
		SpringApplication.run(ChicagoMedApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PatientMedHistoryRepository repo) {
		return (args) -> {
			PatientMedHistory patient = new PatientMedHistory();
			patient.setPatientId(1);
			ObjectNode history = JsonNodeFactory.instance.objectNode();
			history.put("firstVisit", "March 1 2020");
			patient.setMedicalHistory(history);
			repo.save(patient);
		};


	}

}
