package no.zarqul.library.models

import jakarta.persistence.*

@Entity
@Table(name="users")
class User (
    @Column(name="first_name", nullable=false)
    val firstName: String,

    @Column(name="last_name", nullable=false)
    val lastName: String,

    @ManyToMany
    @JoinTable(
        name="book_collection",
        joinColumns = [JoinColumn(name="user_id")],
        inverseJoinColumns = [JoinColumn(name="book_id")]
    )
    var bookCollection: MutableSet<Book>?,

    @ManyToMany
    @JoinTable(
        name="friends",
        joinColumns = [JoinColumn(name="user_id")],
        inverseJoinColumns = [JoinColumn(name="friend_id")]
    )
    val friends: Set<User>?,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
) {

    fun addBookToCollection(book: Book) {
        bookCollection?.add(book)
    }
}