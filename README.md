# Stockipy

## A final project for the Android segment at Epicodus by making a full fledged app, Started on 11/18//16

#### By **Andrew Fisher**

## Description
This app is a multi purpose app grocery and recipe app. The user will be able to save recipes or upload their own recipes. The user can put the recipes into a grocery list to make shopping at the store fast and easy. I would also like the user to keep stock of their fridge so they know what ingredients they do not have to buy.

## Specifications



Day 1 Specs



user input                | output
------------------------- | -------------
The user can enter items onto their shopping list| spaghetti, pork, bell peppers.


user input                | output
------------------------- | -------------
The user enters items in their fridge| In fridge: bananas, corn, pancake mix, onion


user input                | output
------------------------- | -------------
user can see a list of recipes and can click on a recipe to see ingredients| Ingredients: spaghetti, pork, bell pepper,onion. Instructions: Cook

user input                | output
------------------------- | -------------
user can add a recipe to their own personal list | Pork and Breadcrumbs, Mashed Potatoes.


## Setup/Installation Requirements

* Clone from github
* Open up android studio
* go to specific directions and press the launch button and what not specifics for using an emulator vs your own device

## Future Goals and Ideas
* let user add single ingredients to a cart, they are currently just strings in an array.
* make input only one line for new items
* Remove back to list button once a database is set up and use the up button instead
* Add items and don't go back until user says so - maybe implement a toolbar so one can send information back
* With ingredients on shopping list, swipe to delete or add to the fridge
* When adding an item use a modal
* When adding an item to shopping cart, if its in your fridge it will ask if you are sure you want to add it
* Drop down menu or tool bar that has quick ways to navigate towards
* Set number of a specific items or cups/tablespoons left of some item (reach goal)
* suggestion when start typing an ingredient (reach goal) - would be good with API integration
* categorize recipe cuisine (reach goal)

## Technologies Used

* Android
* Java
* XML
* Git


## Known Bugs
* Certain Information does not persist throughout the app as I am currently using ArrayLists instead of FireBase
* User cant see the ingredients if they are in favorite section
* favorite recipes can repeate themselves

### License

*GPL*

Copyright (c) 2016 **Andrew Fisher**
