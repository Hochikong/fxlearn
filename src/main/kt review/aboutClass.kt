import demo.Human

class Player{
    lateinit var pname:String
    val ttt by lazy { cal() }  // only one calculate
    // by default all members is public
    fun act(name: String){
        println("My name is $name")
    }

    private fun cal(): Int{
        return 454*34
    }

    // private setter
    fun sTest(cont: String){
        test = cont.trim()
    }

    // use define getter and setter
    var test = "ssdk"
        get() = field.toUpperCase()
        private set(value) {
            field = value.trim()
        }

    // calculate property
    val area
        get() = (1..6).shuffled().first() * (1..6).shuffled().last()
}

class Slayer(_name: String, val age: Int){
    init {
        require(_name.length > 1)
    }

    val name = _name
        get() = field.capitalize()
    // when class constructor parameters‘ contains val or var, can replace the code below
    // val age = _age

    // secondary constructor
    constructor(name: String) : this(name, 10)
}



// by default all objects is final

// equals to code below
/*open class DoomGuy constructor(val name: String, val age: Int, val career: String){
    // TODO
}*/

open class DoomGuy(val name: String, val age:Int, val career: String){
    // can accessed by self or sub classes
    protected open val weapon = "pisto"
    open fun shot(bullet: String){
        println("Shooting $bullet")
    }
}


class DoomSlayer : DoomGuy("Me", 24, "Student"){
    override fun shot(bullet: String) {
        println("Shooting $bullet in BFG10000")
    }
    override val weapon = super.weapon + " laser"
    private val weapons = listOf("BFG10000", weapon)
}

// all classes is sub classes of Any
fun main() {
    val p = Player()
    p.act("sb   ")
    p.pname = "cxk"
    println(p.pname)
    print("${p.test}   ")
    // When test's setter is private, you can't use it from outside of the class
    // p.test = "  sxc\n"
    p.sTest("  sxc\n")
    println("${p.test}  ")
    println("${p.area}  ${p.area}   ${p.area}")


    val s = Slayer("nmsl", 24)
    println("${s.name}  ${s.age}")

    val d = DoomGuy("He", 25, "Solider")
    val de:DoomGuy = DoomSlayer()  // 多态
    println("ds is dg: ${de is DoomGuy}  and ds is ds: ${de is DoomSlayer}")
    d.shot("holy")
    de.shot("shit")

    // type conversion
    // (de as DoomGuy).shot("fucking")

    // auto conversion
    println()
    autoConversion(d)
    autoConversion(de)
}

fun autoConversion(any: Any){
    // if `any is DoomSlayer` true, then auto conversion will do the job then you can use shot()
    if (any is DoomSlayer){
        any.shot("shitting")
    }else{
        (any as DoomGuy).shot("shitting")
    }
}
