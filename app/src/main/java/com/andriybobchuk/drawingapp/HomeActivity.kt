package com.andriybobchuk.drawingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        tv_name.text = mUserName

        ll_btn_empty_page.setOnClickListener(this)

        ib_card_1.setOnClickListener { startDrawingActivity(R.drawable.ic_character_one) }
        ib_card_2.setOnClickListener { startDrawingActivity(R.drawable.ic_character_two) }
        ib_card_3.setOnClickListener { startDrawingActivity(R.drawable.ic_character_three) }
        ib_card_4.setOnClickListener { startDrawingActivity(R.drawable.ic_character_four) }
        ib_card_5.setOnClickListener { startDrawingActivity(R.drawable.ic_character_five) }
        ib_card_6.setOnClickListener { startDrawingActivity(R.drawable.ic_character_six) }
        ib_card_7.setOnClickListener { startDrawingActivity(R.drawable.ic_character_seven) }
        ib_card_8.setOnClickListener { startDrawingActivity(R.drawable.ic_character_eight) }
        ib_card_9.setOnClickListener { startDrawingActivity(R.drawable.ic_character_nine) }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ll_btn_empty_page -> {
                startDrawingActivity(-1)
            }
        }
    }

    fun startDrawingActivity(blueprintBackgroundId: Int) {
        val intent = Intent(this, DrawingActivity::class.java)
        intent.putExtra(Constants.BLUEPRINT_BACKGROUND_ID, blueprintBackgroundId)
        startActivity(intent)
        //TODO: Should I remove it?
       // finish()
    }


}