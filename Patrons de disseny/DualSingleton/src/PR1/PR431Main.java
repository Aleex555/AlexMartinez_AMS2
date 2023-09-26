package PR1;

import java.lang.reflect.Constructor;

public class PR431Main {
    public static void main(String[] args) {
        System.out.println(".. .iniciant 1 ...");
        PR431Objecte instance1 = PR431Objecte.getInstance("Alex","Martinez",20);
        System.out.println(instance1.toString());

        System.out.println(".. .iniciant 2 ...");
        PR431Objecte instance2 = getNewDestroyedInstance("Cristian","Camilo",12);
        System.out.println(instance2.toString());

        System.out.println(".. .iniciant 3 ...");
        PR431Objecte instance3 = getNewDestroyedInstance("Pepito","Pepardo",25);
        System.out.println(instance3.toString());
    }

    static PR431Objecte getNewDestroyedInstance (String nom,String cognom, Integer edat) {
        
        PR431Objecte result = null;
        try {
            Constructor<?>[] constructors = PR431Objecte.class.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                result = (PR431Objecte) constructor.newInstance(nom,cognom,edat);
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
