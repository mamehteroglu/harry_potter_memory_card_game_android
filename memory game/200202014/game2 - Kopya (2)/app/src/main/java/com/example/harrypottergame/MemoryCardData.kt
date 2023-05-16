package com.example.harrypottergame

import android.graphics.drawable.Drawable

data class MemoryCardData(var isFlipped :Boolean? = false,var isMatched : Boolean? = false,var photoStringBase64 : String?,var houseName:String?,var housePoint:Long?,var wizardPoint:Long?)
//,var house:String?,var point:Int?