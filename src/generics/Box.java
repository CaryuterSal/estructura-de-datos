package generics;

public class Box<T> {

    private T value;

    public Box(T value) {
        this.value = value;
    }

    T getValue(){
        return value;
    }

    void setValue(T value){
        this.value = value;
    }
}
