package lemonsqueezy.easypeasy.randompic.presentation.pics_list

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import lemonsqueezy.easypeasy.randompic.Screen

@Composable
fun PicsListScreen(
    navController: NavController
) {
    Button(onClick = {
        navController.navigate(route = Screen.PicDetail.route + "?id=38")
    }) {
        Text("siema")
    }
}