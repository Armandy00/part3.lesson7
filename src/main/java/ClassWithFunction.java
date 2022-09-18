public class ClassWithFunction {
    @ru.geekbrains.java3.lesson7.BeforeSuite
    public void init() {
        System.out.println("init");
    }

    @MyAnnotation(priority = 1)
    public void test1() {
        System.out.println("test1");
    }

    @MyAnnotation(priority = 2)
    public void test2() {
        System.out.println("test2");
    }

    @MyAnnotation(priority = 3)
    public void test3() {
        System.out.println("test3");
    }

    @MyAnnotation(priority = 4)
    public void test4() {
        System.out.println("test4");
    }

    public void method() {
        System.out.println("method");
    }


    @ru.geekbrains.java3.lesson7.AfterSuite
    public void stop() {
        System.out.println("stop");
    }

}
