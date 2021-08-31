package com.study.bspatch

class NativeLib {

    external fun bsPatch(newFile: String, oldFile: String, patch:String): Boolean

    companion object {
        init {
            System.loadLibrary("bspatch")
        }
    }
}