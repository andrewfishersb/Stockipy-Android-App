package fisher.andrew.stockipy.models;

import org.parceler.Parcel;

/**
 * Created by andrewfisher on 12/11/16.
 */


@Parcel
public class Food {

    String name;
    private String pushId;
    String index;

    public Food(){}

    public Food(String name) {
        this.name = name;
        this.index = "not_specified";
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
