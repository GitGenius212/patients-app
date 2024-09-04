package net.achraf.patientsapp

import net.achraf.patientsapp.entities.Patient
import net.achraf.patientsapp.repositories.PatientRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import java.time.LocalDate
import java.util.*

@SpringBootApplication
class PatientsAppApplication {

    @Bean
    fun start(patientRepository: PatientRepository) : CommandLineRunner {
        return CommandLineRunner {

                     var p1 = Patient()
                     p1.Name = "Lamarti"
                     p1.LastName = "Insaf"
                     p1.Score = 4562

                     val p2 = Patient(null, "Boudoudou", "Haytam", LocalDate.now(),  true, 1236)

                    var p3 = Patient()
                    p3.Name = "Tmoulik"
                    p3.LastName = "Hamza"
                    p2.Score = 789

                    /*patientRepository.save(p1)
                    patientRepository.save(p2)*/
                    /*patientRepository.save(p3)*/

                    val patients: Page<Patient> = patientRepository.findAll(PageRequest.of(0,2))


                        println()
                        println(String.format("\t %-10s %-10s %20s  %10s %5s", "Name", "LastName", "Date of birth", "Score", "Sick"))
                        println("\t- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -")
                        patients.forEach{
                            println(String.format("\t %-10s %-10s %-3ta %-3td %-9tB  %-5tY  %-6d %-5b", it.Name, it.LastName, it.DateBirth,it.DateBirth, it.DateBirth, it.DateBirth, it.Score, it.Malade))
                        }
                        println("\t- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -")







        }
    }

    @Bean
    fun passwordEncoder() : PasswordEncoder {
        return BCryptPasswordEncoder()
    }

}

fun main(args: Array<String>) {
    runApplication<PatientsAppApplication>(*args)
}
