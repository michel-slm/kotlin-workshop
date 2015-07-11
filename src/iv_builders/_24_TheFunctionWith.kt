package iv_builders.examples

import java.util.HashMap
import util.TODO


fun todoTask24() = TODO(
    """
        Task 24.
        The previous examples can be rewritten with the library function 'with' (see examples below).
        Write your own implementation of the function 'with' named 'with2' or just think what it should be.
        (To check yourself you can rename the usages of 'with' in this file to 'with2' and launch the tests for this task.)
        Then look at the implementation in the library.
        Return 'true' from 'task24()' if you have successfully familiarized yourself with 'with' =).
    """
)

fun task24(): Boolean = true

fun <T, R> with2(resource: T, f: T.() -> R): R = resource.f()

fun buildString(): String {
    val stringBuilder = StringBuilder()
    with2 (stringBuilder) {
        append("Numbers: ")
        for (i in 1..10) {
            append(i)
        }
    }
    return stringBuilder.toString()
}

fun buildMap(): Map<Int, String> {
    val map = HashMap<Int, String>()
    with2 (map) {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
    return map
}
