package com.hmei.kanban

import android.R
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife


class MainActivity : AppCompatActivity(), Listener {
    @BindView(R.id.rvTop)
    var rvTop: RecyclerView? = null

    @BindView(R.id.rvBottom)
    var rvBottom: RecyclerView? = null

    @BindView(R.id.tvEmptyListTop)
    var tvEmptyListTop: TextView? = null

    @BindView(R.id.tvEmptyListBottom)
    var tvEmptyListBottom: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        initTopRecyclerView()
        initBottomRecyclerView()
        tvEmptyListTop!!.visibility = View.GONE
        tvEmptyListBottom!!.visibility = View.GONE
    }

    private fun initTopRecyclerView() {
        rvTop!!.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.HORIZONTAL, false
        )
        val topList: MutableList<String> = ArrayList()
        topList.add("A")
        topList.add("B")
        val topListAdapter = ListAdapter(topList, this)
        rvTop!!.adapter = topListAdapter
        tvEmptyListTop!!.setOnDragListener(topListAdapter.getDragInstance())
        rvTop!!.setOnDragListener(topListAdapter.getDragInstance())
    }

    private fun initBottomRecyclerView() {
        rvBottom!!.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.HORIZONTAL, false
        )
        val bottomList: MutableList<String> = ArrayList()
        bottomList.add("C")
        bottomList.add("D")
        val bottomListAdapter = ListAdapter(bottomList, this)
        rvBottom!!.adapter = bottomListAdapter
        tvEmptyListBottom!!.setOnDragListener(bottomListAdapter.getDragInstance())
        rvBottom!!.setOnDragListener(bottomListAdapter.getDragInstance())
    }

    fun setEmptyListTop(visibility: Boolean) {
        tvEmptyListTop.setVisibility(if (visibility) View.VISIBLE else View.GONE)
        rvTop.setVisibility(if (visibility) View.GONE else View.VISIBLE)
    }

    fun setEmptyListBottom(visibility: Boolean) {
        tvEmptyListBottom.setVisibility(if (visibility) View.VISIBLE else View.GONE)
        rvBottom.setVisibility(if (visibility) View.GONE else View.VISIBLE)
    }
}
