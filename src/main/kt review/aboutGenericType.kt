fun main() {
    val listOfInt: List<Int> = listOf(1,2,3)
    val lootBoxCoin: LootBox<Coin> = LootBox(Coin(10))
    val lootBoxSword: LootBox<Sword> = LootBox(Sword(8, "steel"))
    lootBoxSword.open = true
    lootBoxSword.fetch()?.run {
        println("You retrieve $materialType from the box")
    }
    val result = lootBoxSword.fetch() {
        Coin(it.value*2) // create a new object Coin with value 16(=8*2)
    }
    println(result?.value)


    // you can only place subclass of Food on this plate
    val plate:Plate<Food> = Plate(Water())
    // val plate1:Plate<Food> = Plate(Shit()) // you can't place shit on plate
    print(plate.eat())
    println("  the plate is clean: ${plate.clean}")


    // multiple foods on plate
    val plate1:PlatePlus<Food> = PlatePlus(Water(), Bread(), Meat())
    plate1.eat()
    plate1.eat()
    plate1.eat()
    println(plate1.clean)


    // `out` means read only producer, `in` means write only consumer
    inAndOutDemo()


    // reified
    println("---")
    println(testFunc(Water()))
}

// generic class
class LootBox<T>(item: T){
    private var loot: T = item
    var open = false

    fun fetch(): T?{
        return loot.takeIf { open }
    }

    // R means return
    fun <R> fetch(lootModFunction: (T) -> R): R?{
        return lootModFunction(loot).takeIf { open }
    }
}

class Coin(val value: Int)
class Sword(val value: Int, var materialType: String)



// generic type restrict
open class Food(val name: String, val nut: Int)
class Bread : Food("Bread", 8)
class Water : Food("Water", 1)
class Meat : Food("Meat", 10)
class Shit(val name: String = "Shit")

// a plate only for food
class Plate<T : Food>(private val item: T, var clean: Boolean = false){
    fun eat(){
        println("You are eating $item")
        clean = true
    }
}



// multiple parameters: vararg
class PlatePlus<T : Food>(vararg items: T, var clean: Boolean = false){
    private val contents: Array<out T> = items
    private val mutableContents:MutableList<T> = contents.toMutableList()

    fun eat(){
        val temp = mutableContents.removeAt(0)
        println("You ate $temp, plates remains $mutableContents")
        if (mutableContents.size < 1){
            clean = true
        }
    }
}



// `in` and `out`
// if T is out, item can't not use var, because `out` means read only
class PlateWithOut<out T>(val item: T)
class PlateWithIn<in T>(item: T)

fun inAndOutDemo(){
    val plateWater: Plate<Water> = Plate(Water())
    var plateFood: Plate<Food> = Plate(Meat())
    // plateFood = plateWater  // type mismatch, although Water is subclass of Food

    var pWIWater: PlateWithIn<Water> = PlateWithIn(Water())
    val pwIFood: PlateWithIn<Food> = PlateWithIn(Meat())
    // pwIFood = pWIWater // type mismatch, you can't retrieve water from food
    pWIWater = pwIFood // it works

    val pWIOWater: PlateWithOut<Water> = PlateWithOut(Water())
    var pWIOFood: PlateWithOut<Food> = PlateWithOut(Meat())
    pWIOFood = pWIOWater // it works
    val water: Water = pWIOFood.item  // smart cast from food to water
    println()
    println(water)
}



// About `reified`, you must use it with `inline`
// You can't use type check on T, generic type can't be read when the program is running
// called 类型擦除
// use reified can save generic type and check it. You don't need reflection tech like java
inline fun <reified T> testFunc(content: T): T?{
    val plate = listOf(Meat(), Bread(), Water())
    val first: Food = plate.shuffled().first()
    return if (first is T){
        first
    }else{
        null
    }
}
