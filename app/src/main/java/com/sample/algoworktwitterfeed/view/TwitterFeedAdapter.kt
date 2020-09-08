package com.sample.algoworktwitterfeed.view

import android.R
import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sample.algoworktwitterfeed.databinding.RowFeedBinding
import com.sample.algoworktwitterfeed.model.TweetModel

class TwitterFeedAdapter(private var feeds: ArrayList<TweetModel>): RecyclerView.Adapter<TwitterFeedAdapter.TFViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): TFViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val rowFeedBinding = RowFeedBinding.inflate(layoutInflater, parent, false)
        return TFViewHolder(rowFeedBinding)
    }

    override fun onBindViewHolder(holder: TFViewHolder, position: Int) {
        holder.bind(feeds.get(position))

    }

    override fun getItemCount(): Int {   return feeds.size   }

    fun update(data: ArrayList<TweetModel>){
        feeds.addAll(data)
        notifyDataSetChanged()
    }


    inner class TFViewHolder(val rowFeedBinding: RowFeedBinding) : RecyclerView.ViewHolder(rowFeedBinding.root){

        fun bind(feedItem : TweetModel){

            rowFeedBinding.feedItem = feedItem

            rowFeedBinding.tvName.setText(feedItem.user?.name)
            val text: String? = feedItem.user?.screenName
            rowFeedBinding.tvScreenName.setText(text)
            rowFeedBinding.tvTweet.setText(feedItem.text)
            rowFeedBinding.tvTime.setText(feedItem.createdAt)
            //rowFeedBinding.ivProfile.setImageResource(R.color.transparent)
           /* Log.e("TAG", "url >>>>"+ feedItem.user?.profileImageUrl);
                 Glide.with(rowFeedBinding.ivProfile.context).load(feedItem.user?.profileImageUrl).into(rowFeedBinding.ivProfile);

            rowFeedBinding.ivProfile.setTag(feedItem.user)
            rowFeedBinding.ivMedia.setImageResource(R.color.transparent)
            val mediaUrl: String = mediaUrl(feedItem)*/
            /*if (mediaUrl != null) {

                Log.e("TAG", mediaUrl);

                Glide.with(rowFeedBinding.ivMedia).load(mediaUrl).into(rowFeedBinding.ivMedia);

                rowFeedBinding.ivMedia.setVisibility(View.VISIBLE)
            } else {
                rowFeedBinding.ivMedia.setVisibility(View.GONE)
            }*/
            /*rowFeedBinding.tvRetweetCount.setText(feedItem.retweetCount)
            rowFeedBinding.tvFavoriteCount.setText(feedItem.favoriteCount)*/
        }
    }


    @Nullable
    private fun mediaUrl(tweet: TweetModel): String {
        val entity: TweetModel.Entity? = tweet?.entity
        if (entity != null) {
            val media: List<TweetModel.Media> = entity.media
            if (!media.isEmpty()) {
                return media[0].mediaUrl
            }
        }
        return null.toString()
    }


}
