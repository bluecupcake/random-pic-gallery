package lemonsqueezy.easypeasy.randompic.domain.model

data class Pic(
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    val download_url: String
)