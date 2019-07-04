class Cop(angar: Angar) : Person(angar) {

    val eyeCop = Eyes()
    var called = false

    init {
        MakeCop()
    }

    fun GoToCam() {
        called = true
    }

    fun fight(thief: Thief) {
        if (strange > thief.strange) {
            println("Мент попустил петушару")
        }
    }

    override fun action() {
        if (eyePerson.find(this, angar.thief)) {
            fight(angar.thief)
        }
        wolk()
    }

    private fun MakeCop() {
        val temp = readFile("Cop.txt")
        x = temp[0].toInt()
        y = temp[1].toInt()
        strange = temp[2].toInt()
    }

}
