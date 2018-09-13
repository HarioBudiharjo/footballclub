package com.hariobudiharjo.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.item_list.*
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity(), AnkoLogger {

    lateinit var tvClub: TextView
    lateinit var tvDes: TextView
    lateinit var ivFlag: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail)

        verticalLayout {

            ivFlag = imageView(R.drawable.img_barca).lparams(width = matchParent) {
                padding = dip(20)
                margin = dip(15)
                width = dip(100)
                height = dip(100)
            }

            tvClub = textView() {
                text = "Bercelona"
            }
            tvDes = textView() {
                text = "Lorem Ipsum"
            }

        }


        val imageClub = intent.getStringExtra("imageku")
        val namaClub: String = intent.getStringExtra("club")
        val deskripsiClub: String = intent.getStringExtra("deskripsi")
        info { "Imageclub " + imageClub }
        tvClub.setText(namaClub)
        tvDes.setText(deskripsiClub)
//        ivFlag.setImageResource(imageClub.toInt())

        Glide.with(this).load(imageClub.toInt()).into(ivFlag)

    }
}
