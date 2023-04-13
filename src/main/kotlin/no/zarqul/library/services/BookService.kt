package no.zarqul.library.services

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import no.zarqul.library.models.Book
import no.zarqul.library.models.User
import no.zarqul.library.repository.BookRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.toList

@Service
class BookService(val db: BookRepository) {
    fun findBooks(): List<Book> = db.findAll().toList()

    @OptIn(ExperimentalStdlibApi::class)
    fun findBookById(id: Long): List<Book> = db.findById(id).toList()

    fun save(book: Book) {
        db.save(book)
    }
}