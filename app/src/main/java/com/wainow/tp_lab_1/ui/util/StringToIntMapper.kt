package com.wainow.tp_lab_1.ui.util

object StringToIntMapper {
    fun map(input: String) =
        input
            .split(",")
            .toTypedArray()
            .map {
                it
                    .replace("\\s".toRegex(), "")
                    .toInt()
            }
}