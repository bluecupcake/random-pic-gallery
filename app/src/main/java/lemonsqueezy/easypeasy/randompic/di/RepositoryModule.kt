package lemonsqueezy.easypeasy.randompic.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import lemonsqueezy.easypeasy.randompic.data.repository.RandomPicRepositoryImpl
import lemonsqueezy.easypeasy.randompic.domain.repository.RandomPicRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRandomPicRepository(
        randomPicRepositoryImpl: RandomPicRepositoryImpl
    ): RandomPicRepository
}