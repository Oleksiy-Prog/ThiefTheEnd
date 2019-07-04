class Angar {

    val map : MutableList<Int> = mutableListOf()
    var grup : MutableList<Units> = mutableListOf()
    val chest: Chest
    val camera: Camera
    val thief : Thief
    val cop : Cop

    init {

        CreateMap()
        chest = Chest()
        thief = Thief(this)
        cop = Cop(this)
        camera = Camera(this)

        grup = mutableListOf(thief, cop, camera)

    }

    fun changes(){

        grup.forEach { elem ->
            elem.action()
        }

    }

    fun CreateMap(){

        val temp = readFile("map.txt")
        temp.forEach {word ->
            map.add(word.toInt())
        }

    }

}
