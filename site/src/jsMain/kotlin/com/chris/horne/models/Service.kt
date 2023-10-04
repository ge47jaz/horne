package com.chris.horne.models

import com.chris.horne.util.Res

enum class Service(
    val icon: String,
    val imageDesc: String,
    val title: String,
    val description: String
) {
    Android(
        icon = Res.android,
        imageDesc = "Android Icon",
        title = "Android Development",
        description = "Expert Android developer with a knack for creating user-friendly apps. I bring proficiency in the latest technologies, ensuring top-notch performance and engaging user experiences."
    ),
    IOS(
        icon = Res.apple,
        imageDesc = "Apple Icon",
        title = "iOS Development",
        description = "Seasoned iOS developer specializing in crafting standout applications for Apple devices. My skills cover the entire development process, guaranteeing innovative and polished apps for your business."
    ),
    Web(
        icon = Res.web,
        imageDesc = "Desktop Icon",
        title = "Web Development",
        description ="Creative web developer skilled in building visually appealing, responsive websites. I prioritize seamless user interactions, ensuring your online presence captivates and converts visitors effectively."
    ),
    Design(
        icon = Res.design,
        imageDesc = "Pen Icon",
        title = "UX/UI Design",
        description = "User experience and interface design expert committed to creating intuitive, visually appealing designs. I blend research and creativity to deliver interfaces that resonate with users, enhancing your product's appeal."
    ),
    Business(
        icon = Res.business,
        imageDesc = "Chart Icon",
        title = "Business Analysis",
        description = "Experienced business analyst adept at translating data into strategic insights. I specialize in market research, competitive analysis, and performance metrics, enabling data-driven decision-making for your organization."
    ),
    SEO(
        icon = Res.seo,
        imageDesc = "Megaphone Icon",
        title = "SEO Marketing",
        description = "SEO marketing strategist focused on improving online visibility and driving organic traffic. I conduct thorough SEO audits and craft tailored strategies to boost your website's search engine ranking and overall digital presence."
    )
}