package com.cg.healthassist.doctorpatient.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.healthassist.doctorpatient.dao.DoctorDao;
import com.cg.healthassist.doctorpatient.entity.MedicalHistory;
import com.cg.healthassist.doctorpatient.exception.PatientNotFoundException;
/** This class elaborates on service Implementation
* 
* @author Manimozhi
* 
*/  
@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorDao dao;
	/**This method is to add patient medical history */
	@Override
	public MedicalHistory addMedicalHistory(MedicalHistory medHistory) {
			return dao.save(medHistory);
	}
	/**This method is to get one particular medical record using medical record id primary key value */
	@Override
	public ResponseEntity<MedicalHistory> getMedicalRecordById(Integer medicalRecordId) throws PatientNotFoundException {
			MedicalHistory medHistory = dao.findById(medicalRecordId)
					.orElseThrow(() -> new PatientNotFoundException("Patient Not found for " + medicalRecordId));
			return ResponseEntity.ok().body(medHistory);
		
	}
	/**This method is to get all the medical history of one particular patient */
	@Override
	public ResponseEntity<List<MedicalHistory>> getMedicalHistoryByPatientId(Integer patientId) throws PatientNotFoundException {
		List<MedicalHistory> list=dao.findMedicalRecordByPatientId(patientId);
			if(list.isEmpty())
			{
				throw new PatientNotFoundException("Patient Not found for " + patientId);
			}
			else
			{
				return  ResponseEntity.ok().body(list);
			}
		}
}