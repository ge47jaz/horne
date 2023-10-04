package com.chris.horne.components

import androidx.compose.runtime.Composable
import com.chris.horne.models.Section
import com.chris.horne.models.Theme
import com.chris.horne.styles.LogoStyle
import com.chris.horne.styles.NavigationItemStyle
import com.chris.horne.util.Constants.FONT_FAMILY
import com.chris.horne.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun Header() {
    val breakpoint = rememberBreakpoint() // make header responsive according to screen size
    Row(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 80.percent else 90.percent // header width adapts to screen size
            )
            .margin(topBottom = 50.px), // margin for header row
        horizontalArrangement = Arrangement.SpaceBetween, // space between right and left side
        verticalAlignment = Alignment.CenterVertically
    ) {
        LeftSide(breakpoint = breakpoint)

        // put menu in header only if screen is larger than MD breakpoint (simple tablet)
        if (breakpoint > Breakpoint.MD) {
            RightSide()
        }
    }
}

// left sid - logo
@Composable
fun LeftSide(breakpoint: Breakpoint) { // pass breakpoint to show dropdown for mobile
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (breakpoint <= Breakpoint.MD) {
            // show dropdown menu for mobile
            FaBars(
                modifier = Modifier.margin(right = 15.px),
                size = IconSize.XL
            ) // font awesome icon hamburger menu
        }
        Image(
            modifier = LogoStyle.toModifier(), // use LogoStyle in order to add animation to logo
            src = Res.logo,
            desc = "Logo Image"
        )
    }
}

// right side - menu
@Composable
fun RightSide() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .borderRadius(r = 50.px)
            .backgroundColor(Theme.LighterGray.rgb)
            .padding(all = 20.px),
        horizontalArrangement = Arrangement.End // alight left side to the right of the row
    ) {
        // take the first 6 constants from the enum
        Section.values().take(6).forEach { section ->
            // Link to each section
            Link(
                modifier = NavigationItemStyle.toModifier() // use NavigationItemStyle in order to add animation to links
                    .padding(right = 30.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .textDecorationLine(TextDecorationLine.None), // no underline when hover
                path = section.path, // this path proposal gets added to the path whenever we click on the link
                text = section.title
            )
        }
    }
}