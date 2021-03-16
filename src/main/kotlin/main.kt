fun main() {
    val howLngAgo:Int = 60*21
    println("result: " + agoToText(howLngAgo))
}
fun agoToText(seconds:Int) : String{
    val result:String = when(seconds) {
        in 0..60 -> "bil tolko chto"
        in 61..60*60 -> {
            //numToWord(seconds/60, "minutu", "minuti", "minut")
            minutes(seconds/60)
        }
        in 60*60+1..24*60*60 -> {
            //numToWord(seconds/60*60, "chas", "chasa", "chasov")
            hours(seconds/60*60)
        }
        in 24*60*60..24*60*60*2 -> "bil segodna"
        in 24*60*60*2+1..24*60*60*3 -> "bil vchera"
        //(seconds>(24*60*60*3+1)) -> "bil davno"
        else -> "bil davno"

    }
    return result
}

fun numToWord(scnds:Int, word1:String, word2:String, word3:String):String {
    var num = scnds % 100;
    if ((num > 19)||(num<=10)) {
        num = num % 10;
    }
    val result = when(num){
        1 ->  "bil $scnds $word1 nazad"
        2 ->  "bil $scnds $word2 nazad"
        else ->  "bil $scnds $word3 nazad"
    }
    return result
}

fun minutes(scnds:Int):String{
    return numToWord(scnds,"minutu","minuti","minut")
}
fun hours(scnds:Int):String{
    return numToWord(scnds,"chas","chasa","chasov")
}
