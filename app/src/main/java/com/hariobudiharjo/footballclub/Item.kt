package com.hariobudiharjo.footballclub

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item (val name: String?, val image: Int?,val deskripsi:String?) : Parcelable