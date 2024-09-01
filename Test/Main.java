package Test;

import java.util.*;


class Food {

}

class Fruit extends Food{

}

class Apple extends Fruit {

}

public class Main {
    
    public static void main(String[] args) {
        
        try (AutoCloseClass d = new AutoCloseClass()) {
            System.out.println("Finish process");
        } catch(Exception e) {
            e.printStackTrace();
        }

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(1);
        deque.offerFirst(2);
        deque.offerLast(3);
        System.out.println(deque.pollFirst() + " " + deque.pollLast());

        //List<? extends Fruit> fruits = new ArrayList<Food>();
        // List<? extends Fruit> fruits = new ArrayList<Apple>();
        // fruits.add(new Fruit());

        List<? super Fruit> fruits = new ArrayList<Food>();
        fruits.add(new Apple());
        Object fruit = fruits.get(0);

        byte a = 127; a+=2;
        System.out.println(a);

        System.out.println((3*0.1 == 0.3));
    }


    public static class AutoCloseClass implements AutoCloseable {

        @Override
        public void close() throws Exception {
            System.out.println("Close resource");
        }
    }

}
