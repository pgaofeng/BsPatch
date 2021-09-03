package com.study.bspatch

import java.io.FileInputStream
import java.security.MessageDigest

/**
 * 差分工具类
 */
object PatchUtils {

    /**
     * 十六进制数，在生成md5值的时候使用
     */
    private val hex =
        arrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')

    init {
        System.loadLibrary("bspatch")
    }

    /**
     * 注意，该方法是一个耗时操作，不要放到主线程中去。
     *
     * 根据旧文件和差分包文件合并成新的文件
     * [newFile] 合并后的文件，应该是一个具体的文件路径
     * [oldFile] 旧文件的路径，应该是一个具体的文件路径
     * [patch]   差分包文件，应该是一个具体的文件路径
     *
     * 合并成功则返回true，否则返回false
     */
    external fun bsPatch(newFile: String, oldFile: String, patch: String): Boolean

    /**
     * 计算给定文件[path]的md5值，大写。
     * 得到差分包之后，最好使用md5进行验证一下包是否完整，从而提高合并的成功率
     */
    fun md5sum(path: String): String {
        val digest = MessageDigest.getInstance("MD5")
        FileInputStream(path).use {
            val buffer = ByteArray(1024)
            var len: Int
            while (it.read(buffer).apply { len = this } != -1) {
                digest.update(buffer, 0, len)
            }
        }
        val md5Array = digest.digest()
        val sb = StringBuilder()
        for (bit in md5Array) {
            val high = (bit.toInt() ushr 4) and 0xF
            val low = bit.toInt() and 0xF
            sb.append(hex[high]).append(hex[low])
        }
        return sb.toString()
    }
}