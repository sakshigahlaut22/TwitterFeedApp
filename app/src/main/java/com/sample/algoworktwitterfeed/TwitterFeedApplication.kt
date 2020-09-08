package com.sample.algoworktwitterfeed

import android.app.Application
import android.content.Context
import com.sample.algoworktwitterfeed.network.TwitterClient

class TwitterFeedApplication : Application() {

        override fun onCreate() {
            super.onCreate()

            context = this
        }

        companion object {
            private var context: Context? = null
            val restClient: TwitterClient
                get() = TwitterClient.getInstance(
                    TwitterClient::class.java,
                    context
                ) as TwitterClient
        }
    }