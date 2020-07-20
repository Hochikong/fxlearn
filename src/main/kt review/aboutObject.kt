fun main() {
    print("Enter your name: ")
    val pname = readLine()?:"Jack"
    print("Enter your gender: ")
    val isMale = readLine()?.run { contains("Male") } ?: false
    Game.play(pname, isMale)
}

// object is a singleton
object Game{
    init {
        println("Welcome all players!")
    }
    fun play(name: String, male: Boolean){
        Dragon.attack()
        println(Weapon.weaponStatus)
        val save = UserSave("D:/data", "ssdasdasdadsfwr")
        println("save: $save")
        val m = Monster("Snake")
        println("dragon to string: ${m.toString()}")

        // copy the data class while change value
        val save2 = save.copy(location = "D:/newdata")
        println(save2)
        // destruction assign
        val (x, y) = save2
        println("X: $x, Y: $y")


        println(LogLevel.DANGER)
        val tmp = LogLevel.DANGER.updatePath("D:/tmp", save2)
        println(save2)
        println(tmp)
        println(LogLevel.DANGER)

        // operator override
        println("D:/newdata/sb" in save2)  // true

        // sealed class
        eval(SealedExpr.Add)


        println("Your name is ${name}, gender is ${if (male) "Male" else "Female"}")
        print("> Enter your command: ")
        while (true){
            val read: String? = readLine()
            println("You action is ${read ?: "Nothing"}")
            print("> ")
            val exit:Boolean = read?.run { contains("exit") } ?: false
            if (exit){
                break
            }else{
                continue
            }
        }
    }
}

// use inherit to create a object
open class Monster(val name: String){
    open val skill:String = "attack"
    open fun attack(){
        println("Monster $name use $skill")
    }

    // you can override toString, equals and hashCode methods
    override fun toString(): String {
        return "This is a monster called $name"
    }
}

object Dragon : Monster("FireDragon"){
    override val skill: String = "FireBall"
    override fun attack() {
        println("FireDragon use $skill")
    }
}

// companion object
class Weapon{
    companion object{
        var weaponStatus = 10
    }
}


// data class
// data class can't be inherit
// you must use val or var in constructor
// you can't use abstract, open, sealed, inner
// usually when you need to override the equals and toString, you use data class
data class UserSave(val location:String, var content:String){
    val canSave = location.length > 1

    // operator override
    operator fun contains(path: String): Boolean{
        return path.contains(location)
    }
}


// enumerated class
enum class LogLevel(val save: UserSave){
    SAFE(UserSave("D:/safe", "A")),
    WARNING(UserSave("D:/Warning", "B")),
    DANGER(UserSave("D:/Dangerous", "C"));

    fun updatePath(path:String, save: UserSave) = save.copy(location = path)
}



// sealed class is a better enumerated class, can be inherit
// it can't be initial
sealed class SealedExpr{
    data class Person(val name : String, val age : Int) : SealedExpr()
    object Add : SealedExpr()
    companion object Minus : SealedExpr()
}

object NotANumber : SealedExpr()

// no need for else syntax!!!!
fun eval(expr: SealedExpr) = when(expr){
    is SealedExpr.Add -> println("is Add")
    is SealedExpr.Minus -> println("is Minus")
    is SealedExpr.Person -> println(SealedExpr.Person("Koltin",22))
    NotANumber -> println("Double.Nan")
}