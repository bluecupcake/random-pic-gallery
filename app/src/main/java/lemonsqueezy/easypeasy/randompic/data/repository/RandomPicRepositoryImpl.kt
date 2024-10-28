package lemonsqueezy.easypeasy.randompic.data.repository

import kotlinx.coroutines.flow.Flow
import lemonsqueezy.easypeasy.randompic.data.remote.RandomPicApi
import lemonsqueezy.easypeasy.randompic.domain.model.Pic
import lemonsqueezy.easypeasy.randompic.domain.repository.RandomPicRepository
import lemonsqueezy.easypeasy.randompic.util.Answer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RandomPicRepositoryImpl @Inject constructor(
    private val api: RandomPicApi
): RandomPicRepository {

    override fun getPics(): Flow<Answer<List<Pic>>> {
        TODO("Not yet implemented")
    }

    override fun getPicDetail(): Flow<Answer<Pic>> {
        TODO("Not yet implemented")
    }
}