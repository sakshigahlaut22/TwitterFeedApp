package com.sample.algoworktwitterfeed.network;

import android.content.Context;
import androidx.annotation.Nullable;
import com.codepath.oauth.OAuthBaseClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.TwitterApi;

public class TwitterClient extends OAuthBaseClient {
	private static final Class<? extends Api> REST_API_CLASS = TwitterApi.class;
	private static final String REST_URL = "https://api.twitter.com/1.1";

	private static final String REST_CONSUMER_KEY = "heCyOJvQ584gzVS2OyFbIHaXk";
	private static final String REST_CONSUMER_SECRET = "tDaEmw1nnk1HifNUv3d6qa5MVmQoEandLiZ3wgAInHv8D1zqRT";
	private static final String REST_CALLBACK_URL = "http://www.twitter.com";


	public TwitterClient(Context context) {
		super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
	}

	public void getHomeTimeline(@Nullable Long maxId, AsyncHttpResponseHandler handler) {
		String apiUrl = getApiUrl("statuses/home_timeline.json");

		RequestParams params = new RequestParams();
		params.put("count", 25);
		params.put("since_id", 1);
		if (maxId != null) {

			params.put("max_id", maxId - 1);
		}

		client.get(apiUrl, params, handler);
	}

}
