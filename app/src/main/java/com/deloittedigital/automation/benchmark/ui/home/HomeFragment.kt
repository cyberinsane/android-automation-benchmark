package com.deloittedigital.automation.benchmark.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.deloittedigital.automation.benchmark.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var viewModel: HomeFragmentViewModel? = null
    private var homeAdapter: HomeAdapter? = null

    companion object {
        fun newInstance() =
            HomeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProvider(this).get<HomeFragmentViewModel>(
                HomeFragmentViewModel::class.java
            )

        viewModel?.getMovies()

        context?.let {
            homeAdapter = HomeAdapter()
            recyclerview.layoutManager = LinearLayoutManager(it)
            recyclerview.adapter = homeAdapter
        }
    }

}