class Cop(angar: Angar) : Person(angar) {

    private var waiting = 0


    init {
        MakeCop()
    }


    fun protectChest() {

        x = angar.chest.x
        y = angar.chest.y
        waiting = 5

    }


    private fun fight(thief: Thief) {

        if (strange > thief.strange) {
            thief.isAlive = false
            println("Вор пойман")
        }else {
            angar.grup.remove(angar.cop)
        }

    }


    override fun action() {

        when (waiting){
            0 -> if(!check()){ wolk() }
            else -> {
                waiting--
                check()
            }
        }
    }


    private fun check(): Boolean{

        if (eyePerson.find(this, angar.thief)) {
            fight(angar.thief)
            return true
        }

        return false
    }


    private fun MakeCop() {

        val temp = readFile("Cop.txt")
        x = temp[0].toInt()
        y = temp[1].toInt()
        strange = temp[2].toInt()

    }

}
