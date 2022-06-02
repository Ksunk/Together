package ru.kom_ic.together

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.kom_ic.together.data.Wish
import ru.kom_ic.together.room.TogetherDAO
import ru.kom_ic.together.room.TogetherDatabase
import java.io.IOException

class TogetherDatabaseTest {
    @RunWith(AndroidJUnit4::class)
    class TogetherDatabaseTest {

        private lateinit var togetherDAO: TogetherDAO
        private lateinit var db: TogetherDatabase

        @Before
        fun createDb() {
            val context = InstrumentationRegistry.getInstrumentation().targetContext
            // Using an in-memory database because the information stored here disappears when the
            // process is killed.
            db = Room.inMemoryDatabaseBuilder(context, TogetherDatabase::class.java)
                // Allowing main thread queries, just for testing.
                .allowMainThreadQueries()
                .build()
            togetherDAO = db.togetherDao
            assertNotNull(db)
            assertNotNull(togetherDAO)
            println("ALl is ok")
        }

        @After
        @Throws(IOException::class)
        fun closeDb() {
            db.close()
        }

        @Test
        fun test(){
            val wish = Wish()
            runBlocking {
                db.togetherDao.insert(wish)
                val actualWish = db.togetherDao.getAllWishes()[0]
                assertEquals(actualWish.title, "Test title")
            }
        }
    }
}