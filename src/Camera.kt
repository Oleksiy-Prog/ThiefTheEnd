class Camera(val angar: Angar): Units() {

    private var visibility : Int = 0
    private val eyeCam = Eyes()

    init {
        MakeCamera()
    }


    override fun action(){

        if (eyeCam.find(this, angar.thief)) {
            if (visibility > angar.thief.stealth) {
                println("Вор замечен")
                angar.cop.protectChest()
            }
        }

    }

    private fun MakeCamera() {

        val temp = readFile("Camera.txt")
        x = temp[0].toInt()
        y = temp[1].toInt()
        visibility = temp[2].toInt()
        eyeCam.range = temp[3].toInt()

    }

}
