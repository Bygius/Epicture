package com.project.epicture.api

import android.text.BoringLayout

interface ImgurModels {
    data class AccountSettingsData (
        var account_url: String,
        var email: String,
        var avatar: String,
        var cover: String,
        var public_images: Boolean,
        var profil_images: String,
        var album_privacy: Boolean,
        var pro_expiration: Boolean,
        var accepted_gallery_terms: Boolean,
        var active_emails: List<String>,
        var messaging_enabled: Boolean,
        var comment_replies: Boolean,
        var blocked_users: List<String>,
        var show_mature: Boolean,
        var newsletter_subscribed: Boolean,
        var first_party: Boolean
    )
    data class ResponseAccountSettings (
        var data: AccountSettingsData,
        var success: Boolean,
        var status: Int
    )
    data class AccountImagesData (
        var id: String,
        var title: String,
        var description: String,
        var datetime: Int,
        var type: String,
        var animated: Boolean,
        var width: Int,
        var height: Int,
        var size: Int,
        var views: Int,
        var bandwidth: Int,
        var vote: String,
        var favorite: Boolean,
        var nsfw: String,
        var section: String,
        var account_url: String,
        var account_id: Int,
        var is_ad: Boolean,
        var in_most_viral: Boolean,
        var has_sound: Boolean,
        var tags: List<String>,
        var ad_type: Int,
        var ad_url: String,
        var edited: String,
        var in_gallery: String,
        var deletehash: String,
        var name: String,
        var link: String
    )
    data class ResponseAccountImages (
        var data: List<AccountImagesData>,
        var success: Boolean,
        var status: Int
    )
    data class ResponseImageData (
        var id: String,
        var deletehash: String,
        var account_id: Int,
        var account_url: String,
        var ad_type: Int,
        var ad_url: String,
        var title: String,
        var description: String,
        var name: String,
        var type: String,
        var width: Int,
        var height: Int,
        var size: Int,
        var views: Int,
        var section: String,
        var vote: String,
        var bandwidth: Int,
        var animated: Boolean,
        var favorite: Boolean,
        var in_gallery: String,
        var in_most_viral: Boolean,
        var has_sound: Boolean,
        var is_ad: Boolean,
        var nsfw: String,
        var link: String,
        var tags: List<String>,
        var datetime: Int,
        var mp4: String,
        var hls: String
    )

    data class ResponseImage (
        var data: ResponseImageData,
        var success: Boolean,
        var status: Int
    )

    data class ResponseAccountAvatarData (
        var avatar: String,
        var avatar_name: String
    )
    data class ResponseAccountAvatar (
        var data: ResponseAccountAvatarData,
        var success: Boolean,
        var status: Int
    )
    data class ResponseAccountFavoritesData (
        var id: String,
        var title: String,
        var description: String,
        var cover: String,
        var cover_width: Int,
        var cover_height: Int,
        var width: Int,
        var height: Int,
        var account_url: String,
        var account_id: Int,
        var privacy: String,
        var views: Int,
        var link: String,
        var ups: Int,
        var downs: Int,
        var points: Int,
        var score: Int,
        var is_album: Boolean,
        var vote: String,
        var favorite: Boolean,
        var nsfw: Boolean,
        var section: String,
        var comment_count: Int,
        var favorite_count: Int,
        var topic: String,
        var topic_id: String,
        var image_count: Int,
        var datetime: Int,
        var in_gallery: Boolean,
        var in_most_viral: Boolean,
        //var tags: List<String>,
        //var images: String,
        var has_sound: Boolean,
        var animated: Boolean,
        var type: String,
        var size: Int,
    )

    data class ResponseAccountFavorites (
        var data: List<ResponseAccountFavoritesData>,
        var success: Boolean,
        var status: Int
    )

    data class Tags (
        var name: String,
        var display_name: String,
        var followers: Int,
        var total_items: Int,
        var followin: Boolean,
        var is_whitelisted: Boolean,
        var background_hash: String,
        var thumbnail_hash: String,
        var accent: String,
        var background_is_animated: Boolean,
        var thumbnail_is_animated: Boolean,
        var is_promoted: Boolean,
        var description: String,
        var logo_hash: String,
        var logo_destination_url: String,
    )

    data class Image (
        var id: String,
        var title: String,
        var description: String,
        var datetime: Int,
        var type: String,
        var animated: Boolean,
        var width: Int,
        var height: Int,
        var size: Int,
        var views: Int,
        var bandwidth: String,
        var vote: String,
        var favorite: Boolean,
        var nsfw: String,
        var section: String,
        var account_url: String,
        var account_id: Int,
        var is_ad: Boolean,
        var in_most_viral: Boolean,
        var has_sound: Boolean,
        var tags: List<Tags>,
        var ad_type: Int,
        var ad_url: String,
        var edited: String,
        var in_gallery: Boolean,
        var link: String,
        var comment_count: String,
        var favorite_count: String,
        var ups: String,
        var downs: String,
        var points: String,
        var score: String
    )
    data class AdConfig (
        var safeFlags: List<String>,
        var highRiskFlags: List<String>,
        var unsafeFlags: List<String>,
        var wallUnsafeFlags: List<String>,
        var showsAds: Boolean
    )
    
    data class ResponseSearchData (
        var id: String,
        var title: String,
        var description: String,
        var datetime: Int,
        var cover: String,
        var cover_width: String,
        var cover_height: String,
        var account_url: String,
        var account_id: Int,
        var privacy: String,
        var layout: String,
        var views: Int,
        var link: String,
        var ups: Int,
        var downs: Int,
        var points: Int,
        var score: Int,
        var is_album: Boolean,
        var vote: String,
        var favorite: Boolean,
        var nsfw: String,
        var section: String,
        var comment_count: Int,
        var favorite_count: Int,
        var topic: String,
        var topic_id: String,
        var image_count: Int,
        var in_gallery: String,
        var is_ad: Boolean,
        var tags: List<Tags>,
        var ad_type: Int,
        var ad_url: String,
        var in_most_viral: Boolean,
        var include_album_ads: Boolean,
        var images: List<Image>,
        var ad_config: AdConfig,
    )
    data class ResponseSearch (
        var data: List<ResponseSearchData>,
        var success: Boolean,
        var status: Int
    )

    data class ResponseVote (
        var data: Boolean,
        var success: Boolean,
        var status: Int
    )

    data class ResponseFavorite (
            var data: String,
            var success: Boolean,
            var status: Int
    )
    data class ResponseDelete (
            var data: Boolean,
            var success: Boolean,
            var status: Int
    )
}