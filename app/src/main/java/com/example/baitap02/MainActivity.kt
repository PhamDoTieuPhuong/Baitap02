package com.example.baitap02

import android.annotation.SuppressLint
import android.os.Bundle

import android.widget.Button

import android.widget.EditText

import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {



    private lateinit var nameEditText: EditText

    private lateinit var ageEditText: EditText

    private lateinit var resultTextView: TextView



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)



        nameEditText = findViewById(R.id.nameEditText)

        ageEditText = findViewById(R.id.ageEditText)

        resultTextView = findViewById(R.id.resultTextView)



        findViewById<Button>(R.id.checkButton).setOnClickListener {

            checkAge()

        }

    }



    @SuppressLint("SetTextI18n")
    private fun checkAge() {

        val name = nameEditText.text.toString().trim()

        val ageString = ageEditText.text.toString().trim()



        if (name.isNotEmpty() && ageString.isNotEmpty()) {

            val age = ageString.toIntOrNull()

            if (age != null) {

                val result = when {

                    age > 65 -> "Người già"

                    age in 6..65 -> "Người lớn"

                    age in 2..5 -> "Trẻ em"

                    else -> "Em bé"

                }

                resultTextView.text = "$name là $result"

            } else {

                resultTextView.text = "Tuổi không hợp lệ"

            }

        } else {

            resultTextView.text = "Vui lòng nhập đầy đủ thông tin"

        }

    }

}