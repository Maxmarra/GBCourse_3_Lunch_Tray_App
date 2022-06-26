package com.example.lunchtray.data

import com.example.lunchtray.constants.ItemType
import com.example.lunchtray.model.MenuItem

/**
 * Map of available menu items to be displayed in the menu fragments.
 */
object DataSource {
    val menuItems = mapOf(
        "cauliflower" to
        MenuItem(
            name = "Цветная капуста",
            description = "описание",
            price = 7.00,
            type = ItemType.ENTREE
        ),
        "chili" to
        MenuItem(
            name = "Чили 'Три боба'",
            description = "описание",
            price = 4.00,
            type = ItemType.ENTREE
        ),
        "pasta" to
        MenuItem(
            name = "Паста с грибами",
            description = "описание",
            price = 5.50,
            type = ItemType.ENTREE
        ),
        "skillet" to
        MenuItem(
            name = "Кастрюля острых черных бобов",
            description = "описание",
            price = 5.50,
            type = ItemType.ENTREE
        ),
        "salad" to
        MenuItem(
            name = "Летний салат",
            description = "описание",
            price = 2.50,
            type = ItemType.SIDE_DISH
        ),
        "soup" to
        MenuItem(
            name = "Тыквенный суп",
            description = "описание",
            price = 3.00,
            type = ItemType.SIDE_DISH
        ),
        "potatoes" to
        MenuItem(
            name = "Острая картошка",
            description = "описание",
            price = 2.00,
            type = ItemType.SIDE_DISH
        ),
        "rice" to
        MenuItem(
            name = "Рис в кокосовом соку",
            description = "описание",
            price = 1.50,
            type = ItemType.SIDE_DISH
        ),
        "bread" to
        MenuItem(
            name = "Булочка",
            description = "описание",
            price = 0.50,
            type = ItemType.ACCOMPANIMENT
        ),
        "berries" to
        MenuItem(
            name = "Ягодная смесь",
            description = "описание",
            price = 1.00,
            type = ItemType.ACCOMPANIMENT
        ),
        "pickles" to
        MenuItem(
            name = "Консервированные овощи",
            description = "описание",
            price = 0.50,
            type = ItemType.ACCOMPANIMENT
        )
    )
}
