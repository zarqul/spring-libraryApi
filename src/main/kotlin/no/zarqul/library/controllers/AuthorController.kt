package no.zarqul.library.controllers

import jakarta.validation.Valid
import no.zarqul.library.Author
import no.zarqul.library.repository.AuthorRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/author")
class AuthorController(private val authorRepository: AuthorRepository) {
    // Get a list of all authors
    @GetMapping("/")
    fun getAllAuthors() : List<Author> = authorRepository.findAll().toList()

    // Create authors
    @PostMapping("/")
    fun createAuthor(@Valid @RequestBody author: Author): Author = authorRepository.save(author)

    // Get one author based on their ID
    @GetMapping("/{id}")
    fun getAuthorById(@PathVariable(value = "id") authorId : Long): ResponseEntity<Author> {
        return authorRepository.findById(authorId).map { author ->
            ResponseEntity.ok(author)
        }.orElse(ResponseEntity.notFound().build())
    }
}