package lemonsqueezy.easypeasy.randompic.data.repository

import android.accounts.NetworkErrorException
import android.net.http.NetworkException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import lemonsqueezy.easypeasy.randompic.R
import lemonsqueezy.easypeasy.randompic.data.remote.RandomPicApi
import lemonsqueezy.easypeasy.randompic.domain.model.Pic
import lemonsqueezy.easypeasy.randompic.domain.repository.RandomPicRepository
import lemonsqueezy.easypeasy.randompic.util.Answer
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RandomPicRepositoryImpl @Inject constructor(
    private val api: RandomPicApi
) : RandomPicRepository {

    override fun getPics(page: Int, limit: Int): Flow<Answer<List<Pic>>> = flow {
        emit(Answer.Loading(true))
        try {
            val response = api.getNewPics(page, limit)
            emit(Answer.Success(response))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(
                Answer.Error(
                    messageId = R.string.data_error_message,
                    data = null
                )
            )
        } catch (e: NetworkErrorException) {
            e.printStackTrace()
            emit(
                Answer.Error(
                    messageId = R.string.network_error_message,
                    data = null
                )
            )
        } catch (e: Exception) {
            e.printStackTrace()
            emit(
                Answer.Error(
                    messageId = R.string.unknown_error_message,
                    data = null
                )
            )
        }
    }

    override fun getPicDetail(): Flow<Answer<Pic>> {
        TODO("Not yet implemented")
    }
}