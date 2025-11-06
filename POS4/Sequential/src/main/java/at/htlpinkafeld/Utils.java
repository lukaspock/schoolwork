package at.htlpinkafeld;

public class Utils {

    static void processAll(Sequential sequential, Action action){
        Object obj;

        obj = sequential.getFirst();

        while( obj != null ){
            action.process(obj);
            obj = sequential.getNext();
        }
    }
}
