package no.zarqul.library.controllers

import jakarta.validation.Valid
import no.zarqul.library.Author
import no.zarqul.library.Book
import no.zarqul.library.repository.BookRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/book")
class BookController(private val bookRepository: BookRepository) {
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
}