package lemonsqueezy.easypeasy.randompic.presentation.pic_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import lemonsqueezy.easypeasy.randompic.R
import lemonsqueezy.easypeasy.randompic.Screen
import lemonsqueezy.easypeasy.randompic.data.remote.RandomPicApi.Companion.BASE_URL
import lemonsqueezy.easypeasy.randompic.domain.model.Pic
import lemonsqueezy.easypeasy.randompic.presentation.components.ShimmerImageLoading

@Composable
fun PicDetailsScreen(
    pic: Pic,
    navController: NavController
) {
    var isImageLoading by remember { mutableStateOf(true) }

    Column(modifier = Modifier.fillMaxSize()) {
        Box {
            val image = AsyncImage(
                model = "${BASE_URL}id/${pic.id}/300/200",
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(3f / 2f),
                onSuccess = { isImageLoading = false }
            )

            ShimmerImageLoading(
                isLoading = isImageLoading,
                contentAfterLoading = { image },
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(3f / 2f),
            )
        }

        Column(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 24.dp)
        ) {
            Text(text = "${stringResource(id = R.string.pic_id)}: ${pic.id}")
            Text(text = "${stringResource(id = R.string.pic_author)}: ${pic.author}")
            Text(text = "${stringResource(id = R.string.pic_width)}: ${pic.width}")
            Text(text = "${stringResource(id = R.string.pic_height)}: ${pic.height}")
            Text(text = "${stringResource(id = R.string.pic_download_url)}: ${pic.download_url}")

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate(route = Screen.PicsList.route) },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = stringResource(id = R.string.back))
            }
        }
    }
}