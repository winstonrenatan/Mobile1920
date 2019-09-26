package com.github.winstonrenatan.brodoraexplore

import android.app.Application

class MyStoryLine: Application() {

    data class Scene(
        val title: String,
        val body: String,
        val actions: List<String>
    )

    companion object {
        // Constants
        val MAIN_MENU = "Main Menu"
        val TRY_AGAIN = "Try Again"
        val CONTINUE = "Continue"

        // Scenes
        val scenes: List<Scene> = listOf (
            // 0: Intro
            Scene (
                "Introduction",
                "You are Bro Dora the Explorer, you are a very handsome, handsome, and just handsome." +
                        "You cannot solve anything by yourself, because you are handsome and not to smart" +
                        "In this episode, you will explore the Ruins of Building B. You of course want to explore" +
                        "and get the best part of this experience, so you have the chance to bring a friend with you." +
                        "There is Boots who is a Fox, that can easily sneak anywhere. The other choice is Swiper the monkey," +
                        "not so helpful but he is fun though. Now who will you choose?",
                actions = listOf (
                    "Ask Boots to come..",
                    "Ask Swiper to come.."
                )
            ),

            // 1: with Boots
            Scene (
                "Parking at the Sky",
                "On the way to the Ruins, you should park at the 'SKY' which is quite pricey but," +
                        " Boots will cover all the expenses as he is very rich from pick pocketing from you from the first season." +
                        "Imagine there is a total of 8 seasons and 178 episodes to earn money from you!" +
                        "Now its time for him to pay the price for you, so much fun right",
                actions = listOf (
                    "Use the money he gave you.",
                    "\"No, thats fine my bro.\""
                )
            ),

            // 2: with Swiper
            Scene (
                "Parking at the Sky",
                "On the way to the Ruins, you should park at the 'SKY' which is quite pricey but," +
                        " Swiper has no money as he always fail to steal. That is because all the people watching always shout at him." +
                        " He easily gets scared now, and don't even want to see you at first. But, because you like to give him" +
                        "Diego's snack he join you this time and just shut his mouth",
                actions = listOf (
                    "Talk to him and ask to go with you.",
                    "Leave him at the car."
                )
            ),

            // 3: with Boots and Money
            Scene (
                "Entering Ruins of Building B",
                "You talk with him a bit, while walking in the Garden to the Ruins." +
                        " The Garden it full of lights and chairs, which is very enjoyable situation not like what you thinked of." +
                        " You can choose to enter from the back, side, or front. But because you want to go with him, the back door is too small." +
                        " You can either choose the side or from the front.",
                actions = listOf (
                    "Enter from the side.",
                    "Enter from the front."
                )
            ),

            // 4: with no Money
            Scene (
                "Entering Ruins of Building B",
                "You talk with him a bit, while walking in the Garden to the Ruins." +
                        " The Garden it full of lights and chairs, which is very enjoyable situation not like what you thinked of." +
                        " You can choose to enter from the back, side, or front. But because you want to go with him, the back door is too small." +
                        " You can either choose the side or from the front",
                actions = listOf (
                    "Enter from the side.",
                    "Enter from the front."
                )
            ),

            // 5: with no Swiper
            Scene (
                "Entering Ruins of Building B",
                "You go alone through the Garden on the way to the Ruins." +
                        " The Garden it full of lights and chairs, which is very enjoyable situation not like what you thinked of." +
                        " You can choose to enter from the back, side, or front. Oh! and from the top, because you go alone you can either go from the top" +
                        " or from the back side of the Ruins. Using powerful jumping skill you can reach the top easily... keep calm.",
                actions = listOf (
                    "Enter from the top.",
                    "Enter from the back."
                )
            ),

            // 6: Boots and Money from front
            Scene (
                "~Young and Rich~",
                "Inside the ruins, you found a merchant and pay him with your money you have," +
                        " as the one who pays for the parking is Boots. He brought you to a secret place..." +
                        " OH WOW! There are so much gold and treasures (chocolate). You bring as much as you can and return" +
                        " RICH and happily ever after.",
                actions = listOf (
                    MAIN_MENU,
                    TRY_AGAIN
                )
            ),

            // 7: With no Money and from side
            Scene (
                "~Young and Broke~",
                " Inside the ruins, you found a merchant and he asked you for some money, as you don't have any" +
                        " you just pass by and enter the ruins. As Building B is very hard to understand and you don't have anything" +
                        " to guide you. You just return to the first starting point over and over again.",
                actions = listOf (
                    MAIN_MENU,
                    TRY_AGAIN
                )
            ),

            // 8: Alone
            Scene (
                "~Final Life~",
                " You go and enter the ruins. There you face so so so many wild animals and angry persons." +
                        " All you can do is to pray for them to release you. You cannot have any help as you go inside alone..." +
                        " Just hope for the best to happen.",
                actions = listOf (
                    MAIN_MENU,
                    TRY_AGAIN
                )
            )
        )

        // Ending flags
        var ending1 = false
        var ending2 = false
        var ending3 = false

        // Utils
        lateinit var currentDisplayedEnding: Scene
    }
}