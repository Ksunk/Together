package ru.kom_ic.together.data

data class Memory(

    val id: Long = 0L,
    val title: String = "Test title",
    val text: String = "Test text",
    val creationDate: Long = System.currentTimeMillis()
)