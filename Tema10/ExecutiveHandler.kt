package chain
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
class ExecutiveHandler(var next1: Handler? = null, var next2: Handler? = null, var next3: Handler? = null): Handler {
    override suspend fun handleRequest(messageToBeProcessed: String) = coroutineScope {
        var send=messageToBeProcessed.split(":")
        var priority=send.elementAt(0)
        var message=send.elementAt(1)
        if(priority=="2") {
            var job=launch {
                if (next1 == null) {
                print("Upper Executive and I manufacture the message, then I will send it" + message)
                next2?.handleRequest(messageToBeProcessed)
                }
                else {
                print("Lower Executive to the lower CEO" + message)
                next1?.handleRequest(messageToBeProcessed)
                }
            }
            job.join()
        }
        else
        {
            var job=launch {
                if(next1!=null) {
                    print("Lower Executive to the lower CEO" + message)
                    next1?.handleRequest(messageToBeProcessed)
                }
                else {
                    print("Upper Executive to the upper Manager " + message)
                    next3?.handleRequest(messageToBeProcessed)
                }
            }
            job.join()
        }
    }
}