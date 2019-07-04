class Chest : Units() {

    var isEmpty = false
    var complexity : Int = 0
    val timeForOpen = 10


    init {
        MakeChest()
    }


    override fun action(){

        if (isEmpty){
            println("Thief won")
        }

    }


    private fun MakeChest(){

        val temp = readFile("Chest.txt")
        x = temp[0].toInt()
        y = temp[1].toInt()
        complexity = temp[2].toInt()

    }

}
