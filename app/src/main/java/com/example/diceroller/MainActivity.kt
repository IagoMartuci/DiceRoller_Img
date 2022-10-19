package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.diceroller.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Roll.setOnClickListener { rollDice() }
    }

    private fun rollDice(){
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val diceImage = binding.imageView

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()

        val toastMsg = Toast.makeText(this, "Rolou um Dado!", Toast.LENGTH_SHORT)
        toastMsg.show()
    }
}

class Dice (private val numSides: Int){
    fun roll(): Int{
        return(1..numSides).random()
    }
}