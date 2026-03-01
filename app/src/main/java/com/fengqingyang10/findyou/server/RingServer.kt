import java.io.*
import java.net.*

class RingServer {
    private val port = 12345
    private lateinit var serverSocket: ServerSocket

    fun startServer() {
        try {
            serverSocket = ServerSocket(port)
            println("Server is listening on port: $port")

            while (true) {
                val clientSocket = serverSocket.accept()
                handleClient(clientSocket)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            serverSocket.close()
        }
    }

    private fun handleClient(clientSocket: Socket) {
        println("Client connected: " + clientSocket.inetAddress.hostAddress)
        BufferedReader(InputStreamReader(clientSocket.getInputStream())).use { reader ->
            val command = reader.readLine()
            println("Received command: $command")
        }
        clientSocket.close()
    }
}

fun main() {
    val server = RingServer()
    server.startServer()
}