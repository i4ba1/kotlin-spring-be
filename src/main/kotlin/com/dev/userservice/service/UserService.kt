
package com.dev.userservice.service

import com.dev.userservice.dto.UserCreateRequest
import com.dev.userservice.dto.UserUpdateRequest
import com.dev.userservice.dto.toEntity
import com.dev.userservice.model.User
import com.dev.userservice.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {
    fun getUsers(): List<User> = userRepository.findUsers()

    fun getDetailUser(id: Long): User = userRepository.findUserById(id)

    fun createNewUser(createUserDto: UserCreateRequest): User {
        val newUser = createUserDto.toEntity()
        return userRepository.save(newUser)
    }

    fun updateUser(userId:Long, userUpdateRequest: UserUpdateRequest): User {
        val updatedUser = userUpdateRequest.toEntity(userId)
        return userRepository.save(updatedUser)
    }

    fun deleteUser(userId:Long) {
        userRepository.findById(userId).orElse(null)
        userRepository.deleteById(userId)
    }

    fun searchUser(email:String, firstName:String, lastName:String):List<User> {
        return userRepository.searchUser(email, firstName, lastName)
    }
}