package no.zarqul.library.services

import no.zarqul.library.models.Author
import no.zarqul.library.repository.AuthorRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.toList

@Service
class AuthorService(val db: AuthorRepository) {
    fun findAuthors(): List<Author> = db.findAll().toList()

    @OptIn(ExperimentalStdlibApi::class)
    fun findAuthorById(id: Long): List<Author> = db.findById(id).toList()

    fun save(author: Author) {
        db.save(author)
    }
}