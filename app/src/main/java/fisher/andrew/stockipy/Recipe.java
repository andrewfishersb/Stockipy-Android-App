package fisher.andrew.stockipy;

import java.util.ArrayList;

/**
 * Created by Guest on 12/2/16.
 */
public class Recipe {
    String label;
    String image;
    String url;
    ArrayList<String> ingredientLines;
    Integer calories;
    Integer yield;

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

    public Integer getCalories() {
        return calories;
    }

    public Integer caloriesPerPerson(){
        double calculated = (float)this.calories/this.yield;
        Integer perPerson = (int) calculated;
        return  perPerson;
    }


    public Integer getYield() {
        return yield;
    }
}
