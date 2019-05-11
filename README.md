# Stockipy (DEPRECIATED --- THE API USED NO LONGER EXISTS)

#### By **Andrew Fisher**

## Description
This a multi-purpose app, combining shopping lists and recipes.

![recipe1](https://cloud.githubusercontent.com/assets/17396138/25404740/eba19498-29b5-11e7-9c30-be49734910ef.jpg)
![recipe2](https://cloud.githubusercontent.com/assets/17396138/25404741/eba8939c-29b5-11e7-8a70-1c5f84641e9f.jpg)

## User Stories
* As a user, I want to keep track of a shopping list.
* As a user, I want to delete items from my shopping list.
* As a user, I want to search for new recipes.
* As a user, I want to save recipes to view at a later date.


## Specifications

* On Launch:
  - Create an Account.
  - Log into an Account.
  - If logged in load landing screen.
* Landing screen Screen:
  - Tap to view shopping list
  - Tap to search for recipes.
  - Tap to view favorite recipes.
* Shopping List Screen:
  - Add items.
  - Re-arrange items
  - Swipe to delete items.
* Recipe Search Screen:
  - Search for a recipe.
  - Finds recipes using the Edamam API.
  - View all recipes pertaining to the search.
  - Tap a recipe to view more details about a particular recipe.
* Recipe Details Screen:
  - Displays information about the recipe including:
    * Recipe name.
    * Calories per person.
    * How many people the recipe serves.
    * Ingredients.
  - Tap "Instructions"
    * Opens a new window in the users browser with directions on how to make the recipe.
    * Uses an Implicit Intent.
  - Save Recipe.
* Favorite Recipe screen:
  - Shows all previously saved recipes.

## Setup/Installation Requirements

```
 Clone from github
 Open up android studio
 plug in your own device or set up an emulator
 press run, select the device and the app should run
 if it does not start go to Build->Clean Project
```


## Future Goals and Ideas
* Use hamburger slider
* Add items using a dialog box or without switching pages
* Implement a Fridge List (Removed originaly for splicity sake).
* Add ingredients from recipe to shopping cart.
* Dialog box which displays all ingredients and check boxes for what to add to your shopping list
* suggestion when start typing an ingredient (reach goal) - would be good with API integration




## Technologies Used

* Android SDK
* Java
* Edamam Recipe Search API
* XML
* Gradle
* Git

## Known Bugs or Improvements
* When an item is liked then the user goes to another page and comes back to the same page the heart is empty again.
* Can like the same item again.

### License

*GPL*

Copyright (c) 2016 **Andrew Fisher**
