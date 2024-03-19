package com.dev.userservice.repository

import com.dev.userservice.model.User
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository:CrudRepository<User, Long> {
    @Cacheable("findUserById")
    @Query("select u from User u where u.id = :id")
    fun findUserById(@Param("id") id: Long):User

    @Cacheable("findUsers")
    @Query("select u from User u")
    fun findUsers():List<User>

    @Cacheable("searchUser")
    @Query("select u from User u where u.email like %:email% or u.firstName like %:firstName% or u.lastName like %:lastName%")
    fun searchUser(@Param("email") email:String, @Param("firstName") firsName:String,
                   @Param("lastName") lastName:String):List<User>
}