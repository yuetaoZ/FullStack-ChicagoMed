package edu.depaul.cdm.se.chicagomed;


import edu.depaul.cdm.se.chicagomed.model.DoctorReview;
import edu.depaul.cdm.se.chicagomed.model.LocationReview;
import edu.depaul.cdm.se.chicagomed.repository.DoctorReviewRepository;
import edu.depaul.cdm.se.chicagomed.repository.LocationReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChicagoMedApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChicagoMedApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner addPatientMedHistory(PatientMedHistoryRepository patientMedHistoryRepository) {
//        return (args) -> {
//        	patientMedHistoryRepository.deleteById(12345L);
//			patientMedHistoryRepository.deleteById(12346L);
//			patientMedHistoryRepository.deleteById(12347L);
//			patientMedHistoryRepository.deleteById(12348L);
//            PatientMedHistory patientMedHistory1 = new PatientMedHistory();
//            patientMedHistory1.setPatientId(12345);
//            patientMedHistory1.setMedicalHistory(JsonNodeFactory.instance.textNode("I have bad seasonal allergies. I broke my thumb on my left hand.").textValue());
//
//			PatientMedHistory patientMedHistory2 = new PatientMedHistory();
//			patientMedHistory2.setPatientId(12346);
//			patientMedHistory2.setMedicalHistory(JsonNodeFactory.instance.textNode("I have bad peanut allergies. I have not had any surgeries").textValue());
//
//			PatientMedHistory patientMedHistory3 = new PatientMedHistory();
//			patientMedHistory3.setPatientId(12347);
//			patientMedHistory3.setMedicalHistory(JsonNodeFactory.instance.textNode("I have been generally healthy.").textValue());
//
//			PatientMedHistory patientMedHistory4 = new PatientMedHistory();
//			patientMedHistory4.setPatientId(12348);
//			patientMedHistory4.setMedicalHistory(JsonNodeFactory.instance.textNode("I have been generally unhealthy.").textValue());
//
//			patientMedHistoryRepository.save(patientMedHistory1);
//			patientMedHistoryRepository.save(patientMedHistory2);
//			patientMedHistoryRepository.save(patientMedHistory3);
//			patientMedHistoryRepository.save(patientMedHistory4);
//        };
//    }
//
//
//	@Bean
//	public CommandLineRunner demo(PatientRepository repo, PatientContactRepository patientContactRepository) {
//		return (args) -> {
//			Patient patient = new Patient();
//			patient.setPatientFirstName("test");
//			patient.setPatientLastName("test");
//			patient = repo.save(patient);
//
//			PatientContact patientContact = new PatientContact();
//			patientContact.setPatient(patient);
//			patientContact.setPatientId(patient.getPatientId());
//			patientContactRepository.save(patientContact);
//
//			Optional<PatientContact> patientContact1 = patientContactRepository.findById(patient.getPatientId());
//			patientContact.getAddress();
//		};
//	}
//
	@Bean
	public CommandLineRunner Chicago(DoctorReviewRepository doctorReviewRepository) {
		return (args) -> {
			String doctorId;
			DoctorReview doc1 = new DoctorReview(doctorId ="1","Dr. Johnson is a good doctor");
            DoctorReview doc2 = new DoctorReview(doctorId ="2","Dr. Johnson is a good doctor");
            DoctorReview doc3 = new DoctorReview(doctorId ="3","Dr. Johnson is a good doctor");
			doctorReviewRepository.save(doc1);
            doctorReviewRepository.save(doc2);
            doctorReviewRepository.save(doc3);
		};
	}

	@Bean
	public CommandLineRunner locationReviewData(LocationReviewRepository locationReviewRepository) {
		return (args) -> {
			String locationId;
			LocationReview loc1 = new LocationReview(locationId ="1","Northwestern Hospital is super big!");
			LocationReview loc2 = new LocationReview(locationId ="2","Chicago Primary Care has nice people.");
			locationReviewRepository.save(loc1);
			locationReviewRepository.save(loc2);
		};
	}
//
//	@Bean
//	public CommandLineRunner ApptNotesDemo(ApptNotesRepository apptNotesRepo) {
//		return (args) -> {
//			ApptNotes apptNote = new ApptNotes();
//			apptNote.setAppointmentId(1);
//			ObjectNode note = JsonNodeFactory.instance.objectNode();
//			note.put("Appointment1", "regular check.");
//			apptNote.setAppointmentNotes(note);
//			apptNotesRepo.save(apptNote);
//		};
//	}
//
//	@Bean
//	public CommandLineRunner DoctorScheduleDemo(DoctorScheduleRepository doctorScheduleRepo) {
//		return (args) -> {
//			DoctorSchedule schedule = new DoctorSchedule();
//			schedule.setDoctorID(1);
//			ObjectNode note = JsonNodeFactory.instance.objectNode();
//			note.put("Available Time", "Mon Tue Sat Sun");
//			schedule.setSchedule(note);
//			doctorScheduleRepo.save(schedule);
//		};
//	}

}
