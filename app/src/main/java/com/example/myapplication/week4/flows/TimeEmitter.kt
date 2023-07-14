package com.example.myapplication.week4.flows

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object TimeEmitter{
    public fun getEmitter(time: Int): Flow<Int> {

        val emitter = flow<Int> {
            var curTime = time
            while (curTime >= 0) {
                delay(1000)
                emit(curTime)
                curTime--
            }
        }

        return emitter

    }




}