package ru.kom_ic.together.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.kom_ic.together.data.Memory
import ru.kom_ic.together.data.Wish

@Database(entities = [Memory::class, Wish::class], version = 1, exportSchema = false)
abstract class TogetherDatabase : RoomDatabase() {

    abstract val togetherDao: TogetherDAO

    companion object {

        @Volatile
        private var INSTANCE: TogetherDatabase? = null

        fun getInstance(context: Context): TogetherDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TogetherDatabase::class.java,
                        "together_info_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}