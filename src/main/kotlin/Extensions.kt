fun main (args: Array<String>) {
    val name = "Michael"
    println(name.slim())
    println(name.betterLength)

    println(3.getCustomName())
    println(2.6F.getCustomName())

    Book.printMe()

    String.getClassType()
}

// add methods to a class
fun String.slim() = this.substring(1,length-1)

// add attributes to a class - just val atributes. It can be initialized
val String.betterLength: Int
    get() = 200

fun Int.getCustomName() = "Integer number"

fun Float.getCustomName() = "Float number"


// companion objects -> permite criar metodos/atributos estaticos
class Book {
    companion object {}
}

fun Book.Companion.printMe() {
    println("Book has been printed")
}

fun String.Companion.getClassType() {
    println("This is a String class")
}