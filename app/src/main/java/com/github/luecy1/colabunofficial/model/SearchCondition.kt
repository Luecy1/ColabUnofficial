package com.github.luecy1.colabunofficial.model

data class SearchCondition(
    val keyword: String
) {

    fun toMap(): Map<String, String> {

        val map = mapOf(
            "keywoed" to keyword
        )

        return map
    }
}