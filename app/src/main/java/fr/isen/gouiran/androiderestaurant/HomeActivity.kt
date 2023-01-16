package fr.isen.gouiran.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val action = findViewById<Button>(R.id.buttonEntree)
        action.setOnClickListener{
           //Toast.makeText( context: this; text = "Hello ISEN M1"; Toast.LENGTH_SHORT).show()
            Snackbar.make(it, "Hello ISEN M1", Snackbar.LENGTH_LONG).show()
        }
    }
}