import kotlin.random.Random

fun main (args: Array<String>) {
    isAsExample()
    lateinitExample()
    lazyExample()
}

fun isAsExample() {
    val value = "This is a String"
    if (value is String)
        println("This string has ${value.length} characters")
    // type e var devem ser da mesma hierarquia de classes.
    // O código abaixo dá erro, pois variável é int e o type avaliado é int.
    // val value = 2
    // if (value is String)

    val myCar = getCar()
    if (myCar is BMW) {
        println("This is not my favorite brand")
    }

    if (myCar is BMW) {
        (myCar as Car1).drive()
    }

    val bmwCar = myCar as? Audi
    bmwCar?.drive()

    for (i in 1..10) {
        println("$i.")
        val service = getNetworkService()
        (service as? FTPService)?.transferFile()
    }

    val animals = getAnimals()
    animals.forEach { animal ->
        (animal as? Dog1)?.bark()
        (animal as? Cat1)?.purr()
    }

}

fun lateinitExample() {
    // variáveis lateinit são definidas, porém inicializadas somente em um momento mais adiante.
    // o desenvolvedor "garante" que vai inicializá-la antes de usá-la.
    // usada geralmente quando seu valor depende de outros processamentos

    lateinit var service: NetworkService
    //println(service) //exception
    service = getNetworkService()
    println(service)

    val country = Country().apply { setName("Germany") }
    println("Hello ${country.getName()}")

    lateinit var message : String
    var primeNumbers = getPrimeNumbers()
    message = "The chosen prime number is ${selectPrimeNumbers(primeNumbers)}"
    println(message)
}


fun lazyExample() {
    // variáveis lazy são inicializadas somente quando necessárias
    // usada para variáveis com grande quantidade de dados com objetivo de economizar memória

    val bigBuffer: String by lazy {"big data"}
    if (Random.nextInt() % 2 == 0) {
        println(bigBuffer)  // variavel é carregada na memória somente neste ponto
    }

    val list by lazy {getPrimeNumbers()}
    println("Print prime numbers")
    println(list)
}

fun getPrimeNumbers(): List<Int> {
    println("getPrimeNumbers")
    return listOf(1,2,3,5,7,11,13,17,19)
}

fun selectPrimeNumbers(primes: List<Int>) = primes.random()

fun getCar(): Car1 = BMW()

open class Car1() {
    open fun drive() {
        println("Driving my Car")
    }
}

class BMW: Car1() {
    override fun drive() {
        println("Driving my BMW")
    }
}

class Audi: Car1() {}

open class NetworkService() {}

class FTPService : NetworkService()  {
    fun transferFile() {
        println("Transfering file via FTP")
    }
}

fun getNetworkService() : NetworkService {
    return if(Random.nextInt() % 2 == 0)
        NetworkService()
    else
        FTPService()
}

abstract class DomesticAnimal();
class Dog1 : DomesticAnimal() {
    fun bark() {
        println("Dog is barking")
    }
}

class Cat1 : DomesticAnimal() {
    fun purr() {
        println("Cat is purring")
    }
}

fun getAnimals(): ArrayList<DomesticAnimal> {
    val animals = arrayListOf<DomesticAnimal>()
    for (i in 1..20) {
        animals.add(if(Random.nextInt() % 2 == 0)
            Dog1()
        else
            Cat1())
    }
    return animals
}

class Country() {
    private lateinit var name: String

    fun setName(name: String) {
        this.name = name
    }

    fun getName() = name
}