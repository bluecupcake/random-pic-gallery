package lemonsqueezy.easypeasy.randompic.presentation.pics_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getDrawable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import lemonsqueezy.easypeasy.randompic.R
import lemonsqueezy.easypeasy.randompic.domain.model.Pic
import lemonsqueezy.easypeasy.randompic.ui.theme.NotAsWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PicsListScreen(
    navController: NavController,
    viewModel: PicsListViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(
                            text = stringResource(id = R.string.home_title),
                            fontSize = 28.sp,
                            color = NotAsWhite
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { innerPanding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPanding)
        ) {
            when (state.isLoading) {
                true -> Image(
                    modifier = Modifier.align(Alignment.Center),
                    painter = rememberDrawablePainter(
                        drawable = getDrawable(
                            LocalContext.current,
                            R.drawable.loading
                        )
                    ),
                    contentDescription = stringResource(id = R.string.loading),
                    contentScale = ContentScale.Fit,
                )

                false -> PicsList(
                    modifier = Modifier.fillMaxSize(),
                    navController = navController,
                    pics = state.pics.toTypedArray(),
                    state.page,
                    onRefresh = {
                        viewModel.onEvent(PicListEvent.Refresh)
                    }
                )
            }
        }
    }
}

@Composable
private fun PicsList(
    modifier: Modifier = Modifier,
    navController: NavController,
    pics: Array<Pic>,
    currentPage: Int,
    onRefresh: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn {
            itemsIndexed(
                items = pics
            ) { index, pic ->
                PicItem(
                    pic,
                    currentPage,
                    navController
                )
            }
        }

        Button(
            onClick = onRefresh,
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Text(
                text = stringResource(id = R.string.refresh),
                color = NotAsWhite
            )
        }
    }
}