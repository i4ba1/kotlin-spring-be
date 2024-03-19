package com.dev.userservice.controller

import com.dev.userservice.dto.UserCreateRequest
import com.dev.userservice.dto.UserUpdateRequest
import com.dev.userservice.model.User
import com.dev.userservice.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class UserController(val userService: UserService) {

    @GetMapping("/getUsers")
    fun getUsers(): List<User> = userService.getUsers()

    @GetMapping("/getDetailUser/{id}")
    fun getDetailUser(@PathVariable("id") userId: Long): User =
        userService.getDetailUser(userId)

    @PostMapping("/createNew")
    fun createEmployee(@RequestBody payload: UserCreateRequest): User = userService.createNewUser(payload)

    @PutMapping("/updateEmployee/{id}")
    fun updateEmployeeById(@PathVariable("id") userId: Long, @RequestBody payload: UserUpdateRequest):
            Any {
        return ResponseEntity.ok(userService.updateUser(userId, payload))
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    fun deleteEmployeesById(@PathVariable("id") employeeId: Long): Any =
        userService.deleteUser(employeeId)

    @GetMapping("/searchUser/{q}")
    fun deleteEmployeesById(@PathVariable("q") query:String): Any =
        userService.searchUser(query, query, query)
}