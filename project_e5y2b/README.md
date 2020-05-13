# My Personal Project

## An app keeps track of what you read

Users can use this app to record books that they are reading or 
willing to read later. This app is useful to people among all age
groups. Here's what it can do:

- records the information of books: title, author, genre, total
number of pages
- keeps track of the page number that you at
- keeps track of your total reading time
- gets a report of which genre you have most interest in based on
the records

I often get lost between books since I usually read several books 
at the same time. With this app, I can get an idea of my reading
progress on certain books.


##User Stories

- As a user, I want to be able to create a new book, which has
title, author name and total page number, and add it to my
reading list
- As a user, I want to be able to view my reading list
- As a user, I want to be able to update my reading progress (number
of pages read and time spent) on certain books
- As a user, I want to view a report of my interest based on what I 
read sorted by genre. It can be based on number of pages read or
reading time
- As a user, I want to be able to save my reading list to the file
- As a user, I want to be able to load my reading list that I saved 
last time

##Citation
https://github.students.cs.ubc.ca/CPSC210/TellerApp.git 

ui ReadingList: https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Complete.git

##Instructions for Grader

- You can generate the first required event by clicking "Add new book" to add a new book to the reading list.
- You can generate the second required event by clicking "Delete book" to delete a book from the reading list.
- You can locate my visual component by clicking on "Reading List" to see 
the image. (The image also shows up when the app starts)
- You can save the state of my application by clicking "Save list".
- The state of the application to file loads automatically when the app
starts. 

##Phase 4: Task 2
- Included a type hierarchy in the code\
In the tool package, all of DeleteTool, NewBookTool, ReadingListTool,ReportOfInterestTool,
SaveTool, and UpdateReadingProgressTool extend the Tool class. They all override
the createButton and addListener method in different ways. For the createButton method,
the subclasses create distinct buttons with their own name. For the addListener method,
the subclasses create different listeners that switch to corresponding windows when the mouse clicked.

##Phase 4: Task 3
- One of the fields in ReadingList - tools - is not necessary since except adding new tools to 
it, there's no method using it. Deleting the list of tools decreases coupling and also leads to 
the deletion of initializeFields method in the same class. Also, the part of code that adds new tools
to the list of tools can also be deleted.
- The AppData class, which used to be the command line that user can interact with, has 
some functionality that are no longer needed. In order to increase cohesion and decrease coupling,
I deleted the functionality that ReadingListApp has already achieved. Also, I renamed the class(used to 
be ReadingApp) to be more clear. Lastly, I refactored the method to print out the reading report
to the ReportOfInterestWindow class, which makes sure that AppData class only focus on saving and loading
data(increases cohesion).