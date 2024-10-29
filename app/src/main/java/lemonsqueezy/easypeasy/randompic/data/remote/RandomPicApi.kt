package lemonsqueezy.easypeasy.randompic.data.remote

import lemonsqueezy.easypeasy.randompic.domain.model.Pic
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RandomPicApi {

    @GET("v2/list")
    suspend fun getNewPics(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
    ): List<Pic>

    @GET("id/{id}/info")
    suspend fun getPicDetails(@Path("id") id: Int): Pic

    companion object {
        const val BASE_URL = "https://picsum.photos/"
    }
}