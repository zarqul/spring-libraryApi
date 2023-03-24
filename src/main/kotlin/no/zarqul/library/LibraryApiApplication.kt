package no.zarqul.library

import no.zarqul.library.repository.AuthorRepository
import no.zarqul.library.services.AuthorService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LibraryApiApplication

fun main(args: Array<String>) {
	runApplication<LibraryApiApplication>(*args)

}
