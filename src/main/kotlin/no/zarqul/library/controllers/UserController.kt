package no.zarqul.library.controllers

import jakarta.validation.Valid
import no.zarqul.library.models.Book
import no.zarqul.library.models.User
import no.zarqul.library.repository.BookRepository
import no.zarqul.library.repository.UserRepository
import no.zarqul.library.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import kotlin.jvm.optionals.getOrNull

@RestController
@RequestMapping("/user")
class UserController(
    private val userRepository: UserRepository,
    private val bookRepository: BookRepository,
    private val userService: UserService) {

    @GetMapping("/")
    fun getAllUsers() : List<User> = userRepository.findAll().toList()

    @PostMapping("/")
    fun createUser(@Valid @RequestBody user: User): User = userRepository.save(user)

    @GetMapping("/{id}")
    fun getUSerById(@PathVariable(value = "id") userId : Long): ResponseEntity<User> {
        return userRepository.findById(userId).map{user ->
            ResponseEntity.ok(user)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/{userId}/collection")
    fun addBookToCollection(@PathVariable(value = "userId") userId : Int, @RequestBody body: Map<String, Long>) {
        val userInst: User = userRepository.findById(userId.toLong()).get()
        body["bookId"]?.let {
            bookRepository.findById(it).map{ book ->
                userInst.addBookToCollection(book)
                userRepository.save(userInst)
                ResponseEntity.ok(userInst)
            }
        }
    }

    @GetMapping("/{userId}/collection")
    fun getUserCollection(@PathVariable(value = "userId") userId: Long): List<Book>? {
         return userRepository.findById(userId).get().getCollection()
    }

    @GetMapping("/{userId}/friends")
    fun getUserFriends(@PathVariable(value = "userId") userId: Long): List<User>? {
        return userRepository.findById(userId).get().getFriends()
    }
}