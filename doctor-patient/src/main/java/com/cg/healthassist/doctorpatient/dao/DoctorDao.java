package com.cg.healthassist.doctorpatient.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.healthassist.doctorpatient.entity.MedicalHistory;
/** This interface define dao repository
* 
* @author Manimozhi
* 
*/
@Repository
public interface DoctorDao extends JpaRepository<MedicalHistory, Integer>{
	@Query("SELECT c FROM MedicalHistory c WHERE c.patientId = :patientId")
	List<MedicalHistory> findMedicalRecordByPatientId(int patientId);

}
