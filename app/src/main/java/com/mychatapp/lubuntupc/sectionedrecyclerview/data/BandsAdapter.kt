package com.mychatapp.lubuntupc.sectionedrecyclerview.data

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.afollestad.sectionedrecyclerview.SectionedRecyclerViewAdapter
import com.afollestad.sectionedrecyclerview.SectionedViewHolder
import com.mychatapp.lubuntupc.sectionedrecyclerview.R
import com.mychatapp.lubuntupc.sectionedrecyclerview.model.Metal
import com.mychatapp.lubuntupc.sectionedrecyclerview.model.Rock

/**
 * Created by lubuntupc on 20.12.17.
 */
class BandsAdapter(private var rockList: ArrayList<Rock>,
                   private var metalList: ArrayList<Metal>,
                   private var context: Context): SectionedRecyclerViewAdapter<BandsAdapter.ViewHolder>() {

    override fun getSectionCount(): Int {
        return 2
    }
    override fun getItemCount(section: Int): Int {
        when (section) {
            0 -> return rockList.size
            1 -> return metalList.size
            else -> 0
        }
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, section: Int, relativePosition: Int, absolutePosition: Int) {
        if (section == 0) {
            holder!!.bindRock(rockList[relativePosition])
        } else if (section == 1) {
            holder!!.bindMetal(metalList[relativePosition])
        }
    }



    override fun onBindHeaderViewHolder(holder: ViewHolder?, section: Int, expanded: Boolean) {
        holder!!.sectionTitle.setText(String.format("Section Header %d", section));

    }
    override fun onBindFooterViewHolder(holder: ViewHolder?, section: Int) {

    }

    class ViewHolder(itemView: View): SectionedViewHolder(itemView) {
        var sectionTitle = itemView.findViewById<TextView>(R.id.bandNameTv)

        var rocktV = itemView.findViewById<TextView>(R.id.bandNameTv)
        var metaltV = itemView.findViewById<TextView>(R.id.bandNameTv)

        fun bindRock(rock: Rock) {
            rocktV.text = rock.bandName
        }

        fun bindMetal(metal: Metal) {
            metaltV.text = metal.bandName
        }

    }


}