package vi_generics

import util.TODO
import java.util.*
import kotlin.collections.HashSet

fun task41(): Nothing = TODO(
    """
        Task41.
        Add a 'partitionTo' function that splits a collection into two collections according to a predicate.
        Uncomment the commented invocations of 'partitionTo' below and make them compile.

        There is a 'partition()' function in the standard library that always returns two newly created lists.
        You should write a function that splits the collection into two collections given as arguments.
        The signature of the 'toCollection()' function from the standard library may help you.
    """,
        references = { l: List<Int> ->
            l.partition { it > 0 }
            l.toCollection(HashSet<Int>())
        }
)

fun <T, C: MutableCollection<T>> Collection<T>.partitionTo(ca: C, cb: C, f: (T) -> Boolean): Pair<C, C> {
    for (ele in this) {
        if(f(ele)) {
            ca.add(ele)
        } else {
            cb.add(ele)
        }
    }
    return Pair(ca, cb)
}

fun List<String>.partitionWordsAndLines(): Pair<Collection<String>, Collection<String>> {
    return partitionTo(ArrayList<String>(), ArrayList<String>()) { s -> !s.contains(" ") }
}

fun Set<Char>.partitionLettersAndOtherSymbols(): Pair<Collection<Char>, Collection<Char>> {
    return partitionTo(HashSet<Char>(),HashSet<Char>())  { c -> c in 'a'..'z' || c in 'A'..'Z'}
}