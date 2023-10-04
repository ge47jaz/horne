package com.chris.horne.styles

import com.chris.horne.models.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.anyLink
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

// apply style to main section
val NavigationItemStyle by ComponentStyle {
    // base style
    base {
        Modifier
            .color(Theme.Secondary.rgb)
            .transition(CSSTransition(property = "color", duration = 200.ms)) // add delay to color transition
    }

    // default link style
    anyLink {
        Modifier
            .color(Theme.Secondary.rgb)
    }

    // specify style on hover:
    hover {
        Modifier
            .color(Theme.Primary.rgb)
    }
}

@OptIn(ExperimentalComposeWebApi::class)
val LogoStyle by ComponentStyle {
    base {
        Modifier
            .transform { rotate(0.deg) }
            .transition(CSSTransition(property = "transform", duration = 200.ms)) // add delay to rotation transition
    }
    hover {
        Modifier
            .transform { rotate((-10).deg) }
    }
}

val SocialLinkStyle by ComponentStyle {
    base {
        Modifier
            .color(Theme.Gray.rgb)
            .transition(
                CSSTransition(property = "color", duration = 100.ms),
                CSSTransition(property = "box-shadow", duration = 10.ms),
                CSSTransition(property = "scale", duration = 100.ms)
            )

    }
    hover {
        Modifier
            .color(Theme.Primary.rgb)
            .scale(2.0f) // Increase size on hover
            .boxShadow(
                offsetX = 4.px,
                offsetY = 4.px,
                blurRadius = 10.px,
                color = Colors.Black // Shadow color
            )
    }
}

val MainButtonStyle by ComponentStyle {
    base {
        Modifier
            .width(100.px)
            .transition(CSSTransition(property = "width", duration = 200.ms))
    }
    hover {
        Modifier
            .width(120.px)
    }
}

@OptIn(ExperimentalComposeWebApi::class)
val MainImageStyle by ComponentStyle {
    base {
        Modifier
            .styleModifier {
                filter { grayscale(100.percent) }
            }
            .transition(CSSTransition(property = "filter", duration = 200.ms))
    }
    hover {
        Modifier.styleModifier {
            filter { grayscale(0.percent) }
        }
    }
}