package no.zarqul.library

import jakarta.persistence.*

@Entity
data class Book (
    @Column(nullable = false)
    val title : String,

    @Column(nullable = true)
    @ManyToMany(cascade = [CascadeType.ALL])
    val author : List<Author>,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?
    ) {

    override fun toString(): String {
        return super.toString()
    }
}