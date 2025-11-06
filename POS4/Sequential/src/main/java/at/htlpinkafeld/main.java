package at.htlpinkafeld;

public class main {
    public static void main(String[] args) {
        IntStack iStack = new IntStack(20);
        iStack.push(50);
        iStack.push(40);
        iStack.push(30);
        iStack.push(20);
        iStack.push(10);


        Accumolator acc = new Accumolator();

        Utils.processAll(iStack,new ShowIt());
        Utils.processAll(iStack,acc);
        System.out.println("Total : "+acc.getTotal());
    }
}
