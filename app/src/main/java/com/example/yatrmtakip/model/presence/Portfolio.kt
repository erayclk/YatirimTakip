package com.example.yatrmtakip.model.presence

class Portfolio {
    private val investments = mutableListOf<Investment>()

    fun addInvestment(investment: Investment) {
        investments.add(investment)
    }

    fun totalValue(): Double {
        return investments.sumOf { it.getValue() }
    }

    fun totalProfitLoss(): Double {
        return investments.sumOf { it.getProfitLoss() }
    }

    fun printPortfolioDetails() {
        println("🔍 Portföy Detayları:\n")
        investments.forEach {
            println("${it.type} - ${it.getDetails()}")
            println("➡️  Anlık Değer: ${it.getValue()} USD")
            println("📊 Kar/Zarar: ${"%.2f".format(it.getProfitLoss())} USD\n")
        }
        println("💰 Toplam Portföy Değeri: ${"%.2f".format(totalValue())} USD")
        println("📈 Toplam Kar/Zarar: ${"%.2f".format(totalProfitLoss())} USD")
    }
}
