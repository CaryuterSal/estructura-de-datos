class LinkedListUtils {
    public static <T extends Number> void splitEvenOdd(LinkedList<T> original, LinkedList<T> even, LinkedList<T> odd) {
        even.clear();
        odd.clear();
        for(T item: original) {
            int intVal = item.intValue();
            if(intVal % 2 == 0) {
                even.add(item);
            } else {
                odd.add(item);
            }
        }
    }
}
