package com.project.epicture.api

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
}