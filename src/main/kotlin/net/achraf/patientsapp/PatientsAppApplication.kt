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
                     p1.name = "Lamarti"
                     p1.lastName = "Insaf"
                     p1.score = 4562

                     val p2 = Patient(null, "Boudoudou", "Haytam", LocalDate.now(),  true, 1236)

                    var p3 = Patient()
                    p3.name = "Tmoulik"
                    p3.lastName = "Hamza"
                    p2.score = 789

                    /*patientRepository.save(p1)
                    patientRepository.save(p2)*/
                    /*patientRepository.save(p3)*/

                    val patients: Page<Patient> = patientRepository.findAll(PageRequest.of(0,2))


                        println()
                        println(String.format("\t %-10s %-10s %20s  %10s %5s", "Name", "LastName", "Date of birth", "Score", "Sick"))
                        println("\t- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -")
                        patients.forEach{
                            println(String.format("\t %-10s %-10s %-3ta %-3td %-9tB  %-5tY  %-6d %-5b", it.name, it.lastName, it.dateBirth,it.dateBirth, it.dateBirth, it.dateBirth, it.score, it.Malade))
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
