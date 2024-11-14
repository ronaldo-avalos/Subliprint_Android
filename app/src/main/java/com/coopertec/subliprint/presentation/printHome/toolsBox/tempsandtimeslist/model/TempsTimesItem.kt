package com.coopertec.subliprint.presentation.printHome.toolsBox.tempsandtimeslist.model

data class TempsTimesItem(
    val id:Int,
    val imageResId: Int,
    val title: String,
    val temperature: String,
    val time: String,
    val pressure: String
)

