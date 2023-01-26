package fr.isen.gouiran.androiderestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import fr.isen.gouiran.androiderestaurant.model.Items
import com.squareup.picasso.Picasso

internal class CustomAdapter(private var itemsList: ArrayList<Items>, val onItemClickListener:(Items) -> Unit ): RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTextView: TextView = view.findViewById(R.id.itemTextView)
        var price: TextView = view.findViewById(R.id.prices)
        var image: ImageView = view.findViewById(R.id.picture)
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]

        holder.price.text= item.prices[0].price + "€"
        holder.itemTextView.text = item.nameFr

        if (item.images[0].isNotEmpty()){
        Picasso.get().load(item.images[0]).into(holder.image);}

        holder.itemTextView.setOnClickListener {
            onItemClickListener(item)
        }
    }
    override fun getItemCount(): Int {
        return itemsList.size
    }
    fun refreshList(dishesFromAPI: ArrayList<Items>) {
        itemsList = dishesFromAPI
        notifyDataSetChanged()
    }


}