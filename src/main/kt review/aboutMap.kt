fun main() {
    // map
    val test = mutableMapOf("a" to 1, "b" to 2, "c" to 3)
    print(test)
    // use += can replace value with same key
    test += "a" to -1
    println(test)

    // use pair to create
    val test1 = mapOf(Pair("A", 1), Pair("B", 2), Pair("C", 3))
    println(test1)

    // use these methods to access value
    print("${test["a"]} ")
    print("${test.getValue("b")}   ")
    print("${test.getOrElse("d") { -1 }}   ")
    print("${test.getOrDefault("d", -2)}   ")


    // use this methods to assign value
    // =
    // +=
    // put(append or update)   putAll
    // getOrPut(get or append then get)
    // remove
    // -(similar to remove)
    // -=
    // clear


}