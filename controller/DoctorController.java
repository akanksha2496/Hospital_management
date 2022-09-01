package com.hospital.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.management.model.Doctor;
import com.hospital.management.model.Patient;
import com.hospital.management.service.DoctorService;

//yaha sirf api detail, path n all rhega
//business logic- will be in service.
//in reprository - the opertaion which we perofmr will be in query. DB se
//dta retive krna ho vo sab reta

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	
	//Controller dpeendt hai serive pe
	//dependecy injection.
	@Autowired
	private DoctorService doctorService;
	
	// json need doctor type for. Create:
	@PostMapping("/save")
	public ResponseEntity<Doctor> save(@RequestBody Doctor doctor) {
		Doctor saveToDb = doctorService.save(doctor);
		return new ResponseEntity<>(saveToDb,HttpStatus.OK);
	}
	
	@GetMapping("/getPatientInfoByDoctorId/{doctorId}")
	public ResponseEntity<List<Patient>> getPatientInfoByDoctorId(@PathVariable String doctorId){
		List<Patient> patients=doctorService.getPatientInfoByDoctorId(doctorId);
	 	return new ResponseEntity<>(patients, HttpStatus.OK);		
	}
	
	@DeleteMapping("/deleteByDoctorId/{doctorId}")
	public String deleteByDoctorId(@PathVariable String doctorId) {
		doctorService.deletByDoctorId(doctorId);
		return doctorId+" deleted successfully.";
	}
	
	//delete by doctor Id
	
}
