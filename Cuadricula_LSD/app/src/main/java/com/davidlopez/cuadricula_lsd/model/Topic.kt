package com.davidlopez.cuadricula_lsd.model
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringName: Int,
    val availableCourses: Int,
    @DrawableRes val imageCourse: Int
)
