package no.zarqul.library

import jakarta.persistence.*

@Entity
@Table(name="authors")
data class Author
    (
    @Column(name="first_name", nullable = false)
    val firstName : String,

    @Column(name="last_name", nullable = false)
    val lastName: String,

    @Column(name="birth_year", nullable = true)
    val birthYear: Int,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?
    ){

    override fun toString(): String {
        return super.toString()
    }
}