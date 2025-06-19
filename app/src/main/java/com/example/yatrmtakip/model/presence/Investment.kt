package com.example.yatrmtakip.model.presence

import java.util.Date

abstract class Investment(
    val name: String,
    val type: AssetType,
    val quantity: Double,
    val buyPrice: Double,
    val sellPrice: Double,
    val date: Date,
){
    abstract fun getValue(): Double
    abstract fun getDetails(): String

    open fun getProfitLoss(): Double {
        return (getUnitPrice() - buyPrice) * quantity
    }

    abstract fun getUnitPrice(): Double // her yatırımın anlık birim fiyatı
}