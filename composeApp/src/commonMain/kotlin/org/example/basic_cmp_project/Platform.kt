package org.example.basic_cmp_project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform