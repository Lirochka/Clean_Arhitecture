package com.example.cleanarhitecture.data.storage

import com.example.cleanarhitecture.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}