package ru.kom_ic.together.data

data class Wish(

    val id: Long = 0L,
    val title: String = "Test title",
    val creationDate: Long = System.currentTimeMillis()
)