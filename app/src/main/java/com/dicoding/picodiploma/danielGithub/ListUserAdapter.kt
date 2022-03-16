package com.dicoding.picodiploma.danielGithub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.picodiploma.danielGithub.databinding.RowUserBinding


class ListUserAdapter(
    private val listUser: List<User>
) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    private lateinit var binding: RowUserBinding

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        binding = RowUserBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ListViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = listUser[position]
        with(binding) {
            tvUsername.text = user.username
            tvFullname.text = user.fullName
            imgPhoto.setImageResource(user.photo)
            root.setOnClickListener {
                onItemClickCallback.onItemClicked(user)
            }
        }
    }

    override fun getItemCount(): Int = listUser.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }
}