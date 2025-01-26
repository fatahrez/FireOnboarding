package com.example.fireonboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.fireonboarding.model.OnboardingItem
import com.example.fireonboarding.onboarding_composables.OnboardingDetails
import com.example.fireonboarding.onboarding_composables.OnboardingImageView
import com.example.fireonboarding.onboarding_composables.OnboardingNavButton
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen() {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    val onboardingScreens = OnboardingItem.getOnboardingImages()

    val currentPage = remember { mutableStateOf(0) }

    val pagerState = rememberPagerState(pageCount = {3})
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        HorizontalPager(
            state = pagerState
        ) { page ->

            Column {
                OnboardingImageView(
                    modifier = Modifier
                        .fillMaxWidth(),
                    imageRes = onboardingScreens[page].imageRes,
                    contentDescription = stringResource(onboardingScreens[page].title)
                )

                OnboardingDetails(
                    modifier = Modifier,
                    currentPage = onboardingScreens[page]
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {
                    if (pagerState.currentPage > 0) {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    }
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            }

            IconButton(
                onClick = {
                    if (pagerState.currentPage < onboardingScreens.size - 1) {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                },
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Forward",
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {

        OnboardingNavButton(
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .size(56.dp)
                .align(Alignment.End),
            currentPage = currentPage.value,
            noOfPages = onboardingScreens.size
        )
    }
}