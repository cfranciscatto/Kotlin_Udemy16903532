import kotlin.random.Random

fun main (args: Array<String>) {
    //letExample()
    //withExample()
    //runExample()
    //applyExample()
    //alsoExample()
    takeIfUnlessExample()
}

fun letExample() {
    // permite executar blocos de códigos no contexto de um objeto. Recebe um objeto (lambda) "it" representando o objeto

    val animals = listOf("dog", "cat", "snake", "rabbit", "bear", "mouse")
    // map to length, filter length>3, print the result lengths
    animals.map {it.length}
        .filter {it >3}
        .let {      // otherName ->  // used to rename the default 'it' to 'otherName'
            println(it)
            println("Size of list is ${it.size}")
        }

    // the same as previous
    animals.map {it.length}
        .filter {it >3}
        .let(::println)

    // commonly used to change null objects to non-null
    println("Type your name")
    val name : String? = readLine()
    name?.let {
        println("Your name is $name")
    }

    println("Input a number")
    val input : String? = readLine()
    input?.let {
        val number = it.toInt()
        println("The double of your number is ${number * 2}")
    }

    val animals1 = arrayListOf<String?>()
    for (i in 1..3) {
        println("Input an animal")
        val input1 : String? = readLine()
        input1?.let {
            if(it == "") {
                animals1.add(null)
            } else {
                animals1.add(it)
            }
        }
    }

    animals1.forEach {
        it?.let {
            println("Feeding the $it")
        }
    }

    val clients = arrayListOf<String?>()
    do {
        println("Enter client name")
        val client : String? = readLine()
        client?.let {
            if (it.toLowerCase() != "stop") {
                if (it == "") {
                    clients.add(null)
                } else {
                    clients.add(it)
                }
            }
        }
    } while (client?.toLowerCase() != "stop")
    println(clients)

    clients.forEach {
        it?.let {
            println("Hello  $it")
        }
    }
}

fun withExample() {
    // similar ao let. Parecido com o "this". Permite acessar metodos e variaveis de um objeto
    // geralmente usado na inicializacao do objeto ou em uma sequencia de acoes num objeto
    with (Car()) {
        speed = 80      // acessa "this" do objeto Car criado
        drive()
    }

    val student = Student()
    with (student) {
        firstName = "Michael"
        lastName = "Jordan"
        age = 15
        printInfo()
    }
}

fun runExample() {
    // Igual ao with (e ao let), mas permite chamar uma funcao extensiva
    // util qdo precisa de um lambda que retorne um valor
    // limita o escopo de um objeto

    val car = Car().run {
        speed = 90      // acessa "this" do objeto Car criado
        drive()
        this            // retorna o objeto Car criado
    }
    println(car)

    run { // limitando escopo... car só é valido no bloco
        val newCar = Car()
        newCar.speed = 30
        newCar.drive()
    }
}

fun applyExample() {
    // usado para aplicar uma funcionalidade no objeto e retorná-lo
    // retorna o objeto incial
    // geralmente usado para configurar um objeto

    val car = Car().apply {
        speed = 80      // acessa "this" do objeto Car criado
        color = "red"
        drive()
    }
    println(car)
}

fun alsoExample() {
    // similar ao apply, mas usado para executar alguma funcionalidade que
    // nao altere o objeto
    // geralmente usado para log

    val car = Car().apply {
        speed = 80      // acessa "this" do objeto Car criado
        color = "blue"
        drive()
    }
    .also {
        println("Car is running and car speedy is ${it.speed}")
    }
}

fun takeIfUnlessExample() {
    // takeIf -> retorna o valor do objeto se o predicado for true ou entao retorna null
    // takeUnless -> oposto ao takeIf, retorna objeto se pred. for false

    for (i in 1..10) {
        val number = Random.nextInt(100)
        val evenOrNull = number.takeIf { it % 2 == 0 }
        val oddOrNull = number.takeUnless { it % 2 == 0 }
        println("The number is $number")
        println("The even number is $evenOrNull")
        println("The odd number is $oddOrNull")
    }

    val clients = listOf( "Alice", "Bob", "Charles", "Alex", "Michael")
    println(clients)
    val clients_A = arrayListOf<String>()
    for (client in clients) {
        client.takeIf { it[0] == 'A' }
            ?.let {clients_A.add(it)}
    }
    println(clients_A)
}

class Car {
    var speed = 50
    var color = "blue"
    fun drive() {
        println("Driving the $color car at $speed")
    }
}

class Student {
    var firstName = ""
    var lastName = ""
    var age = 0

    fun printInfo() {
        println("$firstName $lastName is $age")
    }

}