fun main (args: Array<String>) {
    //carTest()
    //animalTest()
    //mathTest()
    //jetPackTest()
    //testObject()
    //testInheritance()
    testClasses()
}

fun carTest() {
    val myCar: Vehicle = Vehicle()
    val yourCar = Vehicle()

    myCar.model = "Jagar"
    yourCar.model = "Mercedes"

    myCar.start()
    myCar.drive(159)

    yourCar.start()
    yourCar.drive(258)
}

class Vehicle {
    var model: String? = null
    var topSpeed = 100

    fun start() {
        println("Starting the $model")
    }

    fun drive( speed: Int) {
        println("Driving at a speed of $speed")
    }

}


fun animalTest() {
    val cat = Animal()
    cat.run()

    cat.name = "Cat"
    cat.topSpeed = 40
    cat.run()
}


class Animal {
    var name = "Animal"
    var topSpeed = 0

    fun run() {
        println("This animal's top speed is $topSpeed")
    }
}

fun mathTest() {
    val math = Math()
    println("6 + 3 = ${math.add(6,3)}")
    println("6 - 3 = ${math.sub(6,3)}")
    println("6 * 3 = ${math.mul(6,3)}")
    println("6 / 3 = ${math.div(6,3)}")
}


class Math {
    fun add (a:Int, b:Int) = a + b
    fun sub (a:Int, b:Int) = a - b
    fun mul (a:Int, b:Int) = a * b
    fun div (a:Int, b:Int) = a / b
}

fun jetPackTest() {
    val jetPack = JetPack()
    jetPack.burn(20)
    println("User height is ${jetPack.userHeight}")
    jetPack.burn(20)
    println("User height is ${jetPack.userHeight}")
    jetPack.stop(2)
    println("User height is ${jetPack.userHeight}")
    jetPack.burn(5)
    println("User height is ${jetPack.userHeight}")
    jetPack.stop(12)
    println("User height is ${jetPack.userHeight}")
}


class JetPack {
    var userHeight = 0

    fun burn (seconds: Int) {
        println("Burning for $seconds seconds")
        userHeight += seconds
    }

    fun stop (seconds: Int) {
        println("Stopping for $seconds seconds")
        userHeight -= 3 * seconds
        if (userHeight < 0)
            userHeight = 0
    }
}

/*
    The "object" construct
    A class can be instantiated -> the instance is called an object
    An object is a static class -> All methods and variables can be accessed without an instance
    Singleton -> one instance of a class
 */
fun testObject() {
    DatabaseAccess.connect()
    DatabaseAccess.disconnect()
}

object DatabaseAccess {
    var connected = false;
    fun connect() {
        connected = true
        println("Connected to database")
    }
    fun disconnect() {
        connected = true
        println("Disconnected from database")
    }
}

/*
 open classes allow the class to be inherited
 */
fun testInheritance() {
    val myDog = Corgi()
    myDog.size = 15
    println(myDog.size)
    myDog.bark()
    myDog.play()

    var B777 = Boeing()
    var A380 = Airbus()

    B777.name = "Boeing 777"
    B777.speed = 900

    A380.name = "Airbus A380"
    A380.speed = 880

    B777.ascend()
    A380.descend()
    B777.descend()
    B777.descend()
    A380.ascend()
    B777.ascend()

}

open class Dog {
    var size: Int = 0

    fun bark() {
        println("Bark")
    }
    fun play() {
        println("Play")
    }
}

class Corgi: Dog() {

}

open class Airplane {
    var name = "Generic"
    var speed = 850
    var altitude = 20000
    open val altitudeStep = 1000

    fun ascend() {
        altitude += altitudeStep
        println("$name has an altitude of $altitude and speed $speed")
    }

    fun descend() {
        altitude -= altitudeStep
        println("$name has an altitude of $altitude and speed $speed")
    }
}

class Boeing: Airplane() {
    override val altitudeStep = 800
}

class Airbus: Airplane() {
    override val altitudeStep = 1200

}

/*

    Constructors
     - Defines a set variable that are available at the creation of an object
     - Primary constructor - Defined directly on the class definition ["class ClassName(param1: String) {...}]
        The primary constructor cannot contain any code. Initialization code can be placed in init blocks
     - Multiples (Secondaries) constructors - Uses "constructor" keyword - used depending on parameters
        When Primary constructor is defined, secondary constructors must refer to the primary constructor  [constructor(param1: String, param2: Int) : this (param1)]
    Getters and Setters
     - Change the way variable are assigned and retrieved
     - The set/retrieved value could be modified (No sense, but its possible)
     - Others variables can be modified in the get/set of a specific variable
    Init block
     - First code to be executed while creating a class (before the constructor)
     - Multiple blocks - During an instance initialization, the initializer blocks are executed in the same order as they appear in the class body
    Companion object
     - static code

    OOP principles
    - Inheritance
        open keyword - indicates class / method can be inherited / override
        override keyword - over ride a method defined as open in the parent class
    - Encapsulation - Blackbox - other classes don't need to know how something is done
        Modifiers / Scopes: (changes the visibility of the methods and variables)
        - private: inside the class
        - protected: inside class and inheriting classes
        - internal: inside the package
        - public: everyone accessing the class  (default modifier)
    - Abstraction - common feature of 2 class should be abstracted in a third class
        2 classes share common features... Creates a super class that contains the common feature and inherit from it
        abstract keyword
        use interfaces
    - Polymorphism - same name many forms
        - A method can do different things in different situation
        - Types
            Dynamic -> method overriding - Derivated class overrides the Base class method
            Static -> Method overloading - Class has multiple methods with the same name, but different arguments
 */

fun testClasses() {

    Person.printVersion()

    val customer1 = Customer("John")
    val customer2 = Customer("Mike", 30)
    val customer3 = Customer("Judy", 25, 5.2)

    customer1.printInfo()
    customer2.rate = 6.9
    customer2.printInfo()
    customer3.printInfo()


    val myLock = EncryptionLock(40)
    println("Does the key 50 unlock my lock: ${myLock.unlock(50)}")
    println("Does the key 60 unlock my lock: ${myLock.unlock(60)}")
    println("Does the key 70 unlock my lock: ${myLock.unlock(70)}")
    println("Does the key 80 unlock my lock: ${myLock.unlock(80)}")


    // abstraction
    val bottle: Container = Bottle()
    val jug: Container = Jug()

    bottle.fill()
    bottle.pour()
    jug.pour()
}

open class Person (personName: String) {
    var name: String?= null
    // var name: String?= personName    // Also valid....

    init {
        name = personName
        println()
        println("Init - New Person $name")
    }

    open fun printInfo() {
        println("Person name: $name")
    }

    companion object {
        fun printVersion() {
            println("Person class version 1.32.56")
        }
    }

}

class Customer(name: String): Person(name) {

    init {
        println("Init - New customer $name")
    }

    constructor(newName: String, newAge: Int) : this(newName) {
        age = newAge
        println("Parameters: Name and Age")
    }

    constructor(newName: String, newAge: Int, newRate: Double) : this(newName, newAge) {
        rate = newRate
        println("Parameters: Name, Age and Rate")
    }

    var info: String? = null
    var age: Int = 0

    var rate = 0.0
        get() = field // it would be any value
        set(value) {
            info = "Customer $name: Rate has updated to $value"
            field = value
        }

    init {
        println("Init - Customer $name last init block")
    }

    override fun printInfo() {
        super.printInfo()
        println("Customer information - Name: $name - Age: $age - Rate: $rate")
    }
}


class EncryptionLock (private val privateKey: Int) {
    public fun unlock(publicKey: Int) = formula(publicKey) == privateKey

    private fun formula(publicKey: Int) = publicKey / 2 + 5
}

abstract class Container {
    abstract fun pour()

    fun fill() {
        println("filling the container")
    }
}
class Bottle: Container() {
    override fun pour() {
        println("pouring liquid from bottle")
    }

}

class Jug: Container() {
    override fun pour() {
        println("pouring liquid from jug")
    }
}