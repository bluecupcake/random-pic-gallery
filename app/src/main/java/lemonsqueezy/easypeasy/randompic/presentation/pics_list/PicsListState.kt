package lemonsqueezy.easypeasy.randompic.presentation.pics_list

import lemonsqueezy.easypeasy.randompic.domain.model.Pic

data class PicsListState(
    val pics: List<Pic> = emptyList(),
    val page: Int = 1,
    val isLoading: Boolean = false,
    val errorMessageId: Int? = null,
)