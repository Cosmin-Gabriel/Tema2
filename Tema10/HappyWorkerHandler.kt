package chain
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
class HappyWorkerHandler(var next1: Handler? = null, var next2: Handler? = null, var next3: Handler? = null): Handler {
    override suspend fun handleRequest(messageToBeProcessed: String) = coroutineScope {
        var send=messageToBeProcessed.split(":")
        var prioriy=send.elementAt(0)
        var msj=send.elementAt(1)
        if(priority=="4") {
            var job=launch {
                if (next1 == null) {
                    print("Upper Happyworker and I manufacture the message, thrn I will send it down " + message)
                    next2?.handleRequest(messageToBeProcessed)
                } else {
                    print("Lower HappyWorker to the lower Manager" + message)
                    next1?.handleRequest(messageToBeProcessed)
                }
            }
            job.join()
        }
        else
        {
            var job=launch {
            throw Exception("No one to solve this")
            }
            job.join()
        }
    }
}
