package codewars

fun reverseString(string: String): String {
    var result = ""
    for (i in string.length - 1 downTo 0) result += string[i]
    return result
}

fun reverseStringAndOmitNonAlpha(string: String): String {
    var result = ""
    for (i in string.length - 1 downTo 0)
        if (string[i].toString() in "a".."z")
            result += string[i]
    return result
}

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

fun main() {
    val reverseTestString = "d=eZs!r-eBv4eDr/"
    val palindromeTestString = "Sum summus mus"
    val scoringTestString = "All letters will be lowercase and all inputs will be valid"

    println("Original string: $reverseTestString")
    println("Reversed string: " + StringBuilder(reverseTestString).reverse())
    println("Reversed string: " + reverseString(reverseTestString))
    // Simple Fun #176: Reverse Letter https://www.codewars.com/kata/58b8c94b7df3f116eb00005b
    println(reverseStringAndOmitNonAlpha(reverseTestString))
    // Is it a palindrome? https://www.codewars.com/kata/57a1fd2ce298a731b20006a4
    println("Is it palindrome '$palindromeTestString'? - " + isPalindrome(palindromeTestString))
    // Highest Scoring Word https://www.codewars.com/kata/57eb8fcdf670e99d9b000272
    println("Highest scoring word is: " + highestScoringWord(scoringTestString))
    // English beggars https://www.codewars.com/kata/59590976838112bfea0000fa
    println("English beggars: " + englishBeggars(3).joinToString())
}