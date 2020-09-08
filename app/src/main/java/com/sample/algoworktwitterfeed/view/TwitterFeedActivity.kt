package com.sample.algoworktwitterfeed.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.algoworktwitterfeed.R
import com.sample.algoworktwitterfeed.TwitterFeedApplication
import com.sample.algoworktwitterfeed.databinding.ActivityTwitterFeedBinding
import com.sample.algoworktwitterfeed.model.TweetModel
import com.sample.algoworktwitterfeed.network.TwitterClient
import com.sample.algoworktwitterfeed.viewmodel.TweetViewModel


class TwitterFeedActivity : AppCompatActivity() {

    private lateinit var activityFeedBinding: ActivityTwitterFeedBinding
    private var feedViewModel: TweetViewModel? = null
    private var feedAdapter: TwitterFeedAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityFeedBinding = DataBindingUtil.setContentView(this, R.layout.activity_twitter_feed);

        activityFeedBinding.viewTweets.layoutManager = LinearLayoutManager(this)

        feedViewModel = ViewModelProviders.of(this).get(TweetViewModel::class.java)

        feedAdapter = TwitterFeedAdapter(arrayListOf<TweetModel>())  //////// feeds are null right now
        activityFeedBinding.viewTweets.adapter = feedAdapter
        getAllFeeds()

    }

    private fun getAllFeeds() {

        feedViewModel?.allTweets!!.observe(this, object : Observer<List<TweetModel?>?> {
            override fun onChanged(@Nullable mTweet: List<TweetModel?>?) {
                feedAdapter!!.update(mTweet as ArrayList<TweetModel>)
                activityFeedBinding.loadBar!!.visibility = View.GONE
            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
