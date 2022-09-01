package com.hospital.management.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hospital.management.model.Doctor;
import com.hospital.management.model.Patient;
import com.hospital.management.service.DoctorService;

//T: object k type(doctor), ID: type of id(type of id of doctor)
//Object not required thats why we put annotation-So that springboot works 
@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long>{

	Doctor findByDoctorId(String doctorId);

	void deleteByDoctorId(String doctorId);
	
}
