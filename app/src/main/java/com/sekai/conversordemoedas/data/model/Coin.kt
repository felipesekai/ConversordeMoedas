package com.sekai.conversordemoedas.data.model

import java.util.*

enum class Coin(val locale: Locale) {
    Dollar(Locale.US),
    DollarCAD(Locale.CANADA),
    Real(Locale("pt", "BR")),
    PesoARS(Locale("es", "AR"))
    ;

    companion object {
        fun getByName(name: String) = values().find { it.name == name } ?: Real
    }
}