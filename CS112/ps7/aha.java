public class aha {
    // public boolean push(T item) {
    //     Q2.insert(item);
    //     while (!Q1.isEmpty()) {
    //         Q2.insert(Q1.remove());
    //     }
    //     Q1 = Q2;
    //     return true;
    // }

    // public T peek() {
    //     return Q1.peek();
    // }
   
    // public T pop() {
    //     return Q1.remove();
    // }
    
    // public aha(){

    // }

    
    public static void main(String[] args) {
        LLStack testStack = new LLStack();
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        testStack.push(4);
        testStack.push(5);
        System.out.println("run before: " + testStack.toString());
        System.out.println("pop returns: " + testStack.pop());
        System.out.println("=======================================");


    }
}