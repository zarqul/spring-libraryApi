package no.zarqul.library

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*

@Entity
@Table(name="books")
data class Book (
    @Column(nullable = false)
    val title : String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @ManyToMany(mappedBy = "authoredBooks")
    @JsonIgnoreProperties("authoredBooks")
    val authors: List<Author> = listOf()

    ) {

    override fun toString(): String {
        return super.toString()
    }
}