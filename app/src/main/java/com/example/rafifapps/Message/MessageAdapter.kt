package com.example.rafifapps.Message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.rafifapps.databinding.ItemMessageBinding
import com.google.android.material.snackbar.Snackbar

class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemMessageBinding
        val view: View

        if (convertView == null) {
            binding = ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
            view = binding.root
            view.tag = binding
        } else {
            binding = convertView.tag as ItemMessageBinding
            view = convertView
        }

        val message = messages[position]

        // Load gambar avatar menggunakan Glide
        Glide.with(context)
            .load(message.avatarUrl)
            .into(binding.avatarImg)

        binding.textSender.text = message.senderName
        binding.textMessage.text = message.messageText

        // ==========================================
        // TAHAP 8: Terapkan OnClick pada setiap item
        // ==========================================
        view.setOnClickListener {
            Snackbar.make(
                parent, // Parent view dari ListView
                "Pesan dari ${message.senderName}: ${message.messageText}",
                Snackbar.LENGTH_SHORT
            ).show()
        }
        // ==========================================

        return view
    }
}