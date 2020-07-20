fun main() {
    val demo: String = "https://www.hentai.com"
    println("the first '/' in ${demo.indexOf('/')}")  // 6
    println("address is ${demo.substring(8 until demo.length)}")  // www.hentai.com

    println(demo.split("."))  // [https://www, hentai, com]

    // all string is permanent, function will return a copy of origin string
    println(demo.replace("hentai", "nsfw"))  // https://www.nsfw.com
    println(demo)  // https://www.hentai.com

    val compare = (demo == "https://www.hentai.com") // compare content
    val compare2 = (demo === "https://www.hentai.com") // compare reference
    println("0:$compare, 1:$compare2")

    // unicode char
    val unicodeOddChar: Char = '\u0950'
    println(unicodeOddChar)

    showCharsInString(demo)
}

private fun showCharsInString(content: String){
    content.forEach { println("$it\n") }
}