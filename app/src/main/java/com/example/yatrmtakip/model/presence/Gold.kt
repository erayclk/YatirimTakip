package com.example.yatrmtakip.model.presence

import java.util.Date

class Gold(
    name: String,
    quantity: Double,
    buyPrice: Double,
    sellPrice: Double,
    buyDate: Date,
) : Investment(name, AssetType.GOLD, quantity, buyPrice, sellPrice,buyDate) {

    override fun getValue(): Double = quantity * sellPrice

    override fun getUnitPrice(): Double = sellPrice

    override fun getDetails(): String {
        return "Altın: $quantity gr, alış: $buyPrice, satış: $sellPrice"
    }
}
