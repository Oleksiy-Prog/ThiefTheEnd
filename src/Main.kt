import java.io.File//для ввода с файла
import java.util.concurrent.* //для таймера
import javafx.application.Application
import javafx.css.StyleClass
import javafx.fxml.*
import javafx.scene.*
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.shape.Rectangle
import javafx.stage.*
import java.awt.*
import javafx.scene.paint.*
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.scene.text.Text
//import javafx.scene.paint.Paint
import javax.swing.text.Style


fun main(){

    Application.launch(HelloFX::class.java)

}


fun readFile(name : String) : List<String> {
    val inputFile = File(name)
    val listOf = mutableListOf<String>()

    for (line in inputFile.readLines()) {
        for (word in line.split(" ")) {
            listOf.add(word)
        }
    }

    return listOf.toList()
}


class HelloFX : Application() {


    override fun start(stage: Stage) {

        val angar = Angar()

        stage.title = "Thief"

        val canvas = Canvas(600.0, 600.0)
        val context = canvas.graphicsContext2D

        val root = Group()
        val scene = Scene(root,600.0, 700.0)
        root.children.add(canvas)

        stage.scene = scene

        drawWalls(context, angar)

        context.fill = Color.YELLOW
        context.fillRect(angar.chest.x*50+55.toDouble(), angar.chest.y*50+55.toDouble(), 40.0, 40.0)
        context.fill = Color.WHITE
        context.fillOval(angar.camera.x*50+55.toDouble(), angar.camera.y.toDouble()*50+55, 40.0 , 40.0)

        val vor = Circle(angar.thief.x.toDouble()*50+75, angar.thief.y.toDouble()*50+75, 20.0, Color.RED)
        val ment = Circle(angar.cop.x.toDouble()*50+75, angar.cop.y.toDouble()*50+75, 20.0, Color.BLUE)

        val button = Button("Старт")
        button.layoutX = 280.0
        button.layoutY = 630.0

        var label = Label("Ожидание")
        label.layoutX = 270.0
        label.layoutY = 580.0

        root.children.add(vor)
        root.children.add(ment)
        root.children.add(button)
        root.children.add(label)

        stage.show()

        ////////////////////////////////////////////////////

        val exec = Executors.newSingleThreadScheduledExecutor()
        exec.scheduleAtFixedRate( {

            angar.changes()
            chan(vor, ment, angar)

            if (angar.chest.isEmpty || !angar.thief.isAlive) {
                if (angar.chest.isEmpty){
                    label = Label("Сундук обчищен")
                    root.children.add(label)
                }else{
                    label = Label("Вор пойман")
                    root.children.add(label)
                }
                exec.shutdown()
            }

        }, 0, 500, TimeUnit.MILLISECONDS)

        ////////////////////////////////////////////////////////

    }

    private fun drawWalls(gc: GraphicsContext, angar: Angar) {

        gc.fill = Color.GREY
        gc.fillRect(50.0, 50.0, 500.0, 500.0)

        for (i in 0..9) {
            for (j in 0..9) {
                if (angar.map[i*10 + j] == 0) {
                    gc.fill = Color.BLACK
                    gc.fillRect(i*50.0+50, j*50.0+50, 50.0, 50.0 )
                }
            }
        }

    }

    private fun chan(vor: Circle, ment: Circle, angar: Angar){
        vor.centerX = (angar.thief.x * 50 + 75).toDouble()
        vor.centerY = (angar.thief.y * 50 + 75).toDouble()
        ment.centerX = (angar.cop.x * 50 + 75).toDouble()
        ment.centerY = (angar.cop.y * 50 + 75).toDouble()

    }

}
