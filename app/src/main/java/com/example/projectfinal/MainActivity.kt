package com.example.projectfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectfinal.adapter.TempatWisataAdapter
import com.example.projectfinal.model.TempatWisata
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

class MainActivity : AppCompatActivity(), TempatWisataAdapter.OnItemClickCallback {
    val tempatWisataList = generateTempatWisataList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvTempatWisata : RecyclerView = findViewById(R.id.rv_tempat_wisata)
        rvTempatWisata.adapter = TempatWisataAdapter(tempatWisataList, this)
        rvTempatWisata.layoutManager = LinearLayoutManager(this)

        val btnProfile : ImageView = findViewById(R.id.btn_profile)
        btnProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }


    }

    fun generateTempatWisataList(): ArrayList<TempatWisata>{
            val tempatWisataList = ArrayList<TempatWisata>();

            tempatWisataList.add(TempatWisata(
                "Labuan Bajo",
                R.drawable.labuanbajo,
                "Labuan Bajo adalah salah satu dari lima Destinasi Super Prioritas yang sedang dikembangkan di Indonesia. Destinasi ini menyimpan keindahan alam yang menakjubkan dan hewan purba yang mendunia. Mulai dari hewan endemik komodo di Taman Nasional Komodo, deretan pulau eksotis, keragaman hayati bawah laut, hingga pantai, semua bisa Sobat Pesona temukan di Labuan Bajo.",
                5000,
                "Kab. Manggarai Barat, Nusa Tenggara Timur",
                -8.453848, 119.872842,
                "kchKAaTq3po"
            ))

            tempatWisataList.add(TempatWisata(
                "Gili Trawangan",
                R.drawable.trawangan,
                "Di Gili Trawangan, kamu pun bisa melakukan beragam aktivitas seru, salah satunya adalah snorkeling. Manjakan mata dengan keindahan bawah laut berupa berbagai ikan cantik dan terumbu karang berwarna-warni. Alternatif lain jika tak ingin bermain air, kamu bisa menjajaki penjual suvenir di sekitar atau mengepang rambut dengan jasa yang ditawarkan warga setempat.",
                5000,
                "Kab. Lombok Utara, Nusa Tenggara Barat",
                -8.348292, 116.038434,
                "oRuOuGJ10Tg"
            ))

            tempatWisataList.add(TempatWisata(
                "Nusa Penida",
                R.drawable.penida,
                "Sebagian besar daratan di Nusa Penida berada di atas tebing, serta pemandangan tebing di bagian selatan pulau Nusa Penida menghadap ke Samudra Hindia. Sehingga pemandangan laut dari atas tebing terlihat sangat indah terutama di sore hari. Lokasi populer untuk melihat pemandangan indah Samudra Hindia dari atas tebing seperti, Bukit Pantai Kelingking Nusa Penida, Banah Cliff, dan Saren Cliff.",
                5000,
                "Kab. Klungkung, Bali",
                -8.727807, 115.544423,
                "AjU5j6K94uE"
            ))

            tempatWisataList.add(TempatWisata(
                "Taman Nasional Bunaken",
                R.drawable.bunaken,
                "Pulau Bunaken dapat di tempuh dengan kapal cepat (speed boat) atau kapal sewaan dengan perjalanan sekitar 30 menit dari pelabuhan kota Manado. Taman laut Bunaken memiliki 12 titik selam yang paling kerap dikunjungi penyelam dan pecinta keindahan pemandangan bawah laut.",
                5000,
                "Manado, Sulawesi Utara",
                1.675843, 124.755642,
                "GSJ0pcPucJI"
            ))

            tempatWisataList.add(TempatWisata(
                "Raja Ampat",
                R.drawable.rajaampat,
                "Tak hanya keindahan bawah lautnya yang luar biasa, pemandangan di atas permukaan juga tak kalah memesona. Panorama deretan pulau-pulau batu di tengah gradasi air biru terlihat begitu surgawi saat dilihat dari atas bukit.",
                5000,
                "Kab. Raja Ampat, Papua Barat",
                -1.091515, 130.877859,
                "UJiVARkYs0c"
            ))

            tempatWisataList.add(TempatWisata(
                "Puncak Mahameru - Semeru",
                R.drawable.mahameru,
                "Gunung Semeru merupakan gunung tertinggi di Pulau Jawa, dengan puncaknya Mahameru, 3.676 meter dari permukaan laut. Gunung ini juga sering disebut atap pulau Jawa.",
                5000,
                "Kab. Malang, Jawa Timur",
                -8.100014, 112.916685,
                "D2YLWJ9UA7w"
            ))

            tempatWisataList.add(TempatWisata(
                "Sunrise Bromo",
                R.drawable.bromo,
                "Salah satu spot terbaik untuk menikmati eksotika itu berada di bukit cinta. Sejak pagi buta, para wisatawan sudah menunggu terbitnya matahari atau sunrise Gunung Bromo. Salah satu spot terbaik untuk melihat sunrise berada di bukit cinta atau bukit penanjakan satu.",
                5000,
                "Kab. Pasuruan, Jawa Timur",
                -8.100014, 112.916685,
                "BnyFVFAgdKc"
            ))

            return tempatWisataList
        }

    override fun onItemClicked(tempatWisata: TempatWisata) {
        val myIntent = Intent (this, DetailWisataActivity::class.java)
        myIntent.putExtra("DATA_WISATA", tempatWisata)
        startActivity(myIntent)
    }
}