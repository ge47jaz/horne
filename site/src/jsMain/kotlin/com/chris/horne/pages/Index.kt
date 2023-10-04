package com.chris.horne.pages

import androidx.compose.runtime.Composable
import com.chris.horne.sections.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.dom.Footer

@Page
@Composable
fun HomePage() {
    Column(
        modifier = Modifier.fillMaxSize(), // each section has fixed width
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MainSection()
        AboutSection()
        ServiceSection()
        PortfolioSection()
        ContactSection()
        FooterSection()
    }
}
