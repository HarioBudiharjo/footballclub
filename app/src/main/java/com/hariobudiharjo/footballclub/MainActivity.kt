package com.hariobudiharjo.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val list = findViewById<RecyclerView>(R.id.club_list)
        initData()

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RVAdapter(this, items) {
            startActivity(intentFor<DetailActivity>("imageku" to it.image.toString(), "club" to it.name, "deskripsi" to it.deskripsi))
        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val deskripsiClub = resources.getStringArray(R.array.club_deskripsi)

        items.clear()
        for (i in name.indices) {
            info { "Imageclub - " + image.getResourceId(i, 0) }
            items.add(Item(name[i],
                    image.getResourceId(i, 0),
                    deskripsiClub[i]
            )
            )
        }

        //Recycle the typed array
        image.recycle()
    }
}
