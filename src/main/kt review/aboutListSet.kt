// only list support Destructuring Declarations

fun main() {
    val names = listOf("a1", "b2", "c3")
    println("A: ${names[0]}, B:${names[1]}, C:${names[2]}")  // just like python
    println(names.last())
    println(names.first())


    // use getOrElse or getOrNull to avoid ArrayIndexOutOfBoundException
    println(names.getOrElse(4) {"Unknown Value0"})
    println(names.getOrNull(4) ?: "Unknown Value1")


    // find content by contains and containsAll
    println(names.contains("a1"))
    println(names.contains("d1"))
    println(names.containsAll(listOf("a1", "b2")))


    // use mutableListOf to create mutable list, no matter what you use,  val or var
    // all available mutator functions:
    // []=
    // add(element)
    // add(index, element)
    // addAll(list)
    // += element
    // -= element
    // clear
    // removeIf {lambda}
    val test1 = mutableListOf(1,2,3,4,5)
    var test2 = mutableListOf(6,7,8,9)
    println(test1.add(6))
    println(test1.add(3, 22))
    println(test1)
    println(test2.remove(8))
    println(test2)

    test1[0] = -1 // reassign
    println(test1)

    // traverse
    forLoopDemo(names)

    // destructing assignment
    DADemo()


    // Set
    setDemo()
}


// for loop, just like the same thing in python
private fun forLoopDemo(list: List<String>){
    for (element in list){
        print("$element+  ")
    }

    // forEach
    val temp = listOf(10, 11, 12, 13, 14, 15)
    temp.forEach { print("${it * it}  ")}

    // forEachIndexed   just like enumerate
    val temp2 = mutableListOf<Int>()
    temp.forEachIndexed {index, element -> temp2.add(element * index)}
    println(temp2)
}


// destructing assignment
private fun DADemo(){
    val test = listOf(1,2,3,4)
    val (a, b, _, d) = test
    println("a: $a, b:$b, d:$d")
}




// Set have no mutator functions
// You can't use [] to access element, you can only use elementAt(very slow)
private fun setDemo(){
    val test = setOf(1,2,3)
    val test1 = setOf(5,5,5,6,7)
    println("$test  ")
    print("$test1 ") // 5,6,7
    print(test.elementAt(1)) //2

    // mutable set can use
    // add addAll += -= remove removeAll clear
}



// You can use IntArray to use with Java
val demo: IntArray = intArrayOf(1,2,3,4,5)
// or use List.toIntArray
val demo2: IntArray = listOf(1,2,3,4).toIntArray()
// plus:
// you can use these types
// IntArray, DoubleArray, LongArray, ShortArray, ByteArray, FloatArray, BooleanArray, Array
