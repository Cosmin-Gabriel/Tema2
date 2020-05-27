import kotlin.math.sqrt
fun distanta(x1: Double,y1: Double,x2: Double, y2: Double): Double {
    var rad = sqrt(Math.pow((x2-x1),2.0) + Math.pow((y2-y1),2.0))
    return rad
}
fun main(){
    var n = 4
    var i = 0
    var perimetru = 0.0
    var x = mutableListOf<Double>(0.0,0.0,1.0,1.0)
    var y = mutableListOf<Double>(0.0,1.0,1.0,0.0)
    var xy = x.zip(y)
    var xyzip = xy.zipWithNext()
    println(xy)
    println(xyzip)
    while(i<n-1)
    {
        perimetru += distanta(
            xyzip.elementAt(i).first.first,
            xyzip.elementAt(i).first.second,
            xyzip.elementAt(i).second.first,
            xyzip.elementAt(i).second.second)
        i++
    }
    perimetru += distanta(
        xy.last().first,
        xy.last().second,
        xy.first().first,
        xy.first().second)

    print(perimetru)
}}