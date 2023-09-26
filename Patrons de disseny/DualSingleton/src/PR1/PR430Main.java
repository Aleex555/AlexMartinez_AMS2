package PR1;

import java.lang.reflect.Constructor;

public class PR430Main {
    public static void main(String[] args) {
        System.out.println(".. .iniciant 1 ...");
        PR430Objecte instance1 = PR430Objecte.getInstance("Alex","Martinez",20);
        System.out.println(instance1.toString());

        System.out.println(".. .iniciant 2 ...");
        PR430Objecte instance2 = PR430Objecte.getInstance("Cristian","Camilo",12);
        System.out.println(instance2.toString());

        System.out.println(".. .iniciant 3 ...");
        PR430Objecte instance3 = PR430Objecte.getInstance("Pepito","Pepardo",25);
        System.out.println(instance3.toString());
    }

    static PR430Objecte getNewDestroyedInstance (String nom,String cognom, Integer edat) {
        
        PR430Objecte result = null;
        try {
            Constructor<?>[] constructors = PR430Objecte.class.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                result = (PR430Objecte) constructor.newInstance(nom,cognom,edat);
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

