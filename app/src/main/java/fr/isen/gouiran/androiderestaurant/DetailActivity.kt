package fr.isen.gouiran.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import fr.isen.gouiran.androiderestaurant.databinding.ActivityDetailBinding
import fr.isen.gouiran.androiderestaurant.model.Items
import fr.isen.gouiran.androiderestaurant.model.Prices

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private  lateinit var item: Items
    private  lateinit var name: String
    private lateinit var  price: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        item = intent.getSerializableExtra("Detail") as Items
        name = item.nameFr.toString()
        val actionBar = supportActionBar
        actionBar?.title = name
        price = item.prices[0].price.toString()

        binding.pricess.text= price
    }
}