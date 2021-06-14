fun main (args: Array<String>) {
    val box = Box<String>()
    box.display("String argument")

    val toyBox = Box<Toy>()
    toyBox.display(Toy())

    val mapBox = MapBox<Int, Toy>()
    mapBox.display(1, Toy())

    val info1 = Info<Int>()
    info1.getLength(10)

    val info2 = Info<Double>()
    info2.getLength(1345.563)

    val info3 = Info<String>()
    info3.getLength("String")

    val info4 = Info<Box<Toy>>()
    info4.getLength(toyBox)

    val info5 = Info<ArrayList<Int>>()
    info5.getLength(arrayListOf<Int>(2,3,5,7,4,67,87))

    val chef1 = Chef<Peach>()
    chef1.cook(Peach())

    val chef2 = Chef<Kiwi>()
    chef2.cook(Kiwi())

    //val chef3 = Chef<Apple>()   // Erro: Apple implementa Fruit

    val printer1 = Printer<Set<String>>()
    printer1.iterate(hashSetOf("Bob", "John", "Michael"))

    val printer2 = Printer<List<String>>()
    printer2.iterate(listOf("Dog", "Cat", "Lion"))

    val geometry1 = Geometry<Square>()
    geometry1.printArea(Square(), 23)

    val geometry2 = Geometry<Circle>()
    geometry2.printArea(Circle(), 23)

}

// Classe pode ter argumento de type
// O type pode ser usado por metodos e variaveis
// Usado quando a classe manipula diversos tipos de parametros
// Multiplos argumentos podem ser usados, separados por virgula (,)
// Possibilita restringir o tipo de parametro (por exemplo ClassXPTO e suas derivacoes)
//
// Ex: ArrayList pode manipular diversos types, então recebe o type quando a variavel ArrayList for definida
//   val arg1 = ArrayList<T> = arrayListOf(objT_1, objT_2, objT_3)
//   val animals: ArrayList<String> = arrayListOf("cachorro", "gato", "elefante")
// Ex: hashMap possui 2 argumentos
//   val map = hashMapOf<Int, String>()

class Box<T> {                  // Define que a classe pode ser de qq tipo
    fun display(item: T) {      // o metodo aceita argumentos do tipo que a classe for definida
        println(item)
    }
}

class MapBox<T, U> {
    fun display(id: T, item: U) {      // o metodo aceita argumentos do tipo que a classe for definida
        println("id: $id item: $item")
    }
}

class Toy

class Info<T> {
    fun getLength(item: T) {
        println(item.toString().length)
    }
}

abstract class Fruit2 {
    abstract fun peel()
}

class Peach: Fruit2() {
    override fun peel() {
        println("Peeling the Peach")
    }
}

class Kiwi: Fruit2() {
    override fun peel() {
        println("Peeling the Kiwi")
    }
}

class Chef<T:Fruit2> {  // só pode implementar tipos derivados de Fruit2 (inclusive)
    fun cook(item:T) {
        item.peel()
    }
}

class Printer<T: Collection<String>> {
    fun iterate(collection: T) {
        collection.forEach {println(it)}
    }
}

abstract class Shape (){
    abstract fun getArea(size: Int): Double
}

class Square(): Shape() {
    override fun getArea(size: Int) = size * size.toDouble()
}

class Circle(): Shape() {
    override fun getArea(size: Int) = size * size * 3.1416
}

class Geometry<T: Shape> {
    fun printArea(shape: T, size: Int) {
        println("The area of this shape is ${shape.getArea(size)}")
    }
}