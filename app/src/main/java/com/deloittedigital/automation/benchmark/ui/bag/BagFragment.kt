package com.deloittedigital.automation.benchmark.ui.bag

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.deloittedigital.automation.benchmark.R
import com.deloittedigital.automation.benchmark.ui.ShareDataHolder
import kotlinx.android.synthetic.main.fragment_bag.*

class BagFragment : Fragment(R.layout.fragment_bag) {

    companion object {
        fun newInstance() =
            BagFragment()
    }

    var adapter: ListAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cards = ShareDataHolder.fetchUserCardData(ShareDataHolder.getLoggedInUser())
        adapter = ListAdapter(context!!, cards)
        listview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        listview.adapter = adapter
        listview.isNestedScrollingEnabled = false
        adapter?.notifyDataSetChanged()
        checkout.setOnClickListener {
            val builder = AlertDialog.Builder(activity)
            builder.setTitle(getString(R.string.proceed_to_checkout))
            builder.setPositiveButton(getString(R.string.okay)) { _, _ ->
                Toast.makeText(
                    context,
                    getString(R.string.proceeding_to_checkout),
                    Toast.LENGTH_SHORT
                ).show()

            }
            builder.setNegativeButton(getString(R.string.cancel)) { _, _ ->
                Toast.makeText(context, getString(R.string.stay_in_bag), Toast.LENGTH_SHORT).show()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }


}