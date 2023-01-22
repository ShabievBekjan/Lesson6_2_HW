package com.geektech.lesson6_2_hw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.geektech.lesson6_2_hw.adapter.ImageAdapter
import com.geektech.lesson6_2_hw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var imageList : ArrayList<Int> = arrayListOf()
    private val selectedImages : ArrayList<Int> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fillImage()
        val adapter = ImageAdapter(list = imageList , this::selectedListener , this::deletedListener)
        binding.rv.layoutManager = GridLayoutManager(this , 3)
        binding.rv.adapter = adapter
        initClick()
    }

    private fun deletedListener(uri : Int) {
        selectedImages.remove(imageList[imageList.indexOf(uri)])
    }

    private fun initClick() {
        binding.btnGo.setOnClickListener{
            Intent(applicationContext , SecondActivity::class.java).apply {
                putIntegerArrayListExtra(SELECT_IMAGE , selectedImages)
                startActivity(this)
            }
        }
    }

    private fun selectedListener(uri : Int) {
        selectedImages.add(imageList[imageList.indexOf(uri)])
    }


    private fun fillImage(){
        imageList = arrayListOf(
            R.drawable.bigben,
            R.drawable.bridge,
            R.drawable.mercedes,
            R.drawable.bigben,
            R.drawable.bridge,
            R.drawable.mercedes,
            R.drawable.bigben,
            R.drawable.bridge,
            R.drawable.mercedes,
            R.drawable.bigben,
            R.drawable.bridge,
            R.drawable.mercedes,
            R.drawable.bigben,
            R.drawable.bridge,
            R.drawable.mercedes,
            R.drawable.bigben,
            R.drawable.bridge,
            R.drawable.mercedes,
        )
    }

    companion object {
        const val SELECT_IMAGE = "select_image"
    }
}