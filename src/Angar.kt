class Angar {

    val map : MutableList<Int> = mutableListOf()
    var grup : MutableList<Abstract> = mutableListOf()
    val chest: Chest
    val camera: Camera
    val thief : Thief
    val cop : Cop

    init {
        CreateMap()
        chest = Chest()
        thief = Thief(this)
        cop = Cop(this)
        camera = Camera(thief, cop)

        grup = mutableListOf(thief, cop, camera)

    }

    /*fun changes(){
        units.forEach { elem ->


        }
    }*/

    fun CreateMap(){

        val temp = readFile("map.txt")
        temp.forEach {word ->
            map.add(word.toInt())
        }

    }

}
