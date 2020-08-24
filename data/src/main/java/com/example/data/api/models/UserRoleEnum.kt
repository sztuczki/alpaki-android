package com.example.data.api.models

enum class UserRoleEnum(
    val roleId: Long
) {
    ADMIN(7),
    SUPERVISOR(3),
    VOLUNTEER(1),
    NONE(0)
}