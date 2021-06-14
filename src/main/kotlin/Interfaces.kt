/*
Interfaces
    A class can implement multiple interfaces
    No constructor allowed
    Can implement methods, but doesn't need to
    Cannot initialize values, but can update then
    Can inherit from another interface

 */

fun main (args: Array<String>) {
    val myOven: Oven = getOven()
    myOven.turnOn()
    myOven.turnCook(150)
    myOven.turnOff()

    val rest1: Restaurant = FrenchRestaurant()
    val rest2: Restaurant = JaponeseRestaurant()

    rest1.provideBill()
    rest1.provideFood()
    rest2.provideBill()
    rest2.provideFood()

    var myFood: Food = FastFoodRestaurant().buyFood()
    myFood.eat()

    myFood = FrenchFoodRestaurant().todaySpecial()
    myFood.eat()
}

interface Oven {
    val temperature: Int    //  Cannot initialize values, but can update then

    fun turnOn()
    fun turnOff()
    fun turnCook(temp: Int) {       //  Can implement methods, but doesn't need to
        println("Cooking at $temp degrees")
    }
}

class Bosch: Oven {
    override val temperature = 180

    override fun turnOn() {
        println("TurnOn")
    }

    override fun turnOff() {
        println("TurnOff")
    }
}

fun getOven(): Oven {
    return Bosch()
}

interface Restaurant {
    fun provideFood()
    fun provideBill()
}

class FrenchRestaurant: Restaurant {
    override fun provideFood() {
        println("French Food")
    }

    override fun provideBill() {
        println("French Bill")
    }
}

class JaponeseRestaurant: Restaurant {
    override fun provideFood() {
        println("French Food")
    }

    override fun provideBill() {
        println("French Bill")
    }
}


interface PlaceToSit {

}

interface PlaceToSleep {

}

interface Couch: PlaceToSit, PlaceToSleep { // Can inherit from another interface
    var capacity: Int
    fun defineCapacity() {
        capacity = 3
    }
}

class Furniture: Couch, Oven {  //  A class can implement multiple interfaces
    override var capacity: Int
        get() = TODO("Not yet implemented")
        set(value) {}

    override val temperature: Int
        get() = TODO("Not yet implemented")

    override fun turnOn() {
        TODO("Not yet implemented")
    }

    override fun turnOff() {
        TODO("Not yet implemented")
    }

}


interface Food {
    fun eat()
}

class FastFood: Food {
    override fun eat() {
        println("Eat - FastFood")
    }
}

class FrenchFood: Food {
    override fun eat() {
        println("Eat - FrenchFood")
    }
}

class FastFoodRestaurant {
    fun buyFood(): Food {
        return FastFood()
    }
}

class FrenchFoodRestaurant {
    fun todaySpecial(): Food {
        return FrenchFood()
    }
}