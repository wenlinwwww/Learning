package regularexpression;

public class Regular {
    public static void main(String[] args) {
        String rgx = "\\w{4-16}";
        String rgx2 = "[1-9]\\d{16}(\\d|x|X)";
        System.out.println("29878998877766087x".matches(rgx2));
        //忽略大小写abc
        String rgx3 = "(?i)abc";
        System.out.println("abc".matches(rgx3));
        System.out.println("ABC".matches(rgx3));
        System.out.println("abC".matches(rgx3));
        String rgx4 = "[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])\\d{3}(\\d|(?i)x)";
        System.out.println("17896019881124797X".matches(rgx4));

    }
}
