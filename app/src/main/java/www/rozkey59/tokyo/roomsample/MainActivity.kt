package www.rozkey59.tokyo.roomsample

import android.arch.lifecycle.Observer
import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.concurrent.thread
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val label = findViewById<TextView>(R.id.label)
        val saveButton = findViewById<Button>(R.id.save_button)
        val deleteButton = findViewById<Button>(R.id.delete_button)
        val showButton = findViewById<Button>(R.id.show_button)

        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "User").build()


        val defaultUser = User()
        defaultUser.id = Random(1000000).nextInt()
        defaultUser.name = "Initial"
        defaultUser.age = 24
        var count = 0

        saveButton.setOnClickListener {
            count++
            val user = defaultUser
            user.id = defaultUser.id + count
            defaultUser.name = "Initial::$count"
            defaultUser.age = 24 + count

            thread {
                db.userDao().insert(user)
            }
        }

        deleteButton.setOnClickListener {
            thread {
                db.userDao().delete(defaultUser)
            }
        }

        showButton.setOnClickListener {
            db.userDao().getUser().observe(this@MainActivity, Observer<List<User>> { users ->
                if (users != null) {
                    label.text = users[1].name
                }
            })
        }
    }
}
