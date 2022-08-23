package com.example.projectfinal.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TempatWisata (
    val namaTempat: String,
    val gambarTempat: Int,
    val deskripsiTempat: String,
    val hargaTempat: Int,
    val lokasiTempat: String,
    val latTempat: Double,
    val longTempat: Double,
    val videoWisata: String

    ):Parcelable
