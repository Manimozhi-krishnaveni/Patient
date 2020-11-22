package com.cg.healthassist.doctorpatient.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.healthassist.doctorpatient.dao.DoctorDao;
import com.cg.healthassist.doctorpatient.entity.MedicalHistory;
/** This class defines the test case for methods in service class
* 
* @author Manimozhi
* 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
class DoctorServiceImplTest {
	@Autowired
	private DoctorServiceImpl doctor;
	@MockBean
	private DoctorDao dao;
	/** to test add medical history in the service class */
	@Test
	void testAddMedicalHistory() throws Exception{
		MedicalHistory medHistory = new MedicalHistory();
		medHistory.setMedicalRecordId(15);
		medHistory.setPatientId(12);
		medHistory.setPatientName("aaa");
		medHistory.setDiagnosis("xxx");
		medHistory.setTreatment("sss");
		medHistory.setDoctorName("kkk");
		medHistory.setDate(LocalDateTime.now());
		//dao.save(medHistory);
		Mockito.when(dao.save(medHistory)).thenReturn(medHistory);
        assertThat(doctor.addMedicalHistory(medHistory)).isEqualTo(medHistory);
		
	}
	/** to test get medical record by id in the service class */
	@Test
	void testGetMedicalRecordById() throws Exception {
		MedicalHistory medHistory = new MedicalHistory();
		medHistory.setMedicalRecordId(15);
		medHistory.setPatientId(12);
		medHistory.setPatientName("aaa");
		medHistory.setDiagnosis("xxx");
		medHistory.setTreatment("sss");
		medHistory.setDoctorName("kkk");
		medHistory.setDate(LocalDateTime.now());
		dao.save(medHistory);
        assertThat(medHistory.getMedicalRecordId()).isEqualTo(15);
	}
	/** to test get medical record by patient id in the service class */
	@Test
	void testGetMedicalHistoryByPatientId() throws Exception{
		MedicalHistory medHistory = new MedicalHistory();
		medHistory.setMedicalRecordId(15);
		medHistory.setPatientId(12);
		medHistory.setPatientName("aaa");
		medHistory.setDiagnosis("xxx");
		medHistory.setTreatment("sss");
		medHistory.setDoctorName("kkk");
		medHistory.setDate(LocalDateTime.now());
		List<MedicalHistory> ticketList = new ArrayList<>();
        ticketList.add(medHistory);
		Mockito.when(dao.findMedicalRecordByPatientId(12)).thenReturn(ticketList);
        assertNotNull(ticketList);
		//assertThat(doctor.getMedicalHistoryByPatientId(12)).isEqualTo(ticketList);
		
	}

}
