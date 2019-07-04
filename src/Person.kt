abstract class Person(val angar: Angar) : Units() {

    var strange : Int = 0
    var eyePerson = Eyes()
    private var pastX = Int.MAX_VALUE//координаты прошлой клетки
    private var pastY = Int.MAX_VALUE
    private val usedPath = mutableSetOf<Pair<Int, Int>>()//посещённые клетки

    fun wolk () {
        usedPath.add(Pair(x, y))
        val allPaths = mutableSetOf<Pair<Int, Int>>()//все варинты дальнейшего пути
        val paths = mutableSetOf<Pair<Int, Int>>()//возможные варинты дальнейшего пути



        allPaths.add(Pair(x-1, y))
        allPaths.add(Pair(x+1, y))
        allPaths.add(Pair(x, y-1))
        allPaths.add(Pair(x, y+1))

        allPaths.forEach { item ->
            if (angar.map[item.first*10 + item.second] == 1 && !usedPath.contains(item)){
                paths.add(item)
            }
        }

        if (paths.isEmpty()){//ищем посещенные клетки, но не предыдущую
            allPaths.forEach { item ->
                if (angar.map[item.first*10 + item.second] == 1 && item != Pair(pastX, pastY)){
                    paths.add(item)
                }
            }
        }

        if (paths.isEmpty()){//если ничего не нашли - идём откуда пришли
            paths.add(Pair(pastX, pastY))
        }


        val ran = paths.random()//выбор случайной клетки из найденых возможных
        pastX = x
        pastY = y
        x = ran.first
        y = ran.second
    }

}
