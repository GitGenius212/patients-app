package net.achraf.patientsapp.entities

import jakarta.persistence.*
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "PATIENTS")
class Patient(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id : Long? = null,

    @field:NotBlank(message = "Le prénom est requis")
    @field:Size(min=2, max = 50)
      var name : String = "no name",

    @field:NotBlank(message = "Le nom de famille est requis")
    @field:Size(min=2, max = 50)
     var lastName : String = "no lastName",

    @Temporal(TemporalType.DATE)
    @get:DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
     var dateBirth : LocalDate = LocalDate.now(),

    private var malade : Boolean = false,


    @field:Min(10, message = "Le score doit être égale ou supérieur à 10")
     var score : Int = 10


) {

val Identifiant : Long?
     get() = id


/*var Name : String
     get() = name
    set(value) {
        name = value
    }*/

/*var LastName : String
     get() = lastName
    set(value) {
        lastName = value
    }*/
/*@get:DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
var DateBirth : LocalDate
     get() = dateBirth
     set(value) {
        dateBirth = value
     }*/

var Malade : Boolean
    get() = malade
    set(value) {
        malade = value
    }

/*var Score : Int
    get() = score
    set(value) {
        score = value
    }*/


}