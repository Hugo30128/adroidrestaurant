package fr.isen.gouiran.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val entree = findViewById<Button>(R.id.buttonEntree)
        val plat = findViewById<Button>(R.id.buttonPlats)
        val dessert = findViewById<Button>(R.id.buttonDessert)

        entree.setOnClickListener {
            val button = Intent(applicationContext, CategoryActivity::class.java)
            intent.putExtra("ActivityName", "Entree")
            startActivity(intent);
        }

        plat.setOnClickListener {
            val button = Intent(applicationContext, CategoryActivity::class.java)
            intent.putExtra("ActivityName", "Plats")
            startActivity(intent)
        }
        dessert.setOnClickListener {
            val button = Intent(applicationContext, CategoryActivity::class.java)
            intent.putExtra("ActivityName", "Dessert")
            startActivity(intent)
        }

    }
}