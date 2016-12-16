package fisher.andrew.stockipy.models;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by Guest on 12/2/16.
 */
@Parcel
public class Recipe {
    String label;
    String image;
    String url;
    ArrayList<String> ingredientLines;
    Integer calories;
    Integer yield;
    private String pushId;

    public Recipe(){}

    public Recipe(String label, String image, String url, ArrayList<String> ingredientLines, Integer calories, Integer yield) {
        this.label = label;
        this.image = image;
        this.url = url;
        this.ingredientLines = ingredientLines;
        this.calories = calories;
        this.yield = yield;
    }

    public String getLabel() {
        return label;
    }

    public String getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }

    public ArrayList<String> getIngredientLines() {
        return ingredientLines;
    }

    public Integer getYield() {
        return yield;
    }

    public Integer getCalories(){
        return  calories;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }



}
