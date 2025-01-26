package com.example.fireonboarding.model

import androidx.compose.ui.graphics.Color

data class OnboardingItem(
    val imageRes: Int,
    val title: Int,
    val description: Int,
    val color: Color
) {
    companion object {
        fun getOnboardingImages(): List<OnboardingItem> {
            return listOf(

            )
        }
    }
}