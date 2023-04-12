package no.zarqul.library.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
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
    var id: Long?,

    @ManyToMany
    @JoinTable(
        name="authoredBooks",
        joinColumns = [JoinColumn(name="author_id")],
        inverseJoinColumns = [JoinColumn(name="book_id")]
    )
    @JsonIgnoreProperties("authors")
    var authoredBooks: Set<Book>? = null
) {

    override fun toString(): String {
        return super.toString()
    }
}