package fisher.andrew.stockipy.models;

/**
 * Created by andrewfisher on 12/11/16.
 */

public class Food {

    String name;
    private String pushId;

    public Food(String name) {
        this.name = name;
    }
    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getName() {
        return name;
    }

    public String getPushId() {
        return pushId;
    }





}
