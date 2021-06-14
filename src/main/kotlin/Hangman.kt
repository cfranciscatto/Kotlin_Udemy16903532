import kotlin.random.Random

val words = listOf("Ovo", "Queijo", "Cebola" , "Acelga", "Sal", "Peixe", "Cenoura", "Ervilhas", "Vinagre", "Arroz")
var word = ""
val guesses = arrayListOf<Char>()
val maxGuesses = 6
var remainingGuesses = maxGuesses
var mistakes = 0

fun main(args: Array<String>) {
    setupGame()

}

fun setupGame() {
    val wordIndex = Random.nextInt(words.size)
    word = words[wordIndex].toUpperCase()

    println(word)

    for (i in word.indices)
        guesses.add('_')

    var gameOver = false
    do {
        printMistakes()
        println("Please enter a letter: ")
        val input = readLine()?:""

        if (input.isEmpty()) {
            println("That's not a valid input. Please try again")
        } else {
            val letter = input[0]
            if (word.contains(letter)) {
                for (i in word.indices) {
                    if (word[i] == letter) {
                        guesses[i] = letter
                    }
                }
                if (!guesses.contains('_'))
                    gameOver = true
            } else {
                println("Sorry, that's not part of the word")
                remainingGuesses--
                mistakes++
                if (mistakes == maxGuesses)
                    gameOver = true
            }
        }

    } while(!gameOver)

    if (mistakes == maxGuesses) {
        printMistakes()
        println("Sorry, you lost. The word was $word")

    } else {
        println("Congratulations, you win! The word was $word")
    }
}

fun printMistakes() {
    println("  |------|-")
    println("  |      | ")
    println(if (mistakes > 0) "  |      O " else "  |        ")
    println(if (mistakes > 3) "  |     /|\\" else if (mistakes > 2) "  |     /| " else if (mistakes > 1) "  |      | " else "  |        ")
    println(if (mistakes > 1) "  |      | " else "  |        ")
    println(if (mistakes > 5) "  |     / \\" else if (mistakes > 4) "  |     /  " else "  |        ")
    println(" /|\\       ")
    println("/ | \\      ")

    println("Word: ")
    for (element in guesses)
        print("$element ")

    println("\nYou have $remainingGuesses guess(es) left")
}