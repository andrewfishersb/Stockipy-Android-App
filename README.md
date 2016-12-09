# Stockipy

## A final project for the Android segment at Epicodus by making a full fledged app, Started on 11/18//16

#### By **Andrew Fisher**

## Description
This app is a multi purpose app grocery and recipe app. The user will be able to save recipes or upload their own recipes. The user can put the recipes into a grocery list to make shopping at the store fast and easy. I would also like the user to keep stock of their fridge so they know what ingredients they do not have to buy.

## Specifications



### Week 1 Specs



|user input                | output
|------------------------- | -------------
|1. The user can enter items onto their shopping list| spaghetti, pork, bell peppers.
|2. The user enters items in their fridge| In fridge: bananas, corn, pancake mix, onion
|3. user can see a list of recipes and can click on a recipe to see ingredients| Ingredients: spaghetti, pork, bell pepper,onion. Instructions: Cook
|4. user can add a recipe to their own personal list | Pork and Breadcrumbs, Mashed Potatoes.

### Week 2 Specs

|user input                | output
|------------------------- | -------------
|1. The app will request recipe information from the Edamam Recipe Search API and list using a Recycler View| Chicken Sandwich, Buffalo Wings, Jerk Chicken.
|2. The app will show all ingredients calorie information when recipe is clicked| 500 calories per person, peppers, mashed potatoes
|3. The app will use link the user to the webpage with more information about the recipe| www.recipes.com/bbq-sandwich

### Week 3 Specs

|user input                | output
|------------------------- | -------------
|1. User will now use a search bar to search for a recipe by item: i.e. "Chicken"| Chicken Sandwich, Buffalo Wings, Jerk Chicken.
|2. User can create an account with an email and password | Welcome new user
|3. User can then log into the app| Welcome to Stockipy
|4. User can then log out| Goodbye!
|5. Kitchen items can be added to a database: eggs | eggs have been added to your kitchen stock
|6. Shopping items can be added to a database: cereal | cereal have been added to your shopping list
|7. User can add a recipe to a list of favorites in the database | Favorite Recipes: Chicken Sandwich, Buffalo Wings


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
* Make api call on homepage so it doesnt load everytime I press back or find recipe (or on the search page when i create it).
* If shopping list and fridge list look the same then maybe refractor to be the same layout
* make input only one line for new items
* Remove back to list button once a database is set up and use the up top button instead
* Add items and don't go back until user says so - maybe implement a toolbar so one can send information back
* With ingredients on shopping list, swipe to delete or add to the fridge
* When adding an item use a dialog on the same activity instead of a new page
* When adding an item to shopping cart, if its in your fridge it will ask if you are sure you want to add it
* Dialog box which displays all ingredients and check boxes for what to add to your shopping list
* when displaying recipes try and use a staggeredgridlayoutmanager
* Drop down menu or tool bar that has quick ways to navigate towards
* Set number of a specific items or cups/tablespoons left of some item (reach goal)
* suggestion when start typing an ingredient (reach goal) - would be good with API integration
* categorize recipe cuisine (reach goal)

# Known Bugs or Improvements
* When an item is liked then the user goes to another page and comes back to the same page the heart is empty again
* Can like the same item again

## Technologies Used

* Android
* Java
* XML
* Gradle
* Git
* Edamam Recipe Search API


## Known Bugs
* Certain Information does not persist throughout the app as I am currently using ArrayLists instead of FireBase
* User cant see the ingredients if they are in favorite section
* favorite recipes can repeat themselves

### License

*GPL*

Copyright (c) 2016 **Andrew Fisher**
