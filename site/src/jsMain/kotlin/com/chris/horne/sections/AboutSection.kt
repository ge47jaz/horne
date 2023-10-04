package com.chris.horne.sections

import androidx.compose.runtime.*
import com.chris.horne.components.SectionTitle
import com.chris.horne.components.SkillBar
import com.chris.horne.models.Section
import com.chris.horne.models.Skill
import com.chris.horne.models.Theme
import com.chris.horne.styles.AboutImageStyle
import com.chris.horne.styles.AboutTextStyle
import com.chris.horne.util.Constants.FONT_FAMILY
import com.chris.horne.util.Constants.SECTION_WIDTH
import com.chris.horne.util.ObserveViewportEntered
import com.chris.horne.util.Res
import com.chris.horne.util.animatePercentage
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun AboutSection() {
    // all components stacked on each other
    Box(
        modifier = Modifier
            .id(Section.About.id) // unique id to navigate to this section
            .maxWidth(SECTION_WIDTH.px) // convert to px
            .padding(topBottom = 150.px),
        contentAlignment = Alignment.Center
    ) {
        AboutContent()
    }
}

@Composable
fun AboutContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 100.percent else 90.percent)
            .maxWidth(1200.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleGrid(
            modifier = Modifier.fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 90.percent
                else 100.percent
            ),
            numColumns = numColumns(base = 1, md = 2)
        ) {
            if (breakpoint >= Breakpoint.MD) {
                AboutImage()
            }
            AboutMe()
        }
    }
}

@Composable
fun AboutImage() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = AboutImageStyle.toModifier().fillMaxWidth(80.percent),
            src = Res.aboutImage,
            desc = "About Image"
        )
    }
}

@Composable
fun AboutMe() {
    val scope = rememberCoroutineScope()
    var viewportEntered by remember { mutableStateOf(false) }
    val animatedPercentage = remember { mutableStateListOf(0, 0, 0, 0, 0) }

    ObserveViewportEntered(
        sectionId = Section.About.id,
        distanceFromTop = 300.0,
        onViewportEntered = {
            viewportEntered = true
            Skill.values().forEach { skill ->
                scope.launch {
                    animatePercentage(
                        percent = skill.percentage.value.toInt(),
                        onUpdate = {
                            animatedPercentage[skill.ordinal] = it
                        }
                    )
                }
            }
        }
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        SectionTitle(section = Section.About, alignment = Alignment.Start)
        P( // paragraph in html
            attrs = AboutTextStyle.toModifier()
                .margin(topBottom = 25.px)
                .maxWidth(500.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(18.px)
                .fontWeight(FontWeight.Normal)
                .fontStyle(FontStyle.Italic)
                .color(Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text("Hello! \uD83D\uDC4B I'm Christian Horne, a dedicated student at TUM with a profound passion for informatics and technology. I find immense joy in unraveling the complexities of the digital world and exploring innovative solutions to real-world challenges. With a curious mind and a thirst for knowledge, I'm always eager to dive into new areas of computer science, from coding and algorithms to cutting-edge technologies like artificial intelligence and software development")
        }
        // create a skill bar for every skill
        Skill.values().forEach { skill ->
            SkillBar(
                name = skill.title,
                index = skill.ordinal, // index value of each constant of enum class
                percentage = if (viewportEntered) skill.percentage else 0.percent,
                animatedPercentage = if (viewportEntered) animatedPercentage[skill.ordinal] else 0
            )

        }
    }
}