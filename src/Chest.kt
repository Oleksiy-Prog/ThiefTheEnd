class Chest : Abstract() {

    var isEmpty = false
    var complexity : Int = 0

    init {
        MakeChest()

    }

    fun open(){

    }

    override fun action(){}

    private fun MakeChest(){
        val temp = readFile("Chest.txt")
        x = temp[0].toInt()
        y = temp[1].toInt()
        complexity = temp[2].toInt()
    }
}
