package com.example.lunchtray.model

import java.text.NumberFormat

/**
 * Data class for menu items
 */
data class MenuItem(
    val name: String,
    val description: String,
    val price: Double,
    val type: Int
) {
    /**
     * Getter method for price.
     * Includes formatting.
     */
    fun getFormattedPrice(): String = NumberFormat.getCurrencyInstance().format(price)
}
