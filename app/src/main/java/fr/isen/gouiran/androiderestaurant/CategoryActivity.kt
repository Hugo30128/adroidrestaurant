package fr.isen.gouiran.androiderestaurant

import android.os.Binder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.isen.gouiran.androiderestaurant.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {

    private val listEntree = ArrayList<String>()
    private lateinit var customAdapter: CustomAdapter
    private lateinit var binding: ActivityCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var category = intent.getStringExtra("ActivityName")
        val actionBar = supportActionBar
        actionBar?.title = category

        customAdapter = CustomAdapter(listEntree)
        binding.categoryList.layoutManager = LinearLayoutManager(applicationContext)
        binding.categoryList.adapter = customAdapter
        prepareItems()
        }
    private fun prepareItems() {
        listEntree.add("Item 1")
        listEntree.add("Item 2")
        listEntree.add("Item 3")
        listEntree.add("Item 4")
        listEntree.add("Item 5")
        listEntree.add("Item 6")
        listEntree.add("Item 7")
        listEntree.add("Item 8")
        listEntree.add("Item 9")
        listEntree.add("Item 10")

    }
}







