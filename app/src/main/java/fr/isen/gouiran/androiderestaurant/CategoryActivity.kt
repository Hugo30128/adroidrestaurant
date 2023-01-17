package fr.isen.gouiran.androiderestaurant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.Volley
import fr.isen.gouiran.androiderestaurant.databinding.ActivityCategoryBinding
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONObject

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
        binding.categoryList.adapter = CustomAdapter(arrayListOf()) {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
        loadDishesFromAPI()
    }
    private fun loadDishesFromAPI(){
       Volley.newRequestQueue(this)
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val jsonObject = JSONObject()
        jsonObject.put("id_shop", "1")
        val jsonRequest = JsonObjectRequest(Request.Method.POST, url, jsonObject, {
                                                                                  Log.w("CategoryActivity", "response : $it")
                                                                                  },{
                                                                                  Log.w("CategoryActivity", "erreur: $it")
                                                                                  }
        )
        Volley.newRequestQueue(this).add(jsonRequest)
    }
}







