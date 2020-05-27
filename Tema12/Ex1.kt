import kotlin.collections.zipWithNext
fun main() {

    var lista   = listOf(1,4,15,27,23,78,32,89,34,61).toMutableList()
    var lista2: List<Pair<Int, Int>>
    var contor  = 0
    var sum     = 0

    lista = lista.filter { it>5 }.toMutableList()
    lista2 = lista.zipWithNext()
    lista = listOf<Int>().toMutableList()
    lista2.onEach {
        lista = (lista + it.first*it.second).toMutableList()
    }
    println(lista)
    while(contor <= lista.lastIndex)
    {
        if(contor % 2 == 0)
        {
            sum += lista.get(contor)
        }
        contor++
    }
    println(sum)

}