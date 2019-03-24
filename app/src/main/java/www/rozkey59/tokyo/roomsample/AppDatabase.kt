package www.rozkey59.tokyo.roomsample

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [User::class],  version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}