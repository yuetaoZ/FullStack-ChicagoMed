package edu.depaul.cdm.se.chicagomed;

import edu.depaul.cdm.se.chicagomed.model.Doctor;
import edu.depaul.cdm.se.chicagomed.repository.DoctorRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class DoctorRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DoctorRepository repository;

    @Test
    public void testAdd() {
        // given
        final String DOCTOR_ID = "001";
        Doctor doctorTom = new Doctor();
        doctorTom.setDoctorId(DOCTOR_ID);
        doctorTom.setDoctorFirstName("Tom");
        doctorTom.setDoctorLastName("Cat");
        entityManager.persist(doctorTom);
        entityManager.flush();

        // when
        Doctor found = repository.findByDoctorId(DOCTOR_ID).get(0);

        // then
        assertEquals(found.getDoctorId(), doctorTom.getDoctorId());
    }

    @Test
    public void testUpdate() {
        // given
        final String ORIGINAL_DOCTOR = "0014";
        final String NEW_DOCTOR_ID = "0015";

        // when
        Doctor found = repository.findByDoctorId(ORIGINAL_DOCTOR).get(0);
        found.setDoctorId("0015");
        entityManager.persistAndFlush(found);

        // Should not find any doctor from original doctorID and find one in the new doctorID
        assertEquals(0, repository.findByDoctorId(ORIGINAL_DOCTOR).size());
        assertEquals(1, repository.findByDoctorId(NEW_DOCTOR_ID).size());
    }

}
