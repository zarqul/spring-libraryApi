package no.zarqul.library.controllers


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.validation.Valid
import no.zarqul.library.models.Book
import no.zarqul.library.models.User
import no.zarqul.library.repository.BookRepository
import no.zarqul.library.repository.UserRepository
import no.zarqul.library.services.BookService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*



@RestController
@RequestMapping("/book")
class BookController(
    private val bookRepository: BookRepository,
    private val bookService: BookService) {

    // Get a list of all authors
    @GetMapping("/")
    fun getAllBooks() : List<Book> = bookRepository.findAll().toList()

    // Create authors
    @PostMapping("/")
    fun createBook(@Valid @RequestBody book: Book): Book = bookRepository.save(book)

    // Get one author based on their ID
    @GetMapping("/{id}")
    fun getAuthorById(@PathVariable(value = "id") bookId : Long): ResponseEntity<Book> {
        return bookRepository.findById(bookId).map { book ->
            ResponseEntity.ok(book)
        }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/{id}/owners")
    fun getOwnersByBookId(@PathVariable(value = "id") bookId: Long): Set<User> {
        val book = bookRepository.findById(bookId).get()
        return book.getOwners()
    }
}