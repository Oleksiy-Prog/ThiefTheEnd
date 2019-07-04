import java.lang.Math.*


class Camera(val thief: Thief, val cop: Cop): Abstract() {

    private var visibility : Int = 0
    private val eyeCam = Eyes()

    init {
        MakeCamera()
    }

    override fun action(){
        if (eyeCam.find(this, thief)) {
            cop?.GoToCam()
        }
    }

    private fun MakeCamera() {
        val temp = readFile("Camera.txt")
        x = temp[0].toInt()
        y = temp[1].toInt()
        visibility = temp[2].toInt()
    }

}
