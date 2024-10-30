package lemonsqueezy.easypeasy.randompic.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Pic(
    val id: Int,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    val download_url: String
)