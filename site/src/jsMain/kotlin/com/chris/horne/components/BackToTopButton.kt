package com.chris.horne.components

import androidx.compose.runtime.*
import com.chris.horne.models.Theme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowUp
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px

@Composable
fun BackToTopButton() {
    val breakpoint = rememberBreakpoint()
    var scroll: Double? by remember { mutableStateOf(null) } // get current scroll position

    LaunchedEffect(Unit) { // eventlistener triggered only once
        window.addEventListener(type = "scroll", callback = {
            scroll = document.documentElement?.scrollTop // whenever we scroll on page, scroll will be updated
        })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .position(Position.Fixed) // back to top button must remain at same place
            .zIndex(1), // make sure that button is placed on top of all elements
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        Box(
            modifier = Modifier
                .size(50.px)
                .visibility(  // calculated based on current scroll value
                    if (scroll != null && scroll!! > 400) Visibility.Visible else Visibility.Hidden
                )
                .borderRadius(10.px)
                .margin(
                    right = 40.px,
                    bottom = 40.px
                )
                .backgroundColor(Theme.Primary.rgb)
                .cursor(Cursor.Pointer)
                .onClick {
                    document.documentElement?.scroll(x = 0.0, y = 0.0)
                },
            contentAlignment = Alignment.Center
        ) {
            FaArrowUp(
                modifier = Modifier.color(Colors.White),
                size = IconSize.LG
            )
        }
    }

}

