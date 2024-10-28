package lemonsqueezy.easypeasy.randompic.data.remote

import lemonsqueezy.easypeasy.randompic.data.remote.dto.PicDto
import lemonsqueezy.easypeasy.randompic.data.remote.dto.PicsResult
import retrofit2.http.GET

interface RandomPicApi {

    @GET
    suspend fun getNewPics(): PicsResult

    @GET
    suspend fun getPicDetails(): PicDto

    companion object {
        const val BASE_URL = "https://picsum.photos/v2/list"
    }
}