import java.lang.Math.*

class Eyes {
    var range: Int

    init {
        range = 2
    }

    fun find (cur:Abstract, abstract: Abstract) : Boolean{
        if (sqrt(pow((cur.x - abstract?.x).toDouble(), 2.0) + pow((cur.y - abstract?.y).toDouble(), 2.0)) < range){
            return true
        }
        return false
    }

}
