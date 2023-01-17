package fr.isen.gouiran.androiderestaurant

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.gouiran.androiderestaurant.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var category = intent.getStringExtra("ActivityName")
        val actionBar = supportActionBar
        actionBar?.title = category

        val dishes = resources.getStringArray(R.array.plats).toList() as ArrayList<String>
        binding.categoryList.layoutManager = LinearLayoutManager(this)
        binding.categoryList.adapter = CustomAdapter(dishes){
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }



        }

}







