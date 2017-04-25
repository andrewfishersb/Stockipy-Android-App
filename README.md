# Stockipy

## A final project for the Android segment at Epicodus by making a full fledged app, Started on 11/18/16

#### By **Andrew Fisher**

## Description
This a multi-purpose app, combining shopping lists and recipes. A User can look up recipes using the Edamam API, add and delete items from a shopping cart, and keep track of items in your kitchen.

![recipe1](https://cloud.githubusercontent.com/assets/17396138/25404740/eba19498-29b5-11e7-9c30-be49734910ef.jpg)
![recipe2](https://cloud.githubusercontent.com/assets/17396138/25404741/eba8939c-29b5-11e7-8a70-1c5f84641e9f.jpg)

## Specifications



### Week 1



|user input                | output
|------------------------- | -------------
|1. The user can enter items onto their shopping list| spaghetti, pork, bell peppers.
|2. The user enters items in their fridge| In fridge: bananas, corn, pancake mix, onion
|3. user can see a list of recipes and can click on a recipe to see ingredients| Ingredients: spaghetti, pork, bell pepper,onion. Instructions: Cook
|4. user can add a recipe to their own personal list | Pork and Breadcrumbs, Mashed Potatoes.

### Week 2

|user input                | output
|------------------------- | -------------
|1. The app will request recipe information from the Edamam Recipe Search API and list using a Recycler View| Chicken Sandwich, Buffalo Wings, Jerk Chicken.
|2. The app will show all ingredients calorie information when recipe is clicked| 500 calories per person, peppers, mashed potatoes
|3. The app will use link the user to the webpage with more information about the recipe| www.recipes.com/bbq-sandwich

### Week 3

|user input                | output
|------------------------- | -------------
|1. User will now use a search bar to search for a recipe by item: i.e. "Chicken"| Chicken Sandwich, Buffalo Wings, Jerk Chicken.
|2. User can create an account with an email and password | Welcome new user
|3. User can then log into the app| Welcome to Stockipy
|4. User can then log out| Goodbye!
|5. Kitchen items can be added to a database: eggs | eggs have been added to your kitchen stock
|6. Shopping items can be added to a database: cereal | cereal have been added to your shopping list
|7. User can add a recipe to a list of favorites in the database | Favorite Recipes: Chicken Sandwich, Buffalo Wings

### Week 4

|user input                |
|------------------------- |
|1. User can swipe right to delete a a kitchen items or shopping list item|
|2. User can swipe left to add kitchen item to cart, or to add a shopping list item to your kitchen on their respective activities |
|3. User can navigate to other pages easier with the overflow menu|
|4. User can change apps look by working in landscape mode|


## Setup/Installation Requirements

```
 Clone from github
 Open up android studio
 plug in your own device or set up an emulator
 press run, select the device and the app should run
 if it does not start go to Build->Clean Project
```


## Future Goals and Ideas
* use overflow menu on every page to log out or go to different parts of the page
* when user signs up for the first time have a view that tells the user to search for a recipe in the top bar - on the recipe activity
* make input only one line for new items
* With ingredients on shopping list, swipe to delete or add to the fridge
* When adding an item use a dialog on the same activity instead of a new page
* When adding an item to shopping cart, if its in your fridge it will ask if you are sure you want to add it
* Dialog box which displays all ingredients and check boxes for what to add to your shopping list
* Drop down menu or tool bar that has quick ways to navigate towards
* Set number of a specific items or cups/tablespoons left of some item (reach goal)
* suggestion when start typing an ingredient (reach goal) - would be good with API integration
* categorize recipe cuisine (reach goal)



## Technologies Used

* Android
* Java
* XML
* Gradle
* Git
* Edamam Recipe Search API


## Known Bugs or Improvements
* When an item is liked then the user goes to another page and comes back to the same page the heart is empty again.
* Can like the same item again.

### License

*GPL*

Copyright (c) 2016 **Andrew Fisher**
