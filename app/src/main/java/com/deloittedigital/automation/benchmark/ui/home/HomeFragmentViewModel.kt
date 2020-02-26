package com.deloittedigital.automation.benchmark.ui.home

import androidx.lifecycle.ViewModel
import com.deloittedigital.automation.benchmark.ApiInterface
import com.deloittedigital.automation.benchmark.ui.Movies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragmentViewModel : ViewModel() {

    private val apiInterface = ApiInterface.create().getMovies()
    private var homeAdapter: HomeAdapter = HomeAdapter()

    fun getMovies() {
        apiInterface.enqueue(object : Callback<List<Movies>> {

            override fun onResponse(call: Call<List<Movies>>, response: Response<List<Movies>>) {

                if (!response.body().isNullOrEmpty()) {
                    homeAdapter.setMovieListItems(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<Movies>>, t: Throwable?) {

            }
        })
    }

}