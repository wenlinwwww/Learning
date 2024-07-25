package searchcode;

public class Test {
    public boolean isValid(String S) {
        var s = S.toCharArray(); // 同时作为栈
        int i = 0; // i-1 表示栈顶下标，i=0 表示栈为空
        for (var c : s) {
            if (c > 'a' && (i == 0 || c - s[--i] != 1))
                return false;
            if (c < 'c')
                s[i++] = c; // 入栈
        }
        return i == 0;
    }
}
