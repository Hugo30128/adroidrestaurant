package fr.isen.gouiran.androiderestaurant

import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import fr.isen.gouiran.androiderestaurant.databinding.ActivityDetailBinding
import fr.isen.gouiran.androiderestaurant.model.Items
import org.json.JSONObject


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var item: Items
    private lateinit var name: String
    private lateinit var price: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)



        item = intent.getSerializableExtra("Detail") as Items
        name = item.nameFr.toString()
        val ingredients = item.ingredients

        if (item.images[0].isNotEmpty()) {
            Picasso.get().load(item.images[0]).into(binding.pictureDetail);
        }

        val actionBar = supportActionBar
        actionBar?.title = name
        price = item.prices[0].price.toString()


        binding.pricess.text = price + "€"
        binding.nameDetail.text = name


        val ingredientString = StringBuilder()
        ingredients.forEach { ingredients ->
            ingredientString.append(ingredients.nameFr)
            ingredientString.append(", ")
        }
        binding.ingredient.text = ingredientString


        val prix = item.prices
        val priceString = java.lang.StringBuilder()
        val priceunique = item.prices[0].price?.toDouble()
        var somme = 0
        binding.add.setOnClickListener {
            somme++
            binding.count.text =
                Editable.Factory.getInstance().newEditable(somme.toString())
            if (item.prices.isNotEmpty()) {
                prix.forEach { prix ->
                    priceString.append(prix.price)
                }
                val number = somme * priceunique!!
                binding.bank.text = "Total: " +  number.toString() + "€"
            }

        }


        binding.remove.setOnClickListener {
            if (somme != 0) {
                somme--
                binding.count.text =
                    Editable.Factory.getInstance().newEditable(somme.toString())
                if (item.prices.isNotEmpty()) {
                    prix.forEach { prix ->
                        priceString.append(prix.price + "€")
                    }
                    val number = somme * priceunique!!
                    binding.bank.text = "Total: " + number.toString() + "€"
                }
            }
        }
    }


}


