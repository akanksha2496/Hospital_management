package com.hospital.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.model.Doctor;
import com.hospital.management.model.Patient;
import com.hospital.management.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	public Doctor save(Doctor doctor) {
		// TODO Auto-generated method stub
		Doctor doctorSaveToDB = doctorRepository.save(doctor);
		return doctorSaveToDB;
	}

	public List<Patient> getPatientInfoByDoctorId(String doctorId) {
		// TODO Auto-generated method stub
		Doctor  doctor= doctorRepository.findByDoctorId(doctorId);
		List<Patient> patientsListOfDoctor= doctor.getPatients();
		return patientsListOfDoctor;
	}

	public void deletByDoctorId(String doctorId) {
		// TODO Auto-generated method stub
		doctorRepository.deleteById((long) 1);
	}
}
