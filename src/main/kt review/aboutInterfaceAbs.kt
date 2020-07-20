// simple interface
interface Eatable{
    val name: String
    var nutrition: Int
    val price: Double
    // provide default implement
    fun eatPart(nut: Int){
        val canEat = nut < nutrition
        if (canEat){
            nutrition -= nut
        }
    }
}

class Bread: Eatable{
    override val name = "Bread"
    override var nutrition: Int = 4
    override val price: Double = 2.5
}

class Vegetable: Eatable{
    override val name: String = "Vegetable"
    override var nutrition: Int = 2
    override val price: Double = 1.2
}


fun main() {
    val f0 = Bread()
    val f1 = Vegetable()
    println("${f0.name} is $${f0.price}")
    println("${f1.name} is $${f1.price}")
    f0.eatPart(2)
    println("Eat 2, ${f0.name} remain ${f0.nutrition}")
}
