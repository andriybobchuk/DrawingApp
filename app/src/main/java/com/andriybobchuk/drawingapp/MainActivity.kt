package com.andriybobchuk.drawingapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(getName() != null) {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra(Constants.USER_NAME, getName())
            startActivity(intent)
            finish()
        }


        btn_start.setOnClickListener {

            if(et_name.text.toString().isEmpty()) {
                Toast.makeText(this, "Enter your name", Toast.LENGTH_SHORT).show()
            } else {

                saveName(et_name.text.toString())

                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra(Constants.USER_NAME, et_name.text.toString())
                startActivity(intent)
                finish()
            }

        }

    }

    fun saveName(name: String) {
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putString(Constants.USER_NAME, name)
            apply()
        }
    }

    fun getName(): String? {
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE) ?: return null
        val name = sharedPref.getString(Constants.USER_NAME, null)
        return name
    }
}

