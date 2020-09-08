package com.sample.algoworktwitterfeed.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonParser
import com.loopj.android.http.JsonHttpResponseHandler
import com.sample.algoworktwitterfeed.TwitterFeedApplication
import com.sample.algoworktwitterfeed.model.TweetModel
import com.sample.algoworktwitterfeed.network.TwitterClient
import cz.msebera.android.httpclient.Header
import org.json.JSONArray
import org.json.JSONObject


class TweetRepository {

    private var mmTweetModelmist: ArrayList<TweetModel> = ArrayList()
    private var mutableLiveData: MutableLiveData<List<TweetModel>> = MutableLiveData<List<TweetModel>>()

    private var client: TwitterClient? = TwitterFeedApplication.restClient

    fun getMutableLiveData(): MutableLiveData<List<TweetModel>>? {

        client!!.getHomeTimeline(null , object :JsonHttpResponseHandler(){

            override fun onSuccess(statusCode: Int, headers: Array<Header>, response: JSONArray?) {

                if (response != null) {
                    Log.e("TAG","success repo >>"+ response.toString())

                    val json: JsonArray = JsonParser().parse(response.toString()).getAsJsonArray()


                        val gson = GsonBuilder().create()
                        for (i in 0..json.size() - 1) {
                            try {
                                val jsonobj = JsonParser().parse(json[i].toString()).asJsonObject
                                val responseModel: TweetModel = gson.fromJson(jsonobj, TweetModel::class.java)
                                mmTweetModelmist.add(responseModel)
                            } catch (ex: Exception) {
                            }
                        }
                        mutableLiveData.setValue(mmTweetModelmist)

                }
            }
            override fun onFailure(statusCode: Int, headers: Array<Header>, throwable: Throwable, errorResponse: JSONObject) {
                // swipeContainer.setRefreshing(false)
                Log.e("TAG", "error repo >>"+ errorResponse.toString())

            }
        })
        return mutableLiveData
    }

}