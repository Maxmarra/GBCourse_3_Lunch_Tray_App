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
            name = "Cauliflower",
            description = "Whole cauliflower, brined, roasted, and deep fried",
            price = 7.00,
            type = ItemType.ENTREE
        ),
        "chili" to
        MenuItem(
            name = "Three Bean Chili",
            description = "Black beans, red beans, kidney beans, slow cooked, topped with onion",
            price = 4.00,
            type = ItemType.ENTREE
        ),
        "pasta" to
        MenuItem(
            name = "Mushroom Pasta",
            description = "Penne pasta, mushrooms, basil, with plum tomatoes cooked in garlic and " +
                    "olive oil",
            price = 5.50,
            type = ItemType.ENTREE
        ),
        "skillet" to
        MenuItem(
            name = "Spicy Black Bean Skillet",
            description = "Seasonal vegetables, black beans, house spice blend, served with avocado " +
                    "and quick pickled onions",
            price = 5.50,
            type = ItemType.ENTREE
        ),
        "salad" to
        MenuItem(
            name = "Summer Salad",
            description = "Heirloom tomatoes, butter lettuce, peaches, avocado, balsamic dressing",
            price = 2.50,
            type = ItemType.SIDE_DISH
        ),
        "soup" to
        MenuItem(
            name = "Butternut Squash Soup",
            description = "Roasted butternut squash, roasted peppers, chili oil",
            price = 3.00,
            type = ItemType.SIDE_DISH
        ),
        "potatoes" to
        MenuItem(
            name = "Spicy Potatoes",
            description = "Marble potatoes, roasted, and fried in house spice blend",
            price = 2.00,
            type = ItemType.SIDE_DISH
        ),
        "rice" to
        MenuItem(
            name = "Coconut Rice",
            description = "Rice, coconut milk, lime, and sugar",
            price = 1.50,
            type = ItemType.SIDE_DISH
        ),
        "bread" to
        MenuItem(
            name = "Lunch Roll",
            description = "Fresh baked roll made in house",
            price = 0.50,
            type = ItemType.ACCOMPANIMENT
        ),
        "berries" to
        MenuItem(
            name = "Mixed Berries",
            description = "Strawberries, blueberries, raspberries, and huckleberries",
            price = 1.00,
            type = ItemType.ACCOMPANIMENT
        ),
        "pickles" to
        MenuItem(
            name = "Pickled Veggies",
            description = "Pickled cucumbers and carrots, made in house",
            price = 0.50,
            type = ItemType.ACCOMPANIMENT
        )
    )
}
