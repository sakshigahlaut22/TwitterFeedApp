package com.sample.algoworktwitterfeed.model

import java.io.Serializable


data class TweetModel(var text: String?,  var id: Long , var createdAt: String? , var user: User? , var entity: Entity? ,
                      var retweetCount: Int , var favoriteCount: Int): Serializable{

    data class Media(var id: Long , val mediaUrl: String , val url: String? = null)

    data class Entity(var media : List<Media>)

    data class User(var name: String? ,
                    val id: Long = 0 ,
                    val createdAt: String?,
                    var screenName: String?, var profileImageUrl: String? ,
                    var profileBackgroundImageUrl: String?,
                    var profileBannerUrl: String?,
                    var tagline: String? = null,
                    var followersCount: Int ,
                    var followingCount: Int = 0)

}