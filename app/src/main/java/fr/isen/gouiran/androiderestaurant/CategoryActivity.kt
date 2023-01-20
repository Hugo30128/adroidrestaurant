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
import com.google.gson.Gson
import fr.isen.gouiran.androiderestaurant.model.DataResult
import fr.isen.gouiran.androiderestaurant.model.Items
import org.json.JSONObject


class CategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding
    private lateinit var category: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        category = intent.getStringExtra("ActivityName") ?: ""
        val actionBar = supportActionBar
        actionBar?.title = category


        binding.categoryList.layoutManager = LinearLayoutManager(this)

        binding.categoryList.adapter = CustomAdapter(arrayListOf()) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("Detail", it)
            startActivity(intent)
        }
        loadDishesFromAPI()
    }

    private fun loadDishesFromAPI() {
        Volley.newRequestQueue(this)
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val jsonObject = JSONObject()
        jsonObject.put("id_shop", "1")
        val jsonRequest = JsonObjectRequest(Request.Method.POST, url, jsonObject, {
            Log.w("CategoryActivity", "response : $it")
            handleAPIData(it.toString())
        }, {
            Log.w("CategoryActivity", "erreur: $it")
        }
        )
        Volley.newRequestQueue(this).add(jsonRequest)
    }

    private fun handleAPIData(data: String) {
        var dishesResult = Gson().fromJson(data, DataResult::class.java)
        val dishesFiltered = dishesResult.data.firstOrNull() { it.nameFr == category }

        val adapter = binding.categoryList.adapter as CustomAdapter
        adapter.refreshList(dishesFiltered?.items as ArrayList<Items>)
    }
}









