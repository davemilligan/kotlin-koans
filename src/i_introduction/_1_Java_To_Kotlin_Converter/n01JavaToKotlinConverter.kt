package i_introduction._1_Java_To_Kotlin_Converter

import util.TODO

fun todoTask1(collection: Collection<Int>): String {
//    var sb = StringBuilder()
//    sb.append("{")
//    val iterator = collection.iterator()
//    while (iterator.hasNext()) {
//        val element = iterator.next()
//        sb.append(element)
//        if (iterator.hasNext()) {
//            sb.append(", ")
//        }
//    }
//    for (item in collection) {
//        sb.append("${item}, ")
//    }
//    var str = sb.toString().subSequence(0, sb.toString().length - 2)
//    println("Substring: ${str}")
//    sb = StringBuilder(str)
//    sb.append("}")
//    return sb.toString()
    return collection.joinToString(prefix = "{", postfix = "}")
}

fun task1(collection: Collection<Int>): String {
    return todoTask1(collection)
}