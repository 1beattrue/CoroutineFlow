package edu.mirea.onebeattrue.coroutineflow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

suspend fun main() {
    getFlowByFlowOfBuilder().filter { it.isPrime() }
        .collect { println(it) } // терминальный метод (инициализирует поток)

    println()

    getFlowByFlowBuilder().filter { it.isPrime() }.collect { println(it) }
}

suspend fun Int.isPrime(): Boolean {
    if (this <= 1) return false
    delay(500)
    for (i in 2..this / 2) {
        if (this % i == 0) return false
    }
    return true
}

fun getFlowByFlowOfBuilder(): Flow<Int> {
    return flowOf(1, 2, 3)
}

fun getFlowByFlowBuilder(): Flow<Int> {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    return flow {
        list.forEach {
            emit(it)
        }
    }
}