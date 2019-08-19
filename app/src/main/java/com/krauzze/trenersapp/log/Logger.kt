package com.krauzze.trenersapp.log

import android.util.Log
import com.krauzze.trenersapp.BuildConfig
import okhttp3.Request
import okio.Buffer

object Logger {

    inline fun v(tag: String, message: String) {
        if (BuildConfig.IS_USE_LOG)
            Log.v(tag, message)
    }


    inline fun v(tag: String, message: () -> String) {
        if (BuildConfig.IS_USE_LOG)
            Log.v(tag, message())
    }

    inline fun v(tag: String, request: Request) {
        if (BuildConfig.IS_USE_LOG) {
            val byteBuffer = Buffer()
            request.body()?.writeTo(byteBuffer)
            Log.v(tag, "${request.method()}:${request.url()}, Body:\n${byteBuffer.readUtf8()}")
        }
    }

    inline fun e(tag: String, message: () -> String) {
        if (BuildConfig.IS_USE_LOG)
            Log.v(tag, message())
    }

    inline fun w(tag: String, message: () -> String) {
        if (BuildConfig.IS_USE_LOG)
            Log.v(tag, message())
    }

    inline fun i(tag: String, message: () -> String) {
        if (BuildConfig.IS_USE_LOG)
            Log.i(tag, message())
    }

    inline fun i(tag: String, message: String) {
        if (BuildConfig.IS_USE_LOG)
            Log.i(tag, message)
    }

}