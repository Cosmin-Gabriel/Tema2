package chain
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
class ManagerHandler(var next1: Handler? = null, var next2: Handler? = null, var next3: Handler? = null): Handler {
    override suspend fun handleRequest(messageToBeProcessed: String) = coroutineScope {
        var send=messageToBeProcessed.split(":")
        var priority=send.elementAt(0)
        var message=send.elementAt(1)
        if(priority=="3") {
            var job=launch{
            if (next1 == null) {
                print("Upper Manager and I manufacture the message, then I will send it  " + message)
                next2?.handleRequest(messageToBeProcessed)
            } else {
                print("Lower Manager to the lower Executive " + message)
                next1?.handleRequest(messageToBeProcessed)
            }
                }
            job.join()
        }
        else
        {
            var job=launch {
                if (next1 != null) {
                    print("Lower Manager to the lower Executive" + message)
                    next1?.handleRequest(messageToBeProcessed)
                } else {
                    print("Upper Manager to the upper HappyWorker " + message)
                    next3?.handleRequest(messageToBeProcessed)
                }
            }
            job.join()
        }
    }
}