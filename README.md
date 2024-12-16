# SpringMVCFilmCRUD

## Description 
This program is a very simple film database webpage. On the home page the user has 4 choices: 
	1) search for films using the film id
	2) search for films using a keyword 
	3) add a film to the database
	4) delete a film from the database

When a user searches by the film id, a result page will populate showing the film details, along with options to update the film details, delete the film or return to the homepage. If a user uses a keyword to search the data base, a result page will show a list of films found that include the keyword in the title or film description. On the same page, the user can delete a film from the database or return to the home page where they can enter in the film id in the search by film id option and update film details.

When a user adds a film to the database, they'll be prompted to complete a form to add all the required details and after submitting the form a new page will populate showing the film info. The user can then decide if they want to update film details, delete the film or return to the homepage.

If a user decides to delete a film from any of the web pages, a new page will populate showing the film id and title of the film deleted. They can continue deleting films on that page or return to the home page.

## Technologies Used
* Java
* Eclipse
* MacOS Terminal
* MySQL
* Sublime
* Tomcat
* Spring MVC
* MAMP
* Gradle
* SQL

## Concepts used
This was our first attempt to build an application that implemented web-based C.R.U.D functionality, used Spring MVC and the DAO pattern. 

## Lessons learned
This project was a real challenge which made for a lot of learning lessions. We are now more familiar with MVC and knowing how to link the jsps to the controller, the syntax that goes into using the @RequestMapping annotations, and using the GET and POST Request Methods. This project allowed us to practice making multiple jsps, implementing new tags and some use of Expression Language ( ex: ${ }). We also were able to practice troubleshooting various error types and work on understanding what triggered those issues.

Unfortunately, we still struggled to figure out how to add restrictions to not edit or delete certain objects in our database, as well as figuring out how to handle invalid user entries. We also tried to focus on the functionality of our application rather than target CSS/Bootstrap edits which resulted in a lackluster design. 


