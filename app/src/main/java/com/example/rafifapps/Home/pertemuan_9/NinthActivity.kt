package com.example.rafifapps.Home.pertemuan_9

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rafifapps.databinding.ActivityNinthBinding
import com.google.android.material.chip.Chip

class NinthActivity : AppCompatActivity() {

    // 1. Deklarasikan ViewBinding
    private lateinit var binding: ActivityNinthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 2. Inisialisasi ViewBinding
        binding = ActivityNinthBinding.inflate(layoutInflater)
        setContentView(binding.root) // Ubah ini menggunakan binding.root

        // 3. Terapkan insets ke binding.root agar layout tidak tertutup status bar (Edge-to-Edge)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 4. Terapkan logika Chip dari modul di sini
        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull() // Ambil ID chip yang dipilih
            if (selectedChipId != null) {
                // Temukan chip berdasarkan ID yang dipilih
                val chip = group.findViewById<Chip>(selectedChipId)

                // Tampilkan Toast
                Toast.makeText(this, "Filter: ${chip.text}", Toast.LENGTH_SHORT).show()

                // Lakukan logika filter di sini nantinya
            }
        }
    }
}