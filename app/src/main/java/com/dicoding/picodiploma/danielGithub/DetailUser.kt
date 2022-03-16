package com.dicoding.picodiploma.danielGithub

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.picodiploma.danielGithub.databinding.ActivityDetailUserBinding


class DetailUser : AppCompatActivity(), View.OnClickListener {

    companion object{
        const val USER_EXTRA ="user_extra"
    }

    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.title = "Profile Detail"
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnShareActionProvider:Button = findViewById(R.id.button_share)
        btnShareActionProvider.setOnClickListener(this)

        intent.extras?.getParcelable<User>(USER_EXTRA)?.let { user ->
            with(binding){
                imageView.setImageResource(user.photo)
                tvUsername.text = user.username
                tvFullName.text = user.fullName
                tvCompany.text = user.company
                tvLocation.text = user.location
                tvRepo.text = user.repository.toString()
                tvFollowers.text = user.followers.toString()
                tvFollowing.text = user.following.toString()
            }
        }
    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.button_share ->{
                val sendIntent = Intent(Intent.ACTION_SEND)
                sendIntent.type = "text/plain"
                sendIntent.putExtra(Intent.EXTRA_TEXT, "My application name")
                var shareMessage = "Share profil ini"

                sendIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                val shareIntentTo = Intent.createChooser(sendIntent, "title")
                startActivity(shareIntentTo)




            }
        }
    }


}