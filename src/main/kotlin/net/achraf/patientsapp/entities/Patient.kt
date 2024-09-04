package net.achraf.patientsapp.entities

import jakarta.persistence.*
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "PATIENTS")
class Patient(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id : Long? = null,

    private var name : String = "no name",

    private var lastName : String = "no lastName",

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private var dateBirth : LocalDate = LocalDate.now(),

    private var malade : Boolean = false,

    @NotNull
    @Min(value = 10)
    private var score : Int = 0


) {

val Identifiant : Long?
     get() = id


var Name : String
     get() = name
    set(value) {
        name = value
    }

var LastName : String
     get() = lastName
    set(value) {
        lastName = value
    }
@get:DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
var DateBirth : LocalDate
     get() = dateBirth
     set(value) {
        dateBirth = value
     }

var Malade : Boolean
    get() = malade
    set(value) {
        malade = value
    }

var Score : Int
    get() = score
    set(value) {
        score = value
    }


}