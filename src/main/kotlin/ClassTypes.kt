fun main (args: Array<String>) {
    //dataClassExample()
    //enumClassExample()
    //sealedClassExample()
    nestedClassExample()

}

fun dataClassExample() {
    val user = User( "Name", "user@server.com", "123456")
    println(user)

    println( "Regular class")
    val userR1 = RegularUser( "Name", "user@server.com", "123456")
    val userR2 = RegularUser( "Name", "user@server.com", "123456")


    println( "userR1 == userR2: ${userR1 == userR2}")  // .equals -> compares the reference
    println( "userR1.toString() $userR1")              // .toString -> prints the reference

    println()
    println()
    println( "Data class")
    val user1 = User( "Name", "user@server.com", "123456")
    val user2 = User( "Name", "user@server.com", "123456")
    val user3 = user1.copy(password = "asdfqwer")         // .copy -> copy from user1 but changed the password

    println( "user1 == user2: ${user1 == user2}")         // .equals -> compares the data
    println( "user1.toString() $user1")                   // .toString -> prints the data
    println( "user3.toString() $user3")                   // .copy -> copy from user1 but changed the password
}

class RegularUser(
    // this a regular "class" not a "data class"
    val name: String,
    val email: String,
    val password: String
)

data class User(
    val name: String,
    val email: String,
    val password: String

    // Default methods:
    // .equals() -> compare data not object references
    // .toString() ->
    // .copy() -> copy from other data class, but allows change an attribute
)


fun enumClassExample() {
    val color = Color.GREEN;
    when (color) {
        Color.BLUE -> {
            println("Blue")
        }
        Color.GREEN -> {
            println("Green")
        }
        Color.RED -> {
            println("Red")
        }
    }

    val colorExt = ColorExt.BLUE;
    when (colorExt) {
        ColorExt.BLUE -> {
            println(ColorExt.BLUE.name)
            println(ColorExt.BLUE.ordinal)
            println(ColorExt.BLUE.min)
            println(ColorExt.BLUE.max)
        }
        ColorExt.GREEN -> {
            println(ColorExt.GREEN.name)
            println(ColorExt.GREEN.ordinal)
            println(ColorExt.GREEN.min)
            println(ColorExt.GREEN.max)
        }
        ColorExt.RED -> {
            println(ColorExt.RED.name)
            println(ColorExt.RED.ordinal)
            println(ColorExt.RED.min)
            println(ColorExt.RED.max)
        }
    }

}

enum class Color {
    RED,
    BLUE,
    GREEN
}

enum class ColorExt(val min:Int, val max:Int) {
    // Enum constants can be initialized -> ColorExt(val a1:Int, val a2:String, val aN:typeN)
    // constants have properties like:
    // name  -> the constant name (RED, GREEN, BLUE)
    // ordinal -> the constant sequence inside the class (RED = 0, BLUE=1, GREEN=2)
    // a1,a2,aN -> valores definidos na inicializacao
    RED (1,10),
    BLUE (11,20),
    GREEN (21,30)
}

fun sealedClassExample() {
    // sealed classes nao podem ser inicializadas, mas podem ser herdadas
    // geralmente usadas para criar hierarquias e usadas em condições "when"

    val somePlant = getPlant()
    when (somePlant) {
        is Fruit -> println("Fruit")
        is Vegetable -> println("Vegetable")
    }
}

fun getPlant(): Plant = Apple()

abstract class Plant

sealed class Fruit : Plant()

sealed class Vegetable : Plant()

class Apple : Fruit()

class Potato : Vegetable()

fun nestedClassExample() {
    // nested classes permitem criar inner classes dentro de um classe (outer class)
    // inner classes podem acessar métods/atributos da outer class usando this@
    // outer class podem criar instancias das inner classes
    val motorCycle = MotorCycle()
    motorCycle.drive()
}

class MotorCycle() {
    private val engine = Engine()
    var speed = 100
    fun drive() {
        engine.run()
        println("driving at $speed")
    }

    private inner class Engine() {
        val rpm = 300
        fun run() {
            println("Engine at $rpm")
            this@MotorCycle.speed = 50
        }
    }
}
