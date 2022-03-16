package com.dicoding.picodiploma.danielGithub

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.picodiploma.danielGithub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.title = "Github User"
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showRecyclerList(DataUser.getDataUser(this))
    }

    private fun showRecyclerList(dataUser: List<User>) {
        val listAdapter = ListUserAdapter(dataUser)

        binding.rvUser.apply {
            setHasFixedSize(true)
            adapter = listAdapter
        }

        listAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                showSelectedUser(data)
            }
        })

    }

    private fun showSelectedUser(user: User) {
        val moveIntent = Intent(this@MainActivity, DetailUser::class.java)
        moveIntent.putExtra(DetailUser.USER_EXTRA, user)
        startActivity(moveIntent)
    }

}