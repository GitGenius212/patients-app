package net.achraf.patientsapp.web

import jakarta.validation.Valid
import net.achraf.patientsapp.entities.Patient
import net.achraf.patientsapp.repositories.PatientRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*


@Controller
class PatientController(private val patientRepository: PatientRepository) {




    @GetMapping("/index")
    fun index(model: Model, @RequestParam(name = "page", defaultValue = "0") page : Int,
              @RequestParam(name = "size", defaultValue = "5") size : Int,
              @RequestParam(name = "keyword", defaultValue = "") keyword : String
              ) : String {
        //val pagePatients : Page<Patient> = patientRepository.findAll(PageRequest.of(page,size))
        val pagePatients : Page<Patient> = patientRepository.findByNameContainsIgnoreCaseOrLastNameContainsIgnoreCase(keyword, keyword, PageRequest.of(page,size))
        model.addAttribute("listPatients", pagePatients.content) //or pagePatients
        model.addAttribute("pages", Array<Int>(pagePatients.totalPages) {0} )
        model.addAttribute("currentPage", page)
        model.addAttribute("keyword", keyword)

        return "patients"
    }

    @GetMapping("/deletePatient")
    fun delete( id : Long, @RequestParam(name = "keyword") keyword: String, page : Int) : String {
        patientRepository.deleteById(id)
        return "redirect:/index?page="+ page + "&keyword=" + keyword
    }

    @GetMapping("/edit")
    fun edit( id : Long, model: Model) : String {
        val patient : Patient = patientRepository.getReferenceById(id)
        model.addAttribute("patient", patient)
        return "edit-patient"
    }

    @GetMapping("/")
    fun acceuil() : String{
        return "acceuil"
    }

    @GetMapping("/notAutorized")
    fun notAuthorizedPage() : String{
        return "notAuthorized"
    }

    @GetMapping("/save")
    fun saveParticipant(model: Model) : String{
        model.addAttribute("patient", Patient())
        return "new-participants"
    }

    @PostMapping("/addPatient")
    fun addPatient( @Valid patient: Patient, result : BindingResult) : String {
        //println("Patient ->   " + patient)
        if (result.hasErrors()) {
            println("Errors")
            return "new-participants"
        }
        patientRepository.save(patient)
        return "redirect:/index"
    }

    @PutMapping("/patientEdited")
    fun patientEdited(patientUpdated: Patient, id: Long) : String {
        /*val id : Long? = patient.identifiant*/
        println(id)
        println("Patient ->   " + patientUpdated.LastName)
        val patient : Patient = patientRepository.getReferenceById(id)
        patientRepository.save(patientUpdated)
        return "redirect:/index"
    }




}