package lemonsqueezy.easypeasy.randompic.domain.repository

import kotlinx.coroutines.flow.Flow
import lemonsqueezy.easypeasy.randompic.domain.model.Pic
import lemonsqueezy.easypeasy.randompic.util.Answer

interface RandomPicRepository {

    fun getPics(page: Int, limit: Int): Flow<Answer<List<Pic>>>

    fun getPicDetail(): Flow<Answer<Pic>> // todo in future maybe
}