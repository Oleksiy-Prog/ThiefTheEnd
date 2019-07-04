import java.lang.Math.*

class Eyes {

    var range: Int = 0


    init {
        range = 1
    }


    fun find (cur: Units, units: Units) : Boolean {

        if (sqrt(pow((cur.x - units.x).toDouble(), 2.0) + pow((cur.y - units.y).toDouble(), 2.0)) <= range){
            return true
        }

        return false
    }

}
