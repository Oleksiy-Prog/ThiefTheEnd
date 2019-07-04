import java.io.File


fun main(){

    //val angar = Angar()

    val nos = mutableSetOf<Pair<Int, Int>>()

    for (i in 1..3){
        for (j in 1..3){
            nos.add(Pair(i, j))
        }
    }


    if (nos.contains(Pair(1, 4))){
        println(Pair(1, 4))
    }


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
