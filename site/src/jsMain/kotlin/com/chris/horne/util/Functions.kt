package com.chris.horne.util

import androidx.compose.runtime.*
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.delay
import org.w3c.dom.events.EventListener


// this function is needed to calculate when the skillbars should "fill up"
@Composable
fun ObserveViewportEntered(
    sectionId: String, // section that we want to observe entering the viewport
    distanceFromTop: Double, // calculated: top viewport to the top of section that is entering viewport
    onViewportEntered: () -> Unit // will be triggered, when we enter the viewport
) {
    // remember this value across multiple recompositions (by default viewport is not entered)
    var viewportEntered by remember { mutableStateOf(false) }
    val listener = remember {
        EventListener {
            val top = document.getElementById(sectionId)?.getBoundingClientRect()?.top
            // whenever top margin reaches a threshold from the top of the viewport, then onViewportEntered will be triggered
            if (top != null && top < distanceFromTop) {
                viewportEntered = true
            }
        }
    }

    // add listener, remove when viewport entered
    LaunchedEffect(viewportEntered) {
        if (viewportEntered) {
            onViewportEntered()
            window.removeEventListener(type = "scroll", callback = listener)
        } else {
            window.addEventListener(type = "scroll", callback = listener)
        }
    }
}

suspend fun animatePercentage( // suspend function bcs delay
    percent: Int,
    delay: Long = 10L, // 10 ms
    onUpdate: (Int) -> Unit
) {
    (0..percent).forEach {
        delay(delay)
        onUpdate(it)
    }
}