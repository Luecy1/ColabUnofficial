package com.github.luecy1.colabunofficial.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.luecy1.colabunofficial.db.model.Event

@Database(entities = [Event::class], version = 1)
abstract class EventRoomDatabase : RoomDatabase() {

    abstract fun eventDao(): EventDao

    companion object {

        @Volatile
        private var INSTANCE: EventRoomDatabase? = null

        fun getDatabase(context: Context): EventRoomDatabase {

            val tmpInstance = INSTANCE

            if (tmpInstance != null) {
                return tmpInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EventRoomDatabase::class.java,
                    "event_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}

fun eventDatabaseFactory(context: Context):EventRoomDatabase {
    return EventRoomDatabase.getDatabase(context)
}