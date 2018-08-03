package v_builders

import util.TODO
import java.util.*

fun main(args: Array<String>) {
    println(buildStringExample())
}

fun buildStringExample(): String {
    fun buildString(build: StringBuilder.() -> Unit): String {
        val stringBuilder = StringBuilder()
        stringBuilder.build()
        return stringBuilder.toString()
    }

    return buildString {
        this.append("Numbers: ")
        for (i in 1..10) {
            // 'this' can be omitted
            append(i)
        }
    }
}

fun todoTask37(): Nothing = TODO(
    """
        Task 37.
        Uncomment the commented code and make it compile.
        Add and implement function 'buildMap' with one parameter (of type extension function) creating a new HashMap,
        building it and returning it as a result.
    """
)

/**
 * Just for fun, added a nullable prefix string for prepending to values. Of no value
 * but interesting to see how it behaved.
 */
fun <K,V> buildMap(prefix: String? = null, buildMap: MutableMap<K, V>.(String?) -> Unit): Map<K, V>  {
    val bm = HashMap<K, V>()
    bm.buildMap(prefix)
    return bm
}


fun task37(): Map<Int, String> {
    return buildMap() { it ->
        for (i in 0..10) {
            if (it == null)
                put(i,"$i")
            else
                put(i,"$it $i")
        }
    }
}
