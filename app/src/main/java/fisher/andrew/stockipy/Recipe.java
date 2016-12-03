package fisher.andrew.stockipy;

import java.util.ArrayList;

import org.parceler.Parcel;


@Parcel
public class Recipe {
    String label;
    String image;
    String url;
    ArrayList<String> ingredientLines;
    double calories;
    int yield;

    public Recipe(){}
    public Recipe(String label, String image, String url, ArrayList<String> ingredientLines, double calories, int yield) {
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
        double caloriesPerPerson = this.calories/this.yield;
        return (int) caloriesPerPerson;
    }

    public int getYield() {
        return yield;
    }
}
