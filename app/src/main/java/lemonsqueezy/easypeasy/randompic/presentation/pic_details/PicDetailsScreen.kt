package lemonsqueezy.easypeasy.randompic.presentation.pic_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import lemonsqueezy.easypeasy.randompic.R
import lemonsqueezy.easypeasy.randompic.Screen
import lemonsqueezy.easypeasy.randompic.data.remote.RandomPicApi.Companion.BASE_URL
import lemonsqueezy.easypeasy.randompic.domain.model.Pic

@Composable
fun PicDetailsScreen(
    pic: Pic,
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxSize()) {
        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data("${BASE_URL}id/${pic.id}/300/150")
                .size(Size.ORIGINAL)
                .build()
        )

        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(128.dp)
        )

        Text(text = "${stringResource(id = R.string.pic_id)}: ${pic.id}")
        Text(text = "${stringResource(id = R.string.pic_author)}: ${pic.author}")
        Text(text = "${stringResource(id = R.string.pic_width)}: ${pic.width}")
        Text(text = "${stringResource(id = R.string.pic_height)}: ${pic.height}")
        Text(text = "${stringResource(id = R.string.pic_download_url)}: ${pic.download_url}")

        Button(onClick = { navController.navigate(route = Screen.PicsList.route) }) {
            Text(text = stringResource(id = R.string.back))
        }
    }
}