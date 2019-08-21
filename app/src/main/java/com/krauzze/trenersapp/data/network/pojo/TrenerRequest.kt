package com.krauzze.trenersapp.data.network.pojo

import android.media.Image
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TrenerRequest {

    @field:SerializedName("image")
    @field:Expose
    var image: String? = null

    @field:SerializedName("name")
    @field:Expose
    var name: String? = null

    @field:SerializedName("ampl")
    @field:Expose
    var ampl: String? = null

    @field:SerializedName("price")
    @field:Expose
    var price: String? = null
}