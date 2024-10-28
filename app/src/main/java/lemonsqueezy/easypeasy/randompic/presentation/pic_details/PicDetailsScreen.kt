package lemonsqueezy.easypeasy.randompic.presentation.pic_details

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import lemonsqueezy.easypeasy.randompic.Screen

@Composable
fun PicDetailsScreen(
    picId: Int,
    navController: NavController
) {
    Button(onClick = {
        navController.navigate(route = Screen.PicsList.route)
    }) {
        Text("nara $picId")
    }
}