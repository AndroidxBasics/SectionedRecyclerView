package com.mychatapp.lubuntupc.sectionedrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.mychatapp.lubuntupc.sectionedrecyclerview.data.BandsAdapter
import com.mychatapp.lubuntupc.sectionedrecyclerview.model.Rock
import kotlinx.android.synthetic.main.activity_main.*
import com.google.common.collect.Lists.newArrayList
import com.mychatapp.lubuntupc.sectionedrecyclerview.model.Metal

class MainActivity : AppCompatActivity() {

    var rockList: ArrayList<Rock>? = null
    var metalList: ArrayList<Metal>? = null

    var adapter: BandsAdapter? = null
    var layoutManager: RecyclerView.LayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rockList = newArrayList<Rock>(

                Rock("Linkin Park"),
                Rock("Papa Roach")

        )
        metalList = newArrayList<Metal>(

                Metal("Metallica"),
                Metal("Slayer"),
                Metal("Iron Maiden")

        )


        adapter = BandsAdapter(rockList!!, metalList!!, this)
        adapter!!.shouldShowFooters(false);

        layoutManager = LinearLayoutManager(this)

        recyclerViewId.adapter = adapter
        recyclerViewId.layoutManager = layoutManager

        adapter!!.notifyDataSetChanged()

    }


}
