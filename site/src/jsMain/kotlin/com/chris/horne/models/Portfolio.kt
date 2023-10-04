package com.chris.horne.models

import androidx.compose.runtime.internal.StabilityInferred
import com.chris.horne.util.Res

enum class Portfolio(
    val image: String,
    val title: String,
    val description: String
) {
    One(
        image = Res.portfolio1,
        title = "Kudoe",
        description = "Web Design"
    ),
    Two(
        image = Res.portfolio2,
        title = "Landing Page for NFT",
        description = "Frontend"
    ),
    Three(
        image = Res.portfolio3,
        title = "NFT Application",
        description = "Frontend/Backend"
    ),
    Four(
        image = Res.portfolio4,
        title = "Game Statistics Application",
        description = "Web/Mobile App"
    ),
    Five(
        image = Res.portfolio5,
        title = "Platform for Online Courses",
        description = "Web/Mobile App"
    )
}