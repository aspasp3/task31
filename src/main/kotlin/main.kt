fun main() {
    val howLngAgo = 60*60*2
    println("result: " + agoToText(howLngAgo))
}
fun agoToText(seconds:Int) : String{
    val result:String = when {
        (seconds>0) && (seconds<=60) -> "bil tolko chto"
        //(seconds>60) && (seconds<=60*60) -> "x минут назад"
        //(seconds>(60*60+1)) && (seconds<=(24*60*60)) -> "x часов назад"
        (seconds>60) && (seconds<=60*60) -> {
            Num2word(seconds/60, "minutu", "minuti", "minut")
        }
        (seconds>60*60+1) && (seconds<=24*60*60) -> {
            Num2word(seconds/(60*60), "chas", "chasa", "chasov")
        }
        (seconds>(24*60*60)) && (seconds<=(24*60*60*2)) -> "bil segodna"
        (seconds>(24*60*60*2+1)) && (seconds<=(24*60*60*3)) -> "bil vchera"
        (seconds>(24*60*60*3+1)) -> "bil davno"
        else -> ""
    }
    return result
}

fun Num2word(scnds:Int, word1:String, word2:String, word3:String):String {
    var num = scnds % 100;
    if (num > 19) {
        num = num % 10;
    }
    val result = when(num){
        1 ->  "bil $scnds $word1 nazad"
        2 ->  "bil $scnds $word2 nazad"
        else ->  "bil $scnds $word3 nazad"
    }
    return result
}