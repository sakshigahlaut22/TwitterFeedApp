package com.sample.algoworktwitterfeed.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import com.codepath.oauth.OAuthLoginActionBarActivity
import com.sample.algoworktwitterfeed.R
import com.sample.algoworktwitterfeed.network.TwitterClient

class LoginActivity : OAuthLoginActionBarActivity<TwitterClient>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    // Inflate the menu; this adds items to the action bar if it is present.
    // OAuth authenticated successfully, launch primary authenticated activity
    // i.e Display application "homepage"

    override fun onLoginSuccess() {

        Log.e("TAG", "success")
        val i = Intent(this, TwitterFeedActivity::class.java)
        startActivity(i)
    }

    // OAuth authentication flow failed, handle the error
    // i.e Display an error dialog or toast
    override fun onLoginFailure(e: Exception) {
        Log.e("TAG", "error"+ e.message)

        e.printStackTrace()
    }

    fun loginToRest(view: View?) {
        client.connect()
    }
}