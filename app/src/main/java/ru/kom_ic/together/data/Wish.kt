package ru.kom_ic.together.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wishes")
data class Wish(

    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "title") val title: String = "Test title",
    @ColumnInfo(name = "creation_date") val creationDate: Long = System.currentTimeMillis()
)
