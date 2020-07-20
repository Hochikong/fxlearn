import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeAll

class Test{
    companion object{
        @BeforeAll
        @JvmStatic
        fun beforAll() = println("JUnit 5 testing!!")
    }

    @Test
    fun testAdd(){
        assert(add(5,4) == 9)
        assert(add(10, 11) == 21)
    }
}