package com.example.fireonboarding.onboarding_composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.fireonboarding.R

@Composable
fun OnboardingNavButton(
    modifier: Modifier = Modifier,
    currentPage: Int,
    noOfPages: Int,
//    onNextClicked: () -> Unit,
//    onBackClicked: () -> Unit
) {

    Button(
        onClick = {
        }
    ) {
        Text(stringResource(R.string.login))
    }

    Button(
        onClick = {

        }
    ) {
        Text(stringResource(R.string.signup))
    }

//    Row(
//        horizontalArrangement = Arrangement.SpaceBetween,
//        modifier = Modifier
//            .fillMaxWidth()
//    ) {
//        IconButton(
//            onClick = {
//                if (currentPage < noOfPages - 1) {
//                    onNextClicked()
//                } else {
//                    // go to your app main screen
//                }
//            },
//            modifier = modifier,
//            colors = IconButtonDefaults.iconButtonColors(
//                containerColor = MaterialTheme.colorScheme.onPrimary,
//                contentColor = MaterialTheme.colorScheme.primary
//            )
//        ) {
//            Icon(
//                imageVector = Icons.Default.KeyboardArrowRight,
//                contentDescription = "button next",
//                modifier = Modifier
//                    .size(48.dp)
//            )
//        }
//    }

    Spacer(modifier = Modifier.height(16.dp))

}