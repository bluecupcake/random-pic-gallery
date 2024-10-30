package lemonsqueezy.easypeasy.randompic.presentation.pics_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import lemonsqueezy.easypeasy.randompic.Screen
import lemonsqueezy.easypeasy.randompic.data.remote.RandomPicApi.Companion.BASE_URL
import lemonsqueezy.easypeasy.randompic.domain.model.Pic
import lemonsqueezy.easypeasy.randompic.presentation.components.ShimmerImageLoading

@Composable
fun PicItem(
    pic: Pic,
    currentPage: Int,
    navController: NavController
) {
    val json = Json.encodeToString(pic)
    var isImageLoading by remember { mutableStateOf(true) }

    Column {
        Box(
            modifier = Modifier
                .padding(bottom = 8.dp, top = 12.dp)
                .clickable {
                    navController.navigate(route = Screen.PicDetail.route + "?pic=$json&page=${currentPage}")
                }
        ) {
            val loadedImage = AsyncImage(
                model = "${BASE_URL}id/${pic.id}/300/300",
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(3f / 2f),
                onSuccess = { isImageLoading = false }
            )

            ShimmerImageLoading(
                isLoading = isImageLoading,
                contentAfterLoading = { loadedImage },
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(3f / 2f),
            )

            Text(
                text = pic.id.toString(),
                fontSize = 128.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.primary)
    }
}