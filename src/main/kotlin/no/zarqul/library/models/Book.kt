package no.zarqul.library.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonFilter
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import no.zarqul.library.models.Author

@Entity
@Table(name="books")
class Book (
    @Column(nullable = false)
    val title : String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @ManyToMany(mappedBy = "authoredBooks")
    @JsonIgnoreProperties("authoredBooks")
    val authors: List<Author> = listOf(),

    @ManyToMany(mappedBy = "bookCollection")
    @JsonIgnoreProperties("bookCollection")
    val owners: List<User> = listOf()

    ) {

    override fun toString(): String {
        return super.toString()
    }

    @JsonIgnore
    fun getOwners(): Set<User> {
        return owners.toSet()
    }
}