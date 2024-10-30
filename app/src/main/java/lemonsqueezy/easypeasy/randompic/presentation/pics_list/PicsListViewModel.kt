package lemonsqueezy.easypeasy.randompic.presentation.pics_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import lemonsqueezy.easypeasy.randompic.domain.repository.RandomPicRepository
import lemonsqueezy.easypeasy.randompic.util.Answer
import javax.inject.Inject

@HiltViewModel
class PicsListViewModel @Inject constructor(
    private val repository: RandomPicRepository
) : ViewModel() {

    var state by mutableStateOf(PicsListState())

    init {
        getPics()
    }

    fun onEvent(event: PicListEvent) {
        when (event) {
            is PicListEvent.Refresh -> refresh()
        }
    }

    private fun getPics() {
        viewModelScope.launch {
            repository.getPics(state.page, 20).collect { ans ->
                when (ans) {
                    is Answer.Success -> {
                        state = state.copy(
                            pics = ans.data ?: emptyList(),
                            isLoading = false
                        )
                    }

                    is Answer.Error -> {
                        state = state.copy(
                            isLoading = false
                        )
                    }

                    is Answer.Loading -> {
                        state = state.copy(
                            isLoading = true
                        )
                    }
                }
            }
        }
    }

    private fun refresh() {
        state = state.copy(
            page = state.page + 1
        )
        getPics()
    }
}