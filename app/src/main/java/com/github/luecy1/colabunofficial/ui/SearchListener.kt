package com.github.luecy1.colabunofficial.ui

import com.github.luecy1.colabunofficial.model.SearchCondition

interface SearchListener {
    fun changeTab(searchCondition: SearchCondition)
}