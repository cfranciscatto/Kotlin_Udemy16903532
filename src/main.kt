//  Exercicios realizados como acompanhamento do curso Udemy:
//  Complete Kotlin Development Masterclass (16903532)
//  https://www.udemy.com/course/kotlinmasterclass/learn/lecture/16675430
//

import java.lang.Exception
import java.lang.IllegalStateException
import java.time.LocalDateTime
import kotlin.math.pow
import kotlin.random.Random

const val URL_LINK = "www.google.com"

fun main(args: Array<String>) {
    //strings()
    //userInputs()
    //randomNumbers()
    //numbers()
    //conversions()
    //operators()
    //interest()
    //nullability()
    //exceptions()
    //collectionsList()
    //collectionsSet()
    //collectionsMap()
    //flowControl_if()
    //expressions()
    //flowControl_when()
    //flowControl_for()
    //flowControl_while()
    //flowControl_breakContinue()
    functions()

}

fun strings() {
    // var is mutable
    var tvShow = "many"
    println(tvShow)
    tvShow = "too " + tvShow
    println(tvShow)

    // var type can not be changed
    //tvShow = 10  // Error

    // val is immutable
    val color = "blue"
    //color = "red"  // Error

    // Strings special chars " and \
    val dogName = "My dog's name is \"Fluffy\""
    println(dogName)

    val slashesType = "Two types of slashes: \\ and /"
    println(slashesType)

    val googleUrl = "http://www.google.com"
    println(googleUrl)

    // Bunny
    println("(\\(\\")
    println("(-.-)")
    println("o_(\")(\")")
    println("")

    // Strings functions
    val myPet = "Crocodile"
    println(myPet.length)

    val myName = "michElle"
    println(myName.capitalize())

    val animal = "GiRaFfE"
    println(animal.decapitalize())
    // capitalize() and decapitalize() only change the first char of the string

    val noSpaces = "    Too    many   spaces            "
    println(noSpaces.trim())

    println(myPet.get(3))   // Strings idx starts at 0
    println(myPet[3])       // Strings idx starts at 0

    println(myPet.substring(3)) //from pos 3 to the end
    println(myPet.substring(3, 6))  // from pos 3 to pos 6

    val myDog = "Teddy"
    println("My dog's name is $myDog")

    println("I have ${1+3} dogs")

    val products = 3
    val price = 15
    println("The total amount is ${products*price}")

    println(URL_LINK)
}

fun userInputs() {
    println("Input something")
    val userIn = readLine()
    println("Input is $userIn")

    println("Type a number")
    val userNumber = readLine()?:""     // if readLine() returns null, then ""
    println("The number is ${userNumber.toInt()}")

    println("Type a number")
    val number = readLine()?:""
    println("$number * 5 = ${number.toInt() * 5}")

    println("Enter your birth year")
    val birthYear = readLine()?:""
    val age = LocalDateTime.now().year - birthYear.toInt()
    println("Your age is either ${age-1} or $age")

}

fun randomNumbers() {
    println(Random.nextInt())     // kotlin.random
    println(Random.nextInt(10)) // 0 ~ 9  10 is not included
    println(Random.nextInt(20, 30)) // 20 ~ 29  30 is not included

    println(Random.nextDouble(210.0))

}

fun numbers() {
    var price = 34
    var items = 3
    var totalPrice = price * items
    println("Tptal price is $totalPrice")

    // Different type of numners -> different allocation in memory
    // Types:
    // Byte     -128    127
    // Short    -32768  32767
    // Int      -2^31   2^31-1
    // Long     -2^64   2^64-1
    // Float    32b     6-7 digits
    // Double   64b     15-16
    //
    // Int and Double are the default (implicit definition - decided by Kotlin)
    var count = 5           // Int
    var people = 6000000    // Long
    var prPrice = 25.68     // Dpuble
    var pi = 3.1415926535   // Double

    println(items::class.java)
    println(people::class.java)
    println(prPrice::class.java)
    println(pi::class.java)

//    println("Type a number")
//    val userInput = readLine()?:""
//    val newValue = userInput.toInt() * pi
//    println("${newValue::class.java} $newValue")

    // Explicit definition
    val cats:Int = 5
    val dogs:Byte = 5
    val days:Short = 5
    val life:Long = 35
    val lonValue = 654L
    val money:Double = 56.85
    val floatValue = 5.98F

    println(cats::class.java)
    println(dogs::class.java)
    println(days::class.java)
    println(life::class.java)
    println(lonValue::class.java)
    println(money::class.java)
    println(floatValue::class.java)


}

fun conversions() {
    // toByte()
    // toShort()
    // toInt()
    // toLong()
    // toFloat()
    // toDouble()
    // toString()       <-- Qualquer tipo pode ser convertido to String

    val cats = 3                    // int
    val longCats = cats.toLong()    // Long
    println(cats::class.java)
    println(longCats::class.java)

    val people = 7000000000
    val intPeople = people.toInt()
    println(people::class.java)
    println(intPeople::class.java)
    println(intPeople)

    val name = "Alice"
    val strName:String = "Monica"

    people.toString()
    longCats.toString()

    val pi = 3.14159
    val piStr = pi.toString()
    val piInt = pi.toInt()
    val piFloat = pi.toFloat()
    println("$pi is a ${pi::class.java}")
    println("$piStr is a ${piStr::class.java}")
    println("$piInt is a ${piInt::class.java}")
    println("$piFloat is a ${piFloat::class.java}")

    println("Enter a value")
    val userValue = readLine()?:""
    val result = userValue.toDouble() * pi
    println("$result is of type ${result::class.java}")

}

fun operators() {
    println("Hi" + " John")

    println(5 + 2)
    println(5 - 2)
    println(5 * 2)
    println(5 / 2)  // int / int = int
    println(5 / 2F) // = float
    println(5 % 2)  // modulus remainder
    var cats = 5
    cats++
    println(cats)  // increment
    cats--
    println(cats)  // decrement

    // resultado de uma operacao sempre será o type do maior operando dentro da operacao
    // Byte < Short < Int < Long < Float < Double
    val s: Short = 6
    val i: Int = 32
    val r1 = s * i
    println("$r1 is a ${r1::class.java}")

    val l: Long = 1321321
    val f: Float = 13.67F
    val r2 = l / f
    println("$r2 is a ${r2::class.java}")

    val d = 54.65841
    val f1 = 19F
    val r3 = d * f1
    println("$r3 is a ${r3::class.java}")

    var bikes = 5
    bikes += 1  // -= *= /*  %=
    println("Bikes = $bikes")

    // boolean - logical operators
    val isTrue = true
    val isFalse = false

    println("true && true is: ${isTrue && isTrue}")
    println("true && false is: ${isTrue && isFalse}")
    println("false && false is: ${isFalse && isFalse}")

    println("true || true is: ${isTrue || isTrue}")
    println("true || false is: ${isTrue || isFalse}")
    println("false || false is: ${isFalse || isFalse}")

    // logical comparison
    // < > <= >= == !=
    println("3 < 5 : ${3 < 5}")
    println("5 < 3 : ${5 < 3}")
    println("3 > 5 : ${3 > 5}")
    println("5 > 3 : ${5 > 3}")
    println("5 <= 5 : ${5 <= 5}")
    println("3 <= 5 : ${3 <= 5}")
    println("5 >= 5 : ${5 >= 5}")
    println("3 >= 5 : ${3 >= 5}")
    println("5 == 5 : ${5 == 5}")
    println("3 == 5 : ${3 == 5}")
    println("5 != 5 : ${5 != 5}")
    println("3 != 5 : ${3 != 5}")


    //  Unary operations
    //  +a                  a.unaryPlus()
    //  -a                  a.unaryMinus()
    //  !a                  a.not()
    //  a++                 a.inc()
    //  a–                  a.dec()
    //
    //  Binary operations
    //  a + b               a.plus(b)
    //  a - b               a.minus(b)
    //  a * b               a.times(b)
    //  a / b               a.div(b)
    //  a % b               a.rem(b)   a.mod(b) (deprecated)
    //  a..b                a.rangeTo(b)
    //  a in b              b.contains(a)
    //  a !in b             !b.contains(a)
    //  a += b              a.plusAssign(b)
    //  a -= b              a.minusAssign(b)
    //  a *= b              a.timesAssign(b)
    //  a /= b              a.divAssign(b)
    //  a %= b              a.remAssign(b)
    //
    //  Array-like operations
    //  a[i]                a.get(i)
    //  a[i, j]             a.get(i, j)
    //  a[i_1, …, i_n]      a.get(i_1, …, i_n)
    //  a[i] = b            a.set(i, b)
    //  a[i, j] = b         a.set(i, j, b)
    //  a[i_1, …, i_n] = b  a.set(i_1, …, i_n, b)
    //
    //  Equals operation
    //  a == b              a?.equals(b) ?: b === null
    //  a != b              !(a?.equals(b) ?: b === null)

}

fun interest() {

    println("Enter the capital:")
    val capital = readLine()?:""

    println("Enter the interest per month:")
    val interests = readLine()?:""

    println("Enter the number of months:")
    val months = readLine()?:""

    val c = capital.toDouble()
    val i = interests.toDouble()
    val t = months.toInt()

    val a = c * (1 + i/100).pow(t)
    println("The amount after $t month(s) with an interest of $i per month")
    println( "You will have amount of $a")

}

fun nullability() {
    // ? (question mark) is used to define a variable as nullable (or that can receive a null value)
    val herName:String = "Maria"    // must provide a value
    val hisName = "José"            // implicit definition. Variable type is defineded according to its value
    val yourName:String? = null     // variable type must be defined explicitly. A value or null must be provided

    println(herName)
    println(hisName)
    println(yourName)

    var catName:String? = "Mimi"
    catName = null      // Ok

    var dogName:String = "Toto"
    //dogName = null    // Compilation error

    // ?.  Safe Call Operator
    // // Permite fazer referencia a variável definida com ?, porém se ela for null, retorna null em vez de NPE
    println(catName?.length)
    println(catName?.length?.toString())
    catName = "The cat name is Fifi"
    println(catName?.length)
    println(catName?.length?.plus(5))
    println(catName?.substring(4,7))

    // Arithmetic operations
    // - classic operators can not be used for null variables
    // - replacement methods:
    //      Addition    +   ->  ?.plus()
    //      Subtraction -   ->  ?.minus()
    //      Multiplic   *   ->  ?.times()
    //      Division    /   ->  ?.div()
    //      Remainder   %   ->  ?.rem()
    val a:Int? = 10
    println(a?.plus(2))
    println(a?.minus(2))
    println(a?.times(2))
    println(a?.div(2))
    println(a?.rem(2))

    val d:Double? = 5.2356
    val f:Float? = d?.times(6)?.toFloat()
    println(f)

    //var userName = readLine()
    //println(userName?.length)

    println("Enter a number")
    var userInput = readLine()
    val d1:Double? = userInput?.toDouble()?.times(7)
    val s:String? = d1.toString()
    println("Length of $d1 is ${d1?.toString()?.length}")

    // ?: Elvis operator  -> if variable is null (?)  then (:) set to blabla
    // Guarantees a result returned
    var birdName:String? = null
    println(birdName?:"The bird has no name")
    println(birdName?:"Penoso".length)      // ou retorna o len de birdName ou len de "Penoso"
    birdName = "Piu-piu"
    println(birdName?:"The bird has no name")

    // !!.  Developer guarantee that the variable is not null
    //      Bypass all checks for null safety and can trigger a crash
    //
    // DON'T USE IT
    //
    catName = null
    //println(catName!!.length)  // developer guarantees that catName is not null. Compilation will ignore, but app will crash on runtime (NPE)

    println("How many products would you like to buy?")
    val input = readLine()
    val purchasedItems = input?.toInt()?:3  // Ou o que digitou ou default 3
    val productValue = 29.36
    println("Total is ${productValue * purchasedItems}")
}

fun exceptions() {
    println("Enter a number:")
    var input = readLine()
    try {
        println(input?.toInt())
    } catch (e: Exception ) {
        e.printStackTrace()
        println("An exception has occurred: ${e.localizedMessage}")
    } finally {
        println("The executions is completed")
    }


    println("Enter a number:")
    var input1 = readLine()
    throw IllegalStateException("I don't like this input")
}

fun collectionsList() {
    // List -> a list of elements, immutable, duplicated elements, one type of elements
    val colors = listOf("blue", "green", "yellow", "red")
    println(colors) // [blue, green, yellow, red]

    // Empty list -> provide the type
    val colors2 = listOf<String>()
    println(colors2) // []

    // duplicated elements
    val colors3 = listOf("blue", "green", "yellow", "blue", "red")
    println(colors3) // [blue, green, yellow, blue, red]

    // Can contain null
    val colors4 = listOf("blue", "green", "yellow", "blue", null, "red")
    println(colors4) // [blue, green, yellow, blue, null, red]

    // retrieve elements
    println(colors3[0])
    println(colors3[1])
    println(colors3[2])
    //println(colors3[7]) //Exception
    println(colors3.get(0))
    println(colors3.get(1))
    //println(colors3.get(7)) //Exception

    // list functions
    println("list functions")
    println(colors3.size)
    println(colors3.contains("red"))
    println(colors3.contains("pink"))
    println(colors3.containsAll(colors))
    println(colors3.indexOf("blue"))
    println(colors3.lastIndexOf("blue"))

    println("ArrayList")
    // ArrayList -> mutable list
    val colors5 = arrayListOf("blue", "red")
    println(colors5)

    // Empty array -> provide the type
    val noColors = arrayListOf<String>()

    // add items
    colors5.add("green")
    println(colors5)

    // add another collection
    val moreColors = arrayListOf("pink", "black")
    moreColors.addAll(colors5)
    println(moreColors)

    //remove items - se tem mais de 1 item com o mesmo valor, remove o primeiro
    moreColors.remove("red")
    println(moreColors)

    // remove collection
    moreColors.removeAll(colors5)
    println(moreColors)

    // remove position
    moreColors.removeAt(1)
    println(moreColors)

    val animals = listOf("dog", "bird", "cat", "tigre")
    println(animals.size)
    println(animals.get(1))

    val customers = arrayListOf<String>()
    customers.add("Joao")
    customers.add("Jose")
    customers.add("Maria")
    customers.add("Luis")
    customers.add("Aparecida")
    println(customers.size)
    println(customers)
    customers.remove("Jose")
    println(customers)

    val items = arrayListOf("laptop", "mouse", "pen", "paper", "mug", "phone")
    val removedItems = listOf("pen", "paper", "mug", "phone")
    items.removeAll(removedItems)
    println(items)

    // arraylist functions - todas funcoes de list são aplicaveis ao arraylist
    println("Arraylist functions")
    val arrayColors = arrayListOf("blue", "green", "yellow", "blue", "red")
    // setar valor na posicao
    arrayColors.set(3,"teal")
    println(arrayColors)
    arrayColors.set(arrayColors.indexOf("teal"), "white")
    println(arrayColors)

    // sub array
    val subColors = arrayColors.subList(2,4)    //2 -> inclusive,  4 -> exclusive
    println(subColors)
    println(subColors::class.java)

    //clear
    subColors.clear()
    println(subColors)
    println(subColors.isEmpty())
}

fun collectionsSet() {
    // Set - immutable - store unique elements in an undefined order
    val numbersSet = setOf(4, 57,4,67)
    println(numbersSet)          //  [4, 57, 67] -> 4 is add only 1x
    // empty set
    val emptySet = setOf<Int>()
    println(emptySet)
    // null elements
    val nullSet = setOf(1,3,null,67,9,null,23,3)
    println(nullSet)    // [1, 3, null, 67, 9, 23]

    // set functions
    println(numbersSet.size)
    println(numbersSet.contains(57))
    println(numbersSet.contains(987))
    println(numbersSet.containsAll(nullSet))
    println(numbersSet.isEmpty())

    // HashSet - mutable - store unique elements in an undefined order
    val numbersHashSet = hashSetOf(4, 57,4,67, null)
    println(numbersHashSet)      //  [null, 57, 67, 4] -> 4 is add only 1x
    // empty set
    val emptyHashSet = hashSetOf<Int>()
    println(emptyHashSet)

    // HashSet functions - All Set functions apply to HashSet
    numbersHashSet.add(456)
    println(numbersHashSet)     // [null, 456, 57, 67, 4]

    val newSet = setOf(65,87,23)
    numbersHashSet.addAll(newSet)
    println(numbersHashSet)     // [null, 65, 67, 4, 87, 23, 456, 57]

    val newNumbersHashSet = hashSetOf(34,67, null)
    newNumbersHashSet.addAll(numbersHashSet)
    val newRetain = setOf(87,456,654, 534, null)
    newNumbersHashSet.retainAll(newRetain)     // result the intersection between the sets
    println(newNumbersHashSet)     // [null, 87, 456]

    numbersHashSet.remove(87)
    println(numbersHashSet)     // [null, 65, 4, 87, 23, 456, 57]

    numbersHashSet.removeAll(newSet)
    println(numbersHashSet)     // [null, 4, 456, 57]

    numbersHashSet.clear()
    println(numbersHashSet)     // []


    val colors = hashSetOf<String>()
    val colorsList = listOf("green", "red", "blue", "red")
    colors.addAll(colorsList)
    println(colors)
    colors.remove("red")
    println(colors)

    val objects = hashSetOf("mobile", "notebook", "headset", "mouse", "book")
    val objectsToRemove = listOf("book", "headset")
    println(objects)
    objects.removeAll(objectsToRemove)
    println(objects)

    val customers = hashSetOf("Michael", "John", "Alice")
    println("Input name of joining customer")
    val newCustomer = readLine()?:""
    customers.add(newCustomer)
    println(customers)
    println("Input name of leaving customer")
    val leavingCustomer = readLine()?:""
    customers.remove(leavingCustomer)
    println(customers)

}

fun collectionsMap() {
    // Map and HashMap are not a collection

    // Map immutable
    // set of key-value pairs. Keys are unique, values are not
    // keys can be from <typeX> and values from <valueY>
    var count = mapOf(Pair(1,"one"), Pair(2,"two"), Pair(3,"three"))
    println(count)      // {1=one, 2=two, 3=three}

    //empty map
    var emptyMap = mapOf<Int, String>()
    println(emptyMap)      // {}

    // functions
    // get based on a key
    println(count.get(2))  // two

    // get the whole set of keys
    println(count.keys)  // [1, 2, 3]

    // get the whole set of values
    println(count.values)  // [one, two, three]

    // HashMaps - mutable
    var countHash = hashMapOf(Pair(1,"one"), Pair(2,"two"), Pair(3,"three"))

    //functions
    println(countHash.size) // 3
    println(countHash.containsKey(3)) // true
    println(countHash.containsKey(13)) // false
    println(countHash.containsValue("four")) // false
    println(countHash.containsValue("two")) // true
    println(countHash.isNotEmpty()) // true
    println(countHash.isEmpty()) // false

    // adding pairs
    countHash.put(5,"five")
    countHash[6] = "six"
    println(countHash)      // {1=one, 2=two, 3=three, 5=five, 6=six}

    val extraMap = mapOf(Pair(12,"twelve"), Pair(11,"eleven"))
    countHash.putAll(extraMap)
    println(countHash)      // {1=one, 2=two, 3=three, 5=five, 6=six, 11=eleven, 12=twelve}

    // replace
    countHash.replace(2, "2222") // based on the key (not position)
    println(countHash)      // {1=one, 2=2222, 3=three, 6=six, 11=eleven, 12=twelve}

    // removing
    countHash.remove(5) // based on the key (not position)
    println(countHash)      // {1=one, 2=two, 3=three, 6=six, 11=eleven, 12=twelve}

    // removing all
    countHash.clear()
    println(countHash)      // {}

    //-----------
    // "Day 4" é incluso em "attendance" após a definição, então ao fazer o get no mesmo (attendance["Day 4"]),
    // o tipo dele é indefinido e há a necessidade de verificar a nulidade e atribuir o valor default (val attD4 = attendance["Day 4"]?:0)
    //-----------
    val attendance = hashMapOf(Pair("Day 1", 123), Pair("Day 2", 1245), Pair("Day 3", 700))
    attendance["Day 4"] = 654
    val attD1 = attendance["Day 1"]?:0
    val attD4 = attendance["Day 4"]?:0
    println("${attD1 + attD4}")
}

fun flowControl_if() {
    println("Input a boolean value")
    val input = readLine() ?: "true"
    val night = input.toBoolean()

    // shorthand if
    if (night)
        println("Sleep")
    else
        println("Wakeup")

    val number = 20
    var isEven: String? = null
    if (number % 2 == 0) isEven = "Number is even" else isEven = "Number is odd"

    // block if
    if (number % 2 == 0) {
        isEven = "Number is even"
        println(isEven)
    } else {
        isEven = "Number is odd"
        println(isEven)
    }

    // if as statement
    isEven = if (number % 2 == 0) "Number is even" else "Number is odd"

    // multiple branches
    if (number / 4 < 5) {
        println("<5")
    } else if (number / 4 < 15) {
        println("<15")
    } else if (number / 4 < 25) {
        println("<25")
    } else {
        println(">=25")
    }
}

fun expressions() {
    // arithmetric & logical
    if (326/72*15+93%13 == 65)  // conditional must have a expression that results in a true/false value
        println ("Math is hard")
    else
        println ("Math is easy")

    val hasCat = true
    val hasFood = true

    if (hasCat && hasFood)
        println("Cat is happy")
    else
        println("Cat is hahgry")

    val age = 15
    if (age >= 18) println("Can drink alcohol") else println("Illegal to drink alcohol")

    // in keyword
    "cat" in listOf("dog", "lion", "bird")  // false
    4 in setOf(1,3,4,6,7)                   // true
    5 in 1..10                              // true  - range 1..10
    25 in 30..40                            // false
    // !in keyword
    "cat" !in listOf("dog", "lion", "bird")  // true
    4 !in setOf(1,3,4,6,7)                   // false
    5 !in 1..10                              // false
    25 !in 30..40                            // true

    val avalPets = listOf("dog", "cat", "bird")
    var favPet = "dog"
    if (favPet in avalPets)
        println("Favorite pet is in the list")
    else
        println("Sorry $favPet is not available")

    favPet = "tiger"
    if (favPet !in avalPets)
        println("Sorry $favPet is not available")
    else
        println("Favorite pet is in the list")

}

fun flowControl_when() {

    // { são necessárias para blocos de código ( java nao precisa)
    // não precisa de break... somente o bloco de codigo será executado

    val number = 654
    var result: String = ""
    when (number % 2) {
        0 -> result = "Even"
        1 -> result = "Odd"
    }
    println("Number $number is $result")


    var animal = "dog"
    var action: String = ""

    when (animal) {
        "dog" -> {
            action = "pet it"
        }
        "cat" -> {
            action = "feed it"
        }
        else -> {
            action = "google it"
        }
    }
    println("When you meet a $animal you should $action")

    // when aninhados... permitido, mas não usar... visualização muito ruim
    val var1 = 123
    val var2 = 345
    when (var1) {
        123 -> {
            when (var2 % 2) {
                0 -> result = "Even"
                1 -> result = "Odd"
            }
        }
        5534 -> {
            when (var2 % 2) {
                0 -> result = "Even"
                1 -> result = "Odd"
            }
        }
        else -> {
            result = "blabla"
        }
    }

    // when as statement
    animal = "cat"
    action = when (animal) {
        "dog" -> "pet it"
        "cat" -> "feed it"
        else -> {
            println("Animal doesn't match")
            "google it"
        }
    }
    println("When you meet a $animal you should $action")

    // multiple option
    val month = "February"
    var days = when (month) {
        "January", "March", "May", "July", "August", "October", "December" -> 31
        "February" -> 28
        else -> 30
    }

    // capturing subject - valido somente dentro do bloco when
    val password = "123!@#ABC"
    when (val len = password.length) {
        in 0..5 -> println("Password with $len characters is too short")
        in 6..10 -> println("Password with $len characters is average")
        else -> println("Password with $len characters is long")
    }
}

fun flowControl_for() {
    val colors = listOf("blue", "green", "yellow", "red")
    for (color in colors) {
        println("Current color is $color")
    }

    for (i in 1..12) {
        val month = when(i) {
            1 -> "January"
            2 -> "February"
            3 -> "March"
            4 -> "April"
            5 -> "May"
            6 -> "June"
            7 -> "July"
            8 -> "August"
            9 -> "September"
            10 -> "October"
            11 -> "November"
            12 -> "December"
            else -> ""
        }
        println("Month $i is called $month")
    }

    // range
    for (i in 10 downTo 0) {
        print("$i ")
    }
    println()

    for (i in 100 downTo 0 step 5) {
        print("$i ")
    }
    println()

    println((1..10).filter { it % 2 == 0 })

    val numbers = (0..9).toList()
    println(numbers)

    println((0..9))

}

fun flowControl_while() {
    var i = 0
    while(i<10) {
        println(i++)
    }

    val colors = listOf("blue", "green", "yellow", "red")
    var j = 0
    while (j < colors.size) {
        println("Current color is ${colors[j]}")
        j++
    }

    i = 0
    do {
        println(i)
    } while(++i<10)

}

fun flowControl_breakContinue() {
    println("Continue...")
    val evenNumbers = arrayListOf(2,4,8,7,4,10)
    for (number in evenNumbers) {
        if(number % 2 != 0)
            continue
        println("$number is even")
    }

    println("Break...")
    for (number in evenNumbers) {
        if(number % 2 != 0)
            break
    }
    println("Broke")

    println("Label continue...")
    loop@ for (i in 1..10) {
        for (j in 1..10) {
            if (i % 3 == 0)
                continue@loop
            println("$i,$j")
        }
    }

    println("Label break...")
    loop@ for (i in 1..10) {
        for (j in 1..10) {
            if (i % 3 == 0)
                break@loop
            println("$i,$j")
        }
    }
}

fun functions() {
    multiply(4,5)
    multiply(4) // uses the default n2 value

    val n1 = 6
    val n2 = 9
    println("calculateMultiply($n1) = ${calculateMultiply(n1)}")
    println("calculateMultiply($n1,$n2) = ${calculateMultiply(n1,n2)}")

    val people: List<String> = listOf("Anna", "Bob", "Carol")
    sayHello(people)
    println(greeting(people))

    for (i in 1..3)
        println(sum(i*3, i*7))

    val products = hashMapOf(Pair("shoes", 29.99), Pair("socks", 5.99), Pair("jeans", 39.99))
    for (prod in products.keys) {
        println("Final price for $prod is ${calculateTax(products[prod])}")
    }


}

fun multiply(n1: Int, n2: Int = 3) {
    println("$n1 * $n2 = ${n1 * n2}")
}

fun calculateMultiply(n1: Int, n2: Int = 3) : Int {
    return n1 * n2
}

fun sayHello(people: Collection<String>) {
    for (person in people)
        println("Hello $person")
}

fun greeting(people: Collection<String>) : String {
    var greeting = ""
    for (person in people)
        greeting += "Hello $person\n"
    return greeting
}

//handshort definition
fun sum(n1: Int, n2: Int) = n1 + n2;

fun calculateTax(price: Double?) = price?.times(1.2)

//
//
//fun interfaces() {
//    val dog :Dog
//}
//
//interface Animal {
//    var name: String
//    val numLegs: Int
//
//    fun walk()
//    fun eat( food: String) {
//        println("$name eats $food")
//    }
//}
//
//interface Mammal: Animal {
//    fun drinkMilk() {
//        println("drinkMilk")
//    }
//}
//
//class Dog(): Mammal {
//    override var name: String
//        get() = TODO("Not yet implemented")
//        set(value) {}
//    override var numLegs = 4
//    override fun walk() {
//        TODO("Not yet implemented")
//    }
//}
//
//class Bird: Animal {
//    override var name: String
//
//    fun putEgss() {
//        println("Eggs")
//    }
//}
//
//interface Thinker {
//    val name : String
//    fun eat (junk : String) {
//        println("Thinker eat")
//    }
//}
//
//
//class Human : Mammal, Thinker {
//    override var name = "Human"
//    override val numLegs = 2
//
//    override fun walk() {
//        TODO("Not yet implemented")
//    }
//
//    override fun eat(junk: String) {
//        super<Mammal>.eat(junk)
//        super<Thinker>.eat(junk)
//    }
//
//    fun description() {
//        walk()
//        drinkMilk()
//        eat("everyThing")
//    }
//}
//
