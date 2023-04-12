package no.zarqul.library.repository

import no.zarqul.library.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {


    @Query(value = "SELECT first_name, last_name, id FROM users WHERE id IN (SELECT user_id FROM book_collection WHERE book_id = :bookId)", nativeQuery = true)
    fun findOwnerByBookId(
        @Param("bookId") bookId: Int
    ): List<User>
}