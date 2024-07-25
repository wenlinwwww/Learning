package oopshallowcopy;

import java.util.Arrays;
import java.util.Objects;

/*Cloneable
* 如果一个接口里面没有抽象方法，表示当前的窗口是一个标记性接口
* 现在cloneable表示一旦实现，那么当前类的对象就可以被克隆
* 如果没有被实现，当前类的对象就不能被克隆*/
public class User implements Cloneable {
    private int id;
    private String username;
    private String password;
    private String path;
    private int[] data;

    public User() {
    }

    public User(int id, String username, String password, String path, int[] data) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.path = path;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", path='" + path + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    // shallow copy
//    @Override
//    public User clone() {
//        try {
//            User clone = (User) super.clone();
//            // TODO: copy mutable state here, so the clone can't change the internals of the original
//            return clone;
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }

    //deep copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        int[] data = this.data;
        int[] newDta = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            newDta[i] = data[i];
        }
        User u = (User) super.clone();
        u.data = newDta;
        return u;
    }
}
