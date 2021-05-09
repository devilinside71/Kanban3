package com.hmei.kanban


internal interface Listener {
    fun setEmptyListTop(visibility: Boolean)
    fun setEmptyListBottom(visibility: Boolean)
}