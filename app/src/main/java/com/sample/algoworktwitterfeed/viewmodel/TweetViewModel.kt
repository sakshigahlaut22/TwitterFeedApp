package com.sample.algoworktwitterfeed.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.algoworktwitterfeed.model.TweetModel
import com.sample.algoworktwitterfeed.repository.TweetRepository

class TweetViewModel() : ViewModel() {

    private var tweetRepository: TweetRepository =
        TweetRepository()

    val allTweets: MutableLiveData<List<TweetModel>>?  = tweetRepository.getMutableLiveData()

}