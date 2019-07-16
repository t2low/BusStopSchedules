package com.tappli.bustimetable.presentation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tappli.bustimetable.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class BusStopActivity : AppCompatActivity() {

    private lateinit var viewModel: BusStopViewModel
    private val adapter = GroupAdapter<ViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolBar)

        busStopListView.adapter = adapter
        viewModel = ViewModelProviders.of(this).get(BusStopViewModel::class.java)
        viewModel.busStopList.observe(this, Observer {
            adapter.update(it.map { busStop -> BusStopItem(busStop) })
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.bus_stop_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.itemId) {
        R.id.reverseDestination -> {
            viewModel.toggleDestination()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }

    }
}
