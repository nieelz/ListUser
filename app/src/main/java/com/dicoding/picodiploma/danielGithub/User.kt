package com.dicoding.picodiploma.danielGithub

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val username: String,
    val fullName: String,
    val photo: Int,
    val company: String,
    val repository: Int,
    val location: String,
    val following: Int,
    val followers: Int,
) : Parcelable
