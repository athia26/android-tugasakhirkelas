package com.example.projectfinal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectfinal.R
import com.example.projectfinal.model.TempatWisata

class TempatWisataAdapter (val tempatWisataList:ArrayList<TempatWisata>, val onItemClickCallback: OnItemClickCallback ): RecyclerView.Adapter<TempatWisataAdapter.TempatWisataViewHolder>() {

    class TempatWisataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val namaTempat: TextView = itemView.findViewById(R.id.tv_nama_tempat)
        val imageView: ImageView = itemView.findViewById(R.id.img_tempat)
        val lokasiTempat: TextView = itemView.findViewById(R.id.tv_lokasi_tempat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TempatWisataViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.tempat_wisata_item,parent,false)
        return TempatWisataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TempatWisataViewHolder, position: Int) {
        val tempatWisata : TempatWisata = tempatWisataList [position]

        holder.namaTempat.text = tempatWisata.namaTempat
        holder.imageView.setImageResource(tempatWisata.gambarTempat)
        holder.lokasiTempat.text = tempatWisata.lokasiTempat

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(tempatWisata) }

    }

    override fun getItemCount(): Int {
        return tempatWisataList.size
    }

    interface OnItemClickCallback{
        fun onItemClicked (tempatWisata: TempatWisata)
    }
}