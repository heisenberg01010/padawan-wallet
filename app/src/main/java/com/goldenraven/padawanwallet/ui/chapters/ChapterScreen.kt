package com.goldenraven.padawanwallet.ui.chapters

import android.util.Log
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.goldenraven.padawanwallet.R
import com.goldenraven.padawanwallet.data.chapters.ElementType
import com.goldenraven.padawanwallet.data.chapters.Page
import com.goldenraven.padawanwallet.theme.*
import com.goldenraven.padawanwallet.ui.standardBorder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// TODO Add transition between pages smoother (pages & progress bar)
// TODO Add chapter images

private const val TAG = "ChapterScreen"

@Composable
fun ChapterScreen(
    chapterId: Int,
    chaptersViewModel: ChaptersViewModel,
    navController: NavHostController
) {
    val chapterPages = chaptersViewModel.getChapterPages(id = chapterId)
    Log.i(TAG, "We're dealing with chapter $chapterId and the chapterPageSize is ${chapterPages.size}")
    val currentPage = remember { mutableStateOf(1) }
    val pageScrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .background(color = padawan_theme_background_secondary)
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .background(color = padawan_theme_tutorial_background)
                .border(BorderStroke(1.dp, SolidColor(padawan_theme_onPrimary)))
                .fillMaxWidth()
                .drawBehind {
                    drawLine(
                        color = padawan_theme_onPrimary,
                        strokeWidth = 15f,
                        start = Offset(x = 0f, y = size.height),
                        end = Offset(x = size.width, y = size.height)
                    )
                }
        ) {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                ChapterAppBar(navController = navController)
                ChapterProgressBar(completion = currentPage, total = chapterPages.size - 1)
            }
        }

        Column(
            modifier = Modifier
                .verticalScroll(pageScrollState)
                .padding(all = 32.dp)
                .fillMaxSize()
        ) {
            ChapterPage(chapterPages = chapterPages, currentPage = currentPage)
            ChapterButtons(
                chapterPageSize = chapterPages.size,
                currentPage = currentPage,
                pageScrollState = pageScrollState,
                coroutineScope = coroutineScope,
                chaptersViewModel = chaptersViewModel,
                chapterId = chapterId,
                navController
            )
        }
    }
}

@Composable
fun ChapterButtons(
    chapterPageSize: Int,
    currentPage: MutableState<Int>,
    pageScrollState: ScrollState,
    coroutineScope: CoroutineScope,
    chaptersViewModel: ChaptersViewModel,
    chapterId: Int,
    navController: NavHostController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Log.i(TAG, "We're on page ${currentPage.value}")
        if (currentPage.value != 1) {
            Button(
                onClick = {
                    currentPage.value -= 1
                    // chaptersViewModel.setCompletion(id = tutorialId - 1, completion = currentPage.value)
                    scrollUp(pageScrollState = pageScrollState, coroutineScope = coroutineScope)
                },
                colors = ButtonDefaults.buttonColors(containerColor = padawan_theme_button_secondary),
                shape = RoundedCornerShape(20.dp),
                border = standardBorder,
                modifier = Modifier
                    .padding(all = 4.dp)
                    .standardShadow(20.dp)
                    .weight(weight = 0.5f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "Previous Chapter Icon"
                    )
                    Spacer(modifier = Modifier.width(width = 16.dp))
                    Text(
                        text = "Prev",
                        style = PadawanTypography.labelLarge,
                    )
                }
            }
        } else if (chapterPageSize > 1) {
            // Spacer(modifier = Modifier.weight(weight = 0.5f))
        }

        if (currentPage.value < chapterPageSize - 1) {
            Button(
                onClick = {
                    currentPage.value += 1
                    scrollUp(pageScrollState = pageScrollState, coroutineScope = coroutineScope)
                },
                colors = ButtonDefaults.buttonColors(containerColor = padawan_theme_button_primary),
                shape = RoundedCornerShape(20.dp),
                border = standardBorder,
                modifier = Modifier
                    .padding(all = 4.dp)
                    .standardShadow(20.dp)
                    .weight(weight = 0.5f),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Text(
                        text = "Next",
                        style = PadawanTypography.labelLarge,
                    )
                    Spacer(modifier = Modifier.width(width = 16.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_front),
                        contentDescription = "Next Chapter Icon"
                    )
                }
            }
        } else if (currentPage.value == chapterPageSize - 1) {
            Button(
                onClick = {
                    chaptersViewModel.setCompleted(id = chapterId)
                    navController.popBackStack()
                },
                colors = ButtonDefaults.buttonColors(containerColor = padawan_theme_button_primary),
                shape = RoundedCornerShape(20.dp),
                border = standardBorder,
                modifier = Modifier
                    .padding(all = 4.dp)
                    .standardShadow(20.dp)
                    .weight(weight = 0.5f),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Text(
                        text = "Finish",
                        style = PadawanTypography.labelLarge,
                    )
                }
            }
        } else {
            Spacer(modifier = Modifier.weight(weight = 0.5f))
        }
    }
}

fun scrollUp(pageScrollState: ScrollState, coroutineScope: CoroutineScope) {
    coroutineScope.launch {
        pageScrollState.animateScrollTo(value = 0, animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing))
    }
}

@Composable
internal fun ChapterAppBar(navController: NavHostController) {
    Row(modifier = Modifier.fillMaxWidth()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(alignment = Alignment.CenterVertically)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_drag_left),
                contentDescription = "Back Icon",
                tint = padawan_theme_onPrimary
            )
        }
        Text(
            text = "Back to lessons",
            style = PadawanTypography.bodyMedium,
            modifier = Modifier.align(alignment = Alignment.CenterVertically)
        )
    }
}

@Composable
fun ChapterProgressBar(
    height: Dp = 8.dp,
    spacer: Float = 30f,
    incompleteColor: Color = Color(0xfffbf5bf),
    completeColor: Color = Color(0xff1f0208),
    completion: MutableState<Int>,
    total: Int,
) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)
            .height(height = height)
    ) {
        val progressBarLength = ((size.width + spacer) / total - 1) - spacer

        // total -1 because the list of pages includes the description, which counts as 1 page
        // for (i in 0 until total - 1) {
        for (i in 0 until total) {
            drawLine(
                color = if (completion.value > i) completeColor else incompleteColor,
                strokeWidth = size.height,
                start = Offset(x = i * (progressBarLength + spacer), y = 0f),
                end = Offset(x = (i + 1) * (progressBarLength + spacer) - spacer, y = 0f)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ChapterPage(chapterPages: List<Page>, currentPage: MutableState<Int>) {
    for (element in chapterPages[currentPage.value]) {
        when (element.elementType) {
            ElementType.TITLE -> {
                Text(
                    text = stringResource(id = element.resourceId),
                    style = PadawanTypography.headlineSmall,
                )
            }
            ElementType.SUBTITLE -> {
                Text(
                    text = stringResource(id = element.resourceId),
                    style = PadawanTypography.labelLarge,
                    fontSize = 18.sp
                )
            }
            ElementType.BODY -> {
                Text(
                    text = stringResource(id = element.resourceId),
                    style = PadawanTypography.bodyMedium,
                    color = padawan_theme_text_faded_secondary
                )
            }
            ElementType.RESOURCE -> {
                Card(
                    // containerColor = padawan_theme_button_secondary,
                    colors = CardDefaults.cardColors(padawan_theme_button_secondary),
                    border = standardBorder,
                    modifier = Modifier
                        .height(height = 150.dp)
                        .fillMaxWidth()
                        .standardShadow(20.dp)
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Image(
                            painter = painterResource(id = element.resourceId),
                            contentDescription = "sample btc address" ,
                            modifier = Modifier.aspectRatio(1f)
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(height = 24.dp))
    }
}
