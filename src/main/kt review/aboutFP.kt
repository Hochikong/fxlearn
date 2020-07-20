import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

fun main() {
    val split = "----------"

    // transform
    val animals = listOf("zebra", "giraffe", "elephant", "rat")
    // animal is elements of animals
    // baby is `A baby $animal`
    val babies = animals.map { animal -> "A baby $animal" }.map { baby -> "$baby, with the cuttest little tail ever!\n" }
    println(babies)
    println(listOf(listOf(1,2,3), listOf(4, 5, 6)).flatMap { it })
    println(split)

    // filter
    val itemsOfManyColor = listOf(listOf("red apple", "green apple", "blue apple"), listOf("red fish", "blue fish"),
    listOf("yellow banana", "teal banana"))
    val redItems = itemsOfManyColor.flatMap { it -> it.filter { it.contains("red") } }
    println(redItems)

    val numbers = listOf(7, 4, 8, 4, 3, 22, 18, 11)
    // if `number % it` return no zero, `none` return true
    val primes = numbers.filter { number -> (2 until number).map { number % it }.none {it == 0} }
    println(numbers.filter { it > 5 })
    println(primes)
    println(split)


    // reduce
    val employees = listOf("Denny", "Claudette", "Peter")
    val shirtSize = listOf("large", "x-large", "medium")
    val employeesShirtSizes = employees.zip(shirtSize).toMap()
    println(employeesShirtSizes)

    // fold, initValue = 0, return accumulated value
    val foldedValue = listOf(1,2,3,4).fold(0) {initValue, number ->
        println("Accumulated value: $initValue")
        initValue + (number*3)
    }
    println(foldedValue)


    // lazy sequence, similar to generator of python
    // using sequence is slower but save more memories, list is faster but cost more memories
    println(split)
    fun Int.isPrime(): Boolean{
        (2 until this).map {
            if (this % it == 0){
                return false
            }
        }
        return true
    }

    val costTimes = measureNanoTime {
        val oneHundredPrimes = generateSequence(3) { value ->
        value + 1 }.filter { it.isPrime() }.take(100)
        println(oneHundredPrimes.toList())
    }

    val costTimes1 = measureNanoTime {
        val oneHundredPrimes1 = (3..1000)
        val result = mutableListOf<Int>()
        for (element in oneHundredPrimes1){
            if (result.size >= 100){
                break
            }
            if (element.isPrime()){
                result.add(element)
            }
        }
        println(result)
    }

    val costTimes2 = measureNanoTime {
        val list = (3..10000).toList().filter { it.isPrime() }.take(1000)
        println(list)
    }

    println("Use sequence cost: $costTimes") // slow
    println("Use list cost: $costTimes1") // fastest
    println("Use list cost2: $costTimes2") // fast


    // another compare
    val cost01 = measureNanoTime {
        val words = "The quick brown fox jumps over the lazy dog".split(" ")
        val lengthsList = words.filter { println("filter: $it"); it.length > 3 }
                .map { println("length: ${it.length}"); it.length }
                .take(4)

        println("Lengths of first 4 words longer than 3 chars:")
        println(lengthsList)
    }

    val cost02 = measureNanoTime {
        val words = "The quick brown fox jumps over the lazy dog".split(" ")
        val wordsSequence = words.asSequence()
        val lengthsSequence = wordsSequence.filter { println("filter: $it"); it.length > 3 }
                .map { println("length: ${it.length}"); it.length }
                .take(4)
        println("Lengths of first 4 words longer than 3 chars")
        println(lengthsSequence.toList())
    }

    println("cost01: $cost01, cost02: $cost02")

}



