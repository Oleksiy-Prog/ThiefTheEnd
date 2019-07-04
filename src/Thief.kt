class Thief(angar: Angar) : Person(angar) {

    var stealth : Int = 0
    private var skills : Int = 0
    private var working = 0
    var isAlive = true


    init {
        MakeThief()
    }


    private fun open(chest: Chest) {

        working = chest.timeForOpen + (chest.complexity - skills)

    }


    override fun action() {

        if(isAlive) {
            when (working) {
                0 -> if (!check()) { wolk() }
                1 -> {
                    angar.chest.isEmpty = true
                    println("Сундук обчищен")
                }
                else -> working--
            }
        }
    }


    private fun check(): Boolean {//искать сундук, если находим - открываем

        if (eyePerson.find(this, angar.chest)) {
            open(angar.chest)
            return true
        }

        return false
    }


    private fun MakeThief() {

        val temp = readFile("Thief.txt")
        x = temp[0].toInt()
        y = temp[1].toInt()
        strange = temp[2].toInt()
        stealth = temp[3].toInt()
        skills = temp[4].toInt()

    }

}
