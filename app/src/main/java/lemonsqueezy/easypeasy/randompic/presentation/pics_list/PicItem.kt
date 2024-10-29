package lemonsqueezy.easypeasy.randompic.presentation.pics_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import lemonsqueezy.easypeasy.randompic.Screen
import lemonsqueezy.easypeasy.randompic.data.remote.RandomPicApi.Companion.BASE_URL
import lemonsqueezy.easypeasy.randompic.domain.model.Pic

@Composable
fun PicItem(
    pic: Pic,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 12.dp)
            .clickable {
            navController.navigate(route = Screen.PicDetail.route + "?id=${pic.id}")
        }
    ) {
        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data("${BASE_URL}id/${pic.id}/200/180")
                .size(Size.ORIGINAL)
                .build()
        )

        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(128.dp)
        )

        Text(
            text = pic.id,
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterStart)
        )

        HorizontalDivider(
            thickness = 2.dp
        )
    }
}