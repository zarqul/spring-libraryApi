package no.zarqul.library.services

import no.zarqul.library.models.User
import no.zarqul.library.repository.UserRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.toList

@Service
class UserService(val db: UserRepository) {
    fun findBooks(): List<User> = db.findAll().toList()

    @OptIn(ExperimentalStdlibApi::class)
    fun findUserById(id: Long): List<User> = db.findById(id).toList()

    fun save(user: User) {
        db.save(user)
    }
}