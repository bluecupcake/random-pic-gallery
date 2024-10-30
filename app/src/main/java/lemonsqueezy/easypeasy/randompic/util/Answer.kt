package lemonsqueezy.easypeasy.randompic.util

sealed class Answer<T>(val data: T? = null, val messageId: Int? = null) {
    class Loading<T>(val isLoading: Boolean = true): Answer<T>(null)
    class Success<T>(data: T?): Answer<T>(data)
    class Error<T>(messageId: Int, data: T? = null): Answer<T>(data, messageId)
}