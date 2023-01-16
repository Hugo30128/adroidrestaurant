package fr.isen.gouiran.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import fr.isen.gouiran.androiderestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonEntree.setOnClickListener {
            val button = Intent(applicationContext, CategoryActivity::class.java)
            button.putExtra("ActivityName", "Entree")
            startActivity(button)
        }
        binding.buttonPlats.setOnClickListener {
            val button = Intent(applicationContext, CategoryActivity::class.java)
            button.putExtra("ActivityName", "Plat")
            startActivity(button)
        }
        binding.buttonDessert.setOnClickListener {
            val button = Intent(applicationContext, CategoryActivity::class.java)
            button.putExtra("ActivityName", "Dessert")
            startActivity(button)
        }


    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("Debug", "Home destroyed")
    }
}