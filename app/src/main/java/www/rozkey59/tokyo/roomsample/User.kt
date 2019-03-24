package www.rozkey59.tokyo.roomsample

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class User {

    @PrimaryKey
    var id: Int = 0

    @ColumnInfo(name= "name")
    var name: String? = null

    var age: Int? = null
}