package edu.mirea.onebeattrue.coroutineflow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

suspend fun main() {
    val flow = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).asFlow() // аналог sequence, используется для работы с coroutine'ами
    flow.filter { it.isPrime() }
        .map { it * 10 }
        .collect { println(it) }
}

suspend fun Int.isPrime(): Boolean {
    if (this <= 1) return false
    delay(500)
    for (i in 2..this / 2) {
        if (this % i == 0) return false
    }
    return true
}