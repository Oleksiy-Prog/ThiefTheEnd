class Thief(angar: Angar) : Person(angar) {

    private var stealth : Int = 0
    private var skills : Int = 0

    init {
        MakeThief()
    }

    fun open(chest: Chest){
        if (skills > chest.complexity) {
            chest.isEmpty = true
            println("Сундук ворам - хуй мусорам")
        }
    }


    override fun action() {
        if (eyePerson.find(this, angar.chest)) {
            open(angar.chest)
        }
        wolk()
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
