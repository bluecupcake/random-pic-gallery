package lemonsqueezy.easypeasy.randompic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import lemonsqueezy.easypeasy.randompic.presentation.pic_details.PicDetailsScreen
import lemonsqueezy.easypeasy.randompic.presentation.pics_list.PicsListScreen
import lemonsqueezy.easypeasy.randompic.ui.theme.RandomPicTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomPicTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost()
                }
            }
        }
    }
}

@Composable
private fun NavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.PicsList.route) {
        composable(route = Screen.PicsList.route) {
            PicsListScreen(navController = navController)
        }
        composable(
            route = Screen.PicDetail.route + "?id={id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                    nullable = false
                }
            )
        ) {
            PicDetailsScreen(
                picId = it.arguments?.getInt("id") ?: -1,
                navController = navController
            )
        }
    }
}

sealed class Screen(val route: String) {
    object PicsList : Screen("pics_list_screen")
    object PicDetail : Screen("pic_details_screen")
}