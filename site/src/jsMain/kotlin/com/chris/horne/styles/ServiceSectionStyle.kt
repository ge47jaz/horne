package com.chris.horne.styles

import com.chris.horne.models.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

@OptIn(ExperimentalComposeWebApi::class)
val ServiceCardStyle by ComponentStyle {
    base {
        Modifier
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = Theme.LighterGray.rgb
            )
            .backgroundColor(Colors.White)
            .transition(
                CSSTransition(property = "border", duration = 200.ms),
                CSSTransition(property = "background", duration = 200.ms),
                CSSTransition(property = "transform", duration = 200.ms)
            )
    }
    hover {
        Modifier
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = Theme.Primary.rgb
            )
            .backgroundColor(Theme.Primary.rgb)
            .transform { scale(1.1) }
    }

    // animate the icon that is a child element
    cssRule(" > #iconBox") { // target child elements of base parent that contains id: iconBox
        Modifier
            .backgroundColor(Colors.Transparent)
            .transition(CSSTransition(property = "background", duration = 200.ms))
    }

    cssRule(":hover > #iconBox") { // on hover change background color
        Modifier.backgroundColor(Colors.White)
    }

    // for text animation
    cssRule(" > p") { // p is paragraph in html
        Modifier
            .color(Theme.Secondary.rgb)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }

    cssRule(":hover > p") {
        Modifier.color(Colors.White)
    }
}