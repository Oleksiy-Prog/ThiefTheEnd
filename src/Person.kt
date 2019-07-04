abstract class Person(val angar: Angar) : Abstract() {

    var strange : Int = 0
    var eyePerson = Eyes()
    var pastX = Int.MAX_VALUE
    var pastY = Int.MAX_VALUE
    val usedPath = mutableSetOf<Pair<Int, Int>>()

    fun wolk () {
        usedPath.add(Pair(x, y))
        val paths = mutableSetOf<Pair<Int, Int>>()

        for (i in x-1..x+1) {
            for (j in y-1..y+1) {
                if (angar.map[i*10 + j] == 1 && !usedPath.contains(Pair(i, j))) {
                    paths.add(Pair(i, j))
                }
            }
        }
        if (paths.isEmpty()) {
            for (i in x-1..x+1) {
                for (j in y-1..y+1) {
                    if (angar.map[i*10 + j] == 1 && Pair(i, j) != Pair(pastX, pastY)) {
                        paths.add(Pair(i, j))
                    }
                }
            }
        }
        if (paths.isEmpty()) {
            paths.add(Pair(pastX, pastY))
        }

        val ran = paths.random()
        pastX = x
        pastY = y
        x = ran.first
        y = ran.second
    }

}
