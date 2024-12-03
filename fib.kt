import java.io.PrintStream

fun main() {
    System.setOut(PrintStream(System.out, true, "UTF-8"))

    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    fun fib(passedMonth: Int, maxAge: Int, matureMonth: Int = 2): LongArray {
        val currentGeneration = LongArray(maxAge) { 0L }
        currentGeneration[0] = 1L 

        for (i in 1 until passedMonth) {
            val newGeneration = LongArray(maxAge) { 0L }
            newGeneration[0] = currentGeneration.slice(matureMonth - 1 until maxAge).sum()

            for (j in 1 until maxAge) {
                newGeneration[j] = currentGeneration[j - 1]
            }

            for (i in currentGeneration.indices) {
                currentGeneration[i] = newGeneration[i]
            }
        }

        return currentGeneration
    }

    println("[${fib(n, m).joinToString(", ")}]")

    println(fib(n, m).sum())  
}
