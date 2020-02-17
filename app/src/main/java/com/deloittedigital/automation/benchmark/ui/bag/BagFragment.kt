package com.deloittedigital.automation.benchmark.ui.bag

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.deloittedigital.automation.benchmark.R

class BagFragment : Fragment(R.layout.fragment_bag) {

    companion object {
        fun newInstance() =
            BagFragment()
    }

    var adapter: ListAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter =
            ListAdapter(context!!)
    }

}