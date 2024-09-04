package net.achraf.patientsapp.web

import net.achraf.patientsapp.entities.Patient
import net.achraf.patientsapp.repositories.PatientRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class PatientRestController(val patientRepository: PatientRepository) {

    @GetMapping("/patients-json")
    fun getPatientsJSON() : List<Patient> {
        val patients : List<Patient> = patientRepository.findAll()
        return patients
    }
}