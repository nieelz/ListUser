package com.dicoding.picodiploma.danielGithub

import android.app.Activity

object DataUser {

    fun getDataUser(activity: Activity): MutableList<User> {
        val listUser = mutableListOf<User>()
        with(activity){
            val username = resources.getStringArray(R.array.username)
            val fullname = resources.getStringArray(R.array.name)
            val photo = resources.obtainTypedArray(R.array.avatar)
            val company = resources.getStringArray(R.array.company)
            val repo = resources.getStringArray(R.array.repository)
            val location = resources.getStringArray(R.array.location)
            val following = resources.getStringArray(R.array.following)
            val followers = resources.getStringArray(R.array.followers)

            username.forEachIndexed { index, s ->
                listUser.add(
                    User(
                        username = s,
                        fullName = fullname[index],
                        photo = photo.getResourceId(index, -1),
                        company = company[index],
                        followers = followers[index].toInt(),
                        following = following[index].toInt(),
                        location = location[index],
                        repository = repo[index].toInt()
                    )
                )
            }
        }
        return listUser
    }
}