package com.chris.horne.components

import androidx.compose.runtime.Composable
import com.chris.horne.models.Theme
import com.chris.horne.styles.InputStyle
import com.chris.horne.styles.MainButtonStyle
import com.chris.horne.util.Constants.FONT_FAMILY
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

@Composable
fun ContactForm(breakpoint: Breakpoint) {

    Form(
        action = "https://formspree.io/f/xrgwoora", // <-- FORMSPREE
        attrs = Modifier
            .attrsModifier {
                attr("method", "POST") // needed to send email to me when button clicked
            }
            .toAttrs()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .margin(top = 25.px),
            horizontalAlignment = Alignment.Start
        ) {
            Label(
                attrs = Modifier
                    // specify boostrap classes for label
                    .classNames("form-label")
                    .margin(
                        bottom = 5.px,
                        left = 15.px
                    )
                    .fontWeight(FontWeight.Bold)
                    .fontSize(21.px)
                    .toAttrs(),
                forId = "inputName"
                // needs to be the same as the Input id below, so that input field gets focused even when hovering on label
            ) {
                Text("Name")
            }
            Input(
                type = InputType.Text,
                attrs = InputStyle.toModifier()
                    .id("inputName")
                    // specify boostrap class for Label
                    .classNames("form-control")
                    .margin(bottom = 20.px)
                    .width(
                        if (breakpoint >= Breakpoint.MD) 500.px
                        else 250.px
                    )
                    .backgroundColor(Theme.LighterGray.rgb)
                    .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                    .padding(all = 10.px)
                    .borderRadius(5.px)
                    .attrsModifier {
                        attr("placeholder", "Full Name") // add placeholder to input field
                        attr("name", "name") // needed for formspree
                        attr("required", "true") // fill out field is required
                    }
                    .toAttrs()
            )
            Label(
                attrs = Modifier
                    // specify boostrap classes for label
                    .classNames("form-label")
                    .margin(
                        bottom = 5.px,
                        left = 15.px
                    )
                    .fontWeight(FontWeight.Bold)
                    .fontSize(21.px)
                    .toAttrs(),
                forId = "inputEmail" // needs to be the same as the Input id below
            ) {
                Text("Email")
            }
            Input(
                type = InputType.Email,
                attrs = InputStyle.toModifier()
                    .id("inputEmail")
                    // specify boostrap class for Label
                    .classNames("form-control")
                    .margin(bottom = 20.px)
                    .width(
                        if (breakpoint >= Breakpoint.MD) 500.px
                        else 250.px
                    )
                    .backgroundColor(Theme.LighterGray.rgb)
                    .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                    .padding(all = 10.px)
                    .borderRadius(5.px)
                    .attrsModifier {
                        attr("placeholder", "Email Address") // add placeholder to input field
                        attr("name", "email") // needed for formspree
                        attr("required", "true") // fill out field is required
                    }
                    .toAttrs()
            )
            Label(
                attrs = Modifier
                    // specify boostrap classes for label
                    .classNames("form-label")
                    .margin(
                        bottom = 5.px,
                        left = 15.px
                    )
                    .fontWeight(FontWeight.Bold)
                    .fontSize(21.px)
                    .toAttrs(),
                forId = "inputMessage" // needs to be the same as the Input id below
            ) {
                Text("Message")
            }
            TextArea( // with TextArea we can manually increase size of component
                attrs = InputStyle.toModifier()
                    .id("inputMessage")
                    // specify boostrap class for Label
                    .classNames("form-control")
                    .height(150.px)
                    .maxWidth(700.px)
                    .margin(bottom = 10.px)
                    .width(
                        if (breakpoint >= Breakpoint.MD) 500.px
                        else 250.px
                    )
                    .backgroundColor(Theme.LighterGray.rgb)
                    .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                    .padding(all = 10.px)
                    .borderRadius(5.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(15.px)
                    .attrsModifier {
                        attr("placeholder", "Your Message") // add placeholder to input field
                        attr("name", "message") // needed for formspree
                        attr("required", "true") // fill out field is required
                    }
                    .toAttrs()
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    attrs = MainButtonStyle.toModifier()
                        .height(40.px)
                        .border { width(0.px) }
                        .borderRadius(5.px)
                        .backgroundColor(Theme.Primary.rgb)
                        .color(Colors.White)
                        .cursor(Cursor.Pointer)
                        .toAttrs()
                ) {
                    Text("Submit")
                }
            }
        }
    }

}