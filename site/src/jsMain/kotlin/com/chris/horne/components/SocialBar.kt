package com.chris.horne.components

import androidx.compose.runtime.Composable
import com.chris.horne.styles.SocialLinkStyle
import com.chris.horne.util.Constants.WEBSITE_DISCORD
import com.chris.horne.util.Constants.WEBSITE_EMAIL
import com.chris.horne.util.Constants.WEBSITE_GITHUB
import com.chris.horne.util.Constants.WEBSITE_INSTAGRAM
import com.chris.horne.util.Constants.WEBSITE_LINKEDIN
import com.chris.horne.util.Constants.WEBSITE_PAYPAL
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.px

@Composable
fun SocialBar(row: Boolean = false) {
    if (row) {
        Row(
            modifier = Modifier
                .margin(top = 25.px)
                .padding(leftRight = 25.px)
                .minHeight(40.px)
                .borderRadius(r = 20.px)
                .backgroundColor(Colors.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            SocialLinks(row = true)
        }
    } else {
        Column(
            modifier = Modifier
                .margin(right = 25.px)
                .padding(topBottom = 25.px)
                .minWidth(40.px)
                .borderRadius(r = 20.px)
                .backgroundColor(Colors.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SocialLinks()
        }
    }
}

@Composable
private fun SocialLinks(row: Boolean = false) {
    Link(
        path = WEBSITE_GITHUB, // link that is followed on click
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB // open link in new tab
    ) {
        FaGithub(
            modifier = SocialLinkStyle.toModifier()
                .margin(
                    bottom = if (row) 0.px else 40.px,
                    right = if (row) 40.px else 0.px
                ),
            size = IconSize.LG
        )
    }
    Link(
        path = WEBSITE_LINKEDIN,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB // open link in new tab
    ) {
        FaLinkedin(
            modifier = SocialLinkStyle.toModifier()
                .margin(
                    bottom = if (row) 0.px else 40.px,
                    right = if (row) 40.px else 0.px
                ),
            size = IconSize.LG
        )
    }
    Link(
        path = WEBSITE_INSTAGRAM,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB // open link in new tab
    ) {
        FaInstagram(
            modifier = SocialLinkStyle.toModifier()
                .margin(
                    bottom = if (row) 0.px else 40.px,
                    right = if (row) 40.px else 0.px
                ),
            size = IconSize.LG
        )
    }
    Link(
        path = WEBSITE_EMAIL,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB // open link in new tab
    ) {
        FaEnvelope(
            modifier = SocialLinkStyle.toModifier()
                .margin(
                    bottom = if (row) 0.px else 40.px,
                    right = if (row) 40.px else 0.px
                ),
            size = IconSize.LG
        )
    }
    Link(
        path = WEBSITE_DISCORD,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB // open link in new tab
    ) {
        FaDiscord(
            modifier = SocialLinkStyle.toModifier()
                .margin(
                    bottom = if (row) 0.px else 40.px,
                    right = if (row) 40.px else 0.px
                ),
            size = IconSize.LG
        )
    }
    Link(
        path = WEBSITE_PAYPAL,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB // open link in new tab
    ) {
        FaPaypal(
            modifier = SocialLinkStyle.toModifier(),
            size = IconSize.LG
        )
    }
}