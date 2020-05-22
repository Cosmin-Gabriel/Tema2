import org.graalvm.polyglot.*;
class Polyglot {
    private static String RToUpper(String token){
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        Value result = polyglot.eval("R", "toupper(\""+token+"\");");
        String result_String = result.asString();
        polyglot.close();

        return result_String;
    }

    private static int SumCRC(String token){

        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        Value result = polyglot.eval("python", "sum(ord(ch) for ch in '" + token + "')");
        int result_int = result.asInt();
        polyglot.close();

        return result_int;
    }


    public static void main(String[] args) {

        Context polyglot = Context.create();

        Value array = polyglot.eval("js", "[\"If\",\"we\",\"run\",\"the\",\"mb\"," +
                "\"command\",\"included\",\"in\",\"GraalVM\",\"we\"," +
                "\"will\",\"be\",\"automatically\",\"using\",\"the\"," +
                "\"Graal\",\"JIT\",\"compiler\",\"no\",\"extra\",\"configuration\"," +
                "\"is\",\"needed\",\"I\",\"will\",\"use\",\"the\",\"time\"," +
                "\"command\",\"to\",\"get\",\"the\",\"real\",\"wall\",\"clock\"," +
                "\"elapsed\",\"time\",\"it\",\"takes\",\"to\",\"run\",\"the\"," +
                "\"entire\",\"program\",\"from\",\"start\",\"to\",\"finish\"," +
                "\"rather\",\"than\",\"setting\",\"up\",\"a\",\"complicated\"," +
                "\"micro\",\"benchmark\",\"and\",\"I\",\"will\",\"use\",\"a\"," +
                "\"large\",\"input\",\"so\",\"that\",\"we\",\"arent\",\"quibbling\"," +
                "\"about\",\"a\",\"few\",\"seconds\",\"here\",\"or\",\"there\"," +
                "\"The\",\"large.txt\",\"file\",\"is\",\"150\",\"MB\"];");


        for (int i = 0; i < array.getArraySize();i++){
            String Array_element = array.getArrayElement(i).asString();
            String upper = RToUpper(Array_element);

            int crc = SumCRC(upper);
           if(crc == 143)
           {
                System.out.println(upper + " ---> " + crc);
           }
        }

        polyglot.close();
    }
}
