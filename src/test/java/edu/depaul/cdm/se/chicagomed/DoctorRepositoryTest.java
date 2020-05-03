package edu.depaul.cdm.se.chicagomed;

import edu.depaul.cdm.se.chicagomed.model.Doctor;
import edu.depaul.cdm.se.chicagomed.repository.DoctorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class DoctorRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DoctorRepository repository;

    @Test
    public void testAdd() {
        // given
        Doctor doctorTom = new Doctor();
        Long doctorID = doctorTom.getDoctorid();
        doctorTom.setDoctorFirstName("Tom");
        doctorTom.setDoctorLastName("Cat");
        entityManager.persist(doctorTom);
        entityManager.flush();

        // when
        Optional<Doctor> found = repository.findById(doctorID);

        // then
        assertEquals(found.get().getDoctorFirstName(), doctorTom.getDoctorFirstName());
    }

    @Test
    public void testUpdate() {
        // given
        Doctor randomDoctor = new Doctor();
        entityManager.persist(randomDoctor);
        entityManager.flush();
        final Long ORIGINAL_DOCTOR = randomDoctor.getDoctorid();
        final Long NEW_DOCTOR_ID = 15L;


        // when
        Doctor found = repository.findById(ORIGINAL_DOCTOR).get();
        found.setDoctorid(NEW_DOCTOR_ID);
        entityManager.persistAndFlush(found);

        // Should not find any doctor from original doctorID and find one in the new doctorID
        assertTrue(repository.findById(ORIGINAL_DOCTOR).isEmpty());
        assertFalse(repository.findById(NEW_DOCTOR_ID).isEmpty());
    }

}
