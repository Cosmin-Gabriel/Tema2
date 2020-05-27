fun criptareCezar() {

    val text = "ANA ARE MERE DE LA BUNICA SA"
    println("Text Original: $text")
    val cipher = criptare( text, 5 )
    println("Text criptat: $cipher")
}
private fun criptare( text: String, shift: Int ): String {
    var result = ""
    val firstCharCode = 'A'.toInt()
    val offset = ( 'z' - 'A' ) + 1
    for ( i in 0 until text.length ) {

        val oldCharCode = text[i].toInt()
        val oldIdxInAlphabet = oldCharCode - firstCharCode
        val newIdxInAlphabet = (oldIdxInAlphabet + shift) % offset
        val newChar = (firstCharCode + newIdxInAlphabet).toChar()
        result += newChar
    }
    return result
}
fun main() {
    criptareCezar()
}