package java_threading;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class SampleClass {
    public SampleClass() {
        System.out.println("Sample Class object initialized");
    }

    public void hello() {
        System.out.println("hello from sample");
    }
}

public class ClassLoaderDemo {
    public static void main(String[] args) {
        try
        {
            Class<?> cls = Class.forName("java_threading.SampleClass");

            System.out.println("Class Name: " + cls.getName());
            System.out.println("Package Name: " + cls.getPackage());
            Method[] methods = cls.getDeclaredMethods();
            System.out.println("-----Methods of String class -------------");
            for (Method method : methods)
            {
                System.out.println(method.getName());

            }

            Constructor<?> ctor = cls.getConstructor();
            Object object = ctor.newInstance();
            System.out.println("Invoking the first method");
            methods[0].invoke(object);

        }
        catch (ClassNotFoundException | NoSuchMethodException e)
        {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
