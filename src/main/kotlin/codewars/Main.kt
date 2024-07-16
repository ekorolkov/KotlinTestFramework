package codewars

fun reverseString(string: String): String {
    var result = ""
    for (i in string.length - 1 downTo 0) result += string[i]
    return result
}

fun reverseStringSimple(string: String): String = string.reversed()

fun reverseStringAndOmitNonAlpha(string: String): String {
    var result = ""
    for (i in string.length - 1 downTo 0)
        if (string[i].toString() in "a".."z")
            result += string[i]
    return result
}

fun reverseStringAndOmitNonAlphaSimple(string: String) = string.reversed().filter { it in 'a'..'z' }.toString()

fun isPalindrome(string: String): Boolean = (string.uppercase() == reverseString(string.uppercase()))

fun highestScoringWord(string: String): String {
    var currentScore = 0
    var highestScore = 0
    var currentWord = ""
    var highestWord = ""
    for (i in 0..<string.length) {
        if (string[i].toString() == " ") {
            if (currentScore > highestScore) {
                highestScore = currentScore
                highestWord = currentWord
            }
            currentScore = 0
            currentWord = ""
        } else {
            currentWord += string[i]
            currentScore += string[i].lowercaseChar().code - 96
        }
    }
    if (currentScore > highestScore) { // last word check
        highestScore = currentScore
        highestWord = currentWord
    }
    return highestWord
}

fun englishBeggars(beggars: Int): IntArray {
    val array = arrayOf(1, 2, 3, 4, 5)
    var result = IntArray(0)
    var a = 0
    for (i in 1..beggars) {
        for (k in 0..<array.size step beggars)
            if ((i + k - 1) < array.size) {
                a += array[i + k - 1]
            }
        result += a
        a = 0
    }
    return result
}

fun findWordByFirstLetter(vararg words: String) =
    words.filter { it[0] == 'B' }.map { it.uppercase() }.toSet()

fun Int.isPositive() = (this > 0)

fun mulptiplesOf3or5(number: Int): Int {
    var result: Int = 0
    if (number.isPositive()) {
        for (i in 1..<number)
            if ((i % 3 == 0) or (i % 5 == 0)) result += i
        return result
    }
    else return 0
}

fun mulptiplesOf3or5Simple(number: Int) = (1 until number).filter { it % 3 == 0 || it % 5 == 0}.sum()

fun alphabetWar(fight: String): String {
    var leftSide: Int = 0
    var rightSide: Int = 0
    val leftPower = "sbpw"
    val rightPower = "zdqm"
    fight.forEach {
        when (it) {
            in leftPower -> leftSide += leftPower.indexOf(it) + 1
            in rightPower -> rightSide += rightPower.indexOf(it) + 1
        }
    }
    if (leftSide == rightSide) return "Let's fight again!"
    else if (leftSide > rightSide) return "Left side wins!"
    else return "Right side wins!"
}

fun evenNumbers(array: List<Int>, number: Int): List<Int> {
    var result = mutableListOf<Int>()
    for (i in array.size-1 downTo 0)
        if ((array[i] % 2 == 0) && (result.size < number)) result.add(array[i])
    return result.asReversed()
}

fun evenNumbersSimple(array: List<Int>, number: Int): List<Int> = array.filter { it % 2 == 0 }.takeLast(number)

fun main() {
    val reverseTestString = "d=eZs!r-eBv4eDr/"
    val palindromeTestString = "Sum summus mus"
    val scoringTestString = "All letters will be lowercase and all inputs will be valid"

    println("Original string: $reverseTestString")
    println("Reversed string: " + StringBuilder(reverseTestString).reverse())
    println("Reversed string: " + reverseString(reverseTestString))
    println("Reversed string: " + reverseStringSimple(reverseTestString))
    // Simple Fun #176: Reverse Letter https://www.codewars.com/kata/58b8c94b7df3f116eb00005b
    println(reverseStringAndOmitNonAlpha(reverseTestString))
    println(reverseStringAndOmitNonAlphaSimple(reverseTestString))
    // Is it a palindrome? https://www.codewars.com/kata/57a1fd2ce298a731b20006a4
    println("Is it palindrome '$palindromeTestString'? - " + isPalindrome(palindromeTestString))
    // Highest Scoring Word https://www.codewars.com/kata/57eb8fcdf670e99d9b000272
    println("Highest scoring word is: " + highestScoringWord(scoringTestString))
    // English beggars https://www.codewars.com/kata/59590976838112bfea0000fa
    println("English beggars: " + englishBeggars(3).joinToString())
    //
    println(findWordByFirstLetter("Red", "Red", "Green", "Blue", "Pink", "Brown").toString())
    // Multiples of 3 or 5 https://www.codewars.com/kata/514b92a657cdc65150000006
    println(mulptiplesOf3or5(17))
    println(mulptiplesOf3or5Simple(17))
    // Alphabet war https://www.codewars.com/kata/59377c53e66267c8f6000027
    println(alphabetWar("zdqmwpbs"))
    // Even numbers in an array https://www.codewars.com/kata/5a431c0de1ce0ec33a00000c
    println(evenNumbers(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 3))
    println(evenNumbersSimple(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 3))
}