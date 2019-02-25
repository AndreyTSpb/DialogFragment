package potaskun.enot.dialogfragment;

/**
 * Для добавления макета пользователя в ListView
 */
public class User {
    private String name;
    private String bal1;
    private String bal2;
    private String  bal3;

    public User(String name, String  bal1, String bal2, String bal3 ){
        this.name = name;
        this.bal1 = bal1;
        this.bal2 = bal2;
        this.bal3 = bal3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name =  name;
    }

    public String getBal1() {
        return bal1;
    }

    public void setBal1(String bal1) {
        this.bal1 = bal1;
    }

    public String getBal2() {
        return bal2;
    }

    public void setBal2(String bal2) {
        this.bal2 = bal2;
    }

    public String getBal3() {
        return bal3;
    }

    public void setBal3(String bal3) {
        this.bal3 = bal3;
    }
}
