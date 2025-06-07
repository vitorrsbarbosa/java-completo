package modulo17.generics.intro.services;

import java.util.ArrayList;
import java.util.List;

public class PrintService<T> {
    List<T> list = new ArrayList<>();
    public void addValue(T value){
        list.add(value);
    }
    public T first(){
        if(list.isEmpty()){
            throw new IllegalStateException("List is empty");
        }
        return list.get(0);
    }
    public void print(){
        System.out.print("[");
        if(!list.isEmpty()) {
            System.out.print(list.getFirst());
        }
        for (int index = 1 ; index < list.size() ; index++) {
            System.out.print(", " + list.get(index));
        }
        System.out.print("]");

    }
}
