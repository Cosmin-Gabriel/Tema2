package chain
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
class CEOHandler(var next1: Handler? = null, var next2: Handler? = null, var next3: Handler? = null): Handler {
    override suspend fun handleRequest( messageToBeProcessed: String) = coroutineScope {
        var send = messageToBeProcessed.split(":")
        var priority = send.elementAt(0)
        var message= send.elementAt(1)
        if (priority == "1") {
            var job=launch{print("Upper CEO " + message)}
            job.join()
        }
        else
        {   var job=launch {
            if (next2 != null) {
                print("Lower CEO to the upper CEO" + message)
                next2?.handleRequest("1:" + message)
            } else {
                print("Upper CEO to the upper Executive " + message)
                next3?.handleRequest(messageToBeProcessed)
            }
        }
            job.join()
        }
    }
}