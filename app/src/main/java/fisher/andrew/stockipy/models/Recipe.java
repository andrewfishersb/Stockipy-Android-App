package fisher.andrew.stockipy.models;

import java.util.ArrayList;

/**
 * Created by Guest on 12/2/16.
 */
public class Recipe {
    String label;
    String image;
    String url;
    ArrayList<String> ingredientLines;
    int calories;
    int yield;

    public Recipe(String label, String image, String url, ArrayList<String> ingredientLines, int calories, int yield) {
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

    public int getCalories() {
        return calories;
    }

    public int getYield() {
        return yield;
    }
}
