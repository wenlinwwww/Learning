package lambdademo;

public class Lambda2 {
    public static void main(String[] args) {
        method(new Swim() {
            @Override
            public void swimming() {
                System.out.println("swimming");
            }
        });
        method(() -> {
            System.out.println("swimming");
        });
    }

    public static void method(Swim a) {
        a.swimming();
    }
}

@FunctionalInterface
interface Swim {
    void swimming();
}
