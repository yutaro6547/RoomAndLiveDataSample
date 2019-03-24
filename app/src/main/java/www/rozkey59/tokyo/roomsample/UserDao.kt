package www.rozkey59.tokyo.roomsample

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getUser(): LiveData<List<User>>

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)
}