package net.achraf.patientsapp.repositories

import net.achraf.patientsapp.entities.Patient
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository


interface PatientRepository : JpaRepository<Patient, Long>{
    fun findByNameContainsIgnoreCaseOrLastNameContainsIgnoreCase(n : String, l : String, pageable: Pageable) : Page<Patient>
}