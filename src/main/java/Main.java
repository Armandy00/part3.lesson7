import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {
        Object myObj = new ClassWithFunction();
        Class<?> testClass =  myObj.getClass();

        Method[] methods = testClass.getDeclaredMethods();
        ArrayList<Method> metodsNew = new ArrayList<>();
        Method beforeMethod = null;
        Method afterMethod = null;
        for (Method o : testClass.getDeclaredMethods()) {
            if (o.isAnnotationPresent(MyAnnotation.class)) {
                metodsNew.add(o);
            }
            if (o.isAnnotationPresent(ru.geekbrains.java3.lesson7.BeforeSuite.class)) {
                if (beforeMethod == null) beforeMethod = o;
                else throw new RuntimeException("Больше одного метода с аннотацией BeforeSuite");
            }
            if (o.isAnnotationPresent(ru.geekbrains.java3.lesson7.AfterSuite.class)) {
                if (afterMethod == null) afterMethod = o;
                else throw new RuntimeException("Больше одного метода с аннотацией AfterSuite");
            }
            metodsNew.sort(new Comparator<Method>() {
                @Override
                public int compare(Method o1, Method o2) {
                    return o1.getAnnotation(MyAnnotation.class).priority()-o2.getAnnotation(MyAnnotation.class).priority();
                }
            });

        }


        if (beforeMethod != null) beforeMethod.invoke(myObj);
        for (Method o : metodsNew) o.invoke(myObj);
        if (afterMethod != null) afterMethod.invoke(myObj);
    }
}
