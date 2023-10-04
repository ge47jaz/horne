package com.chris.horne.models

import com.chris.horne.util.Res

enum class Portfolio(
    val image: String,
    val title: String,
    val description: String
) {
    One(
        image = Res.portfolio,
        title = "Coming Soon",
        description = "Web Design"
    ),
    Two(
        image = Res.portfolio,
        title = "Coming Soon",
        description = "Frontend"
    ),
    Three(
        image = Res.portfolio,
        title = "Coming Soon",
        description = "Frontend/Backend"
    ),
    Four(
        image = Res.portfolio,
        title = "Coming Soon",
        description = "Web/Mobile App"
    ),
    Five(
        image = Res.portfolio,
        title = "Coming Soon",
        description = "Web/Mobile App"
    )
}