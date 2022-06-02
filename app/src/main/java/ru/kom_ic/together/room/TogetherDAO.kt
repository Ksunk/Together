package ru.kom_ic.together.room

import androidx.room.*
import ru.kom_ic.together.data.Memory
import ru.kom_ic.together.data.Wish

@Dao
interface TogetherDAO {

    // Memory
    @Insert suspend fun insert(night: Memory)
    @Update suspend fun update(night: Memory)
    @Delete suspend fun delete(night: Memory)
    @Query("SELECT * FROM memories WHERE id = :id") suspend fun getMemoryById(id: Long): Memory
    @Query("SELECT * FROM memories") suspend fun getAllMemories(): List<Memory>

    // Wish
    @Insert suspend fun insert(night: Wish)
    @Update suspend fun update(night: Wish)
    @Delete suspend fun delete(night: Wish)
    @Query("SELECT * FROM wishes WHERE id = :id") suspend fun getWishById(id: Long): Wish
    @Query("SELECT * FROM wishes") suspend fun getAllWishes(): List<Wish>
}