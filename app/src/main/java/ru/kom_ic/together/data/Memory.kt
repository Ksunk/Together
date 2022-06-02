package ru.kom_ic.together.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memories")
data class Memory(

    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "title") val title: String = "Test title",
    @ColumnInfo(name = "text") val text: String = "Test text",
    @ColumnInfo(name = "creation_date") val creationDate: Long = System.currentTimeMillis()
)
