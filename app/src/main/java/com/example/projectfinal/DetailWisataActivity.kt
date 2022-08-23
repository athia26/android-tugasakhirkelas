package com.example.projectfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import com.example.projectfinal.model.TempatWisata
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class DetailWisataActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var tempatWisata: TempatWisata
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_wisata)

        tempatWisata= intent.getParcelableExtra("DATA_WISATA")!!

        supportActionBar?.title = tempatWisata.namaTempat
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val namaTempat: TextView = findViewById(R.id.tv_nama_tempat)
        val gambarTempat: ImageView = findViewById(R.id.img_tempat)
        val deskripsiTempat: TextView = findViewById(R.id.tv_deskripsi_tempat)
        val lokasiTempat: TextView = findViewById(R.id.tv_lokasi_tempat)


        namaTempat.text = tempatWisata.namaTempat
        gambarTempat.setImageResource(tempatWisata.gambarTempat)
        deskripsiTempat.text = tempatWisata.deskripsiTempat
        lokasiTempat.text = tempatWisata.lokasiTempat

        val maps = supportFragmentManager.findFragmentById(R.id.map_wisata) as SupportMapFragment
        maps.getMapAsync(this)

        val youtubePlayer: YouTubePlayerView = findViewById(R.id.yp_player)
        lifecycle.addObserver(youtubePlayer)

        youtubePlayer.addYouTubePlayerListener(object: AbstractYouTubePlayerListener(), YouTubePlayerListener{
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val youtubeId = tempatWisata.videoWisata
                youTubePlayer.cueVideo(youtubeId, 0f)
            }
        })

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val koordinat = LatLng (tempatWisata.latTempat, tempatWisata.longTempat)
        mMap.addMarker(MarkerOptions().position(koordinat).title("Marker"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(koordinat))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(koordinat, 10f))
    }
}