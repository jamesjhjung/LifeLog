# LifeLog
## A Personal Activity Logging and Reflection Application

The **LifeLog** application is a Java desktop application that allows users to record and organize anything they do in their daily lives, such as studying, exercising, spending money, volunteering, or tracking mood and energy levels. Each log entry includes a date, category, description, and an optional numeric value. The application provides summaries over time, helping users review patterns such as how they spend their time, which activities are most frequent, and daily or weekly averages. The project will be developed in stages, starting as a console-based program and later expanding into a graphical user interface while maintaining a clear separation between the data model and the user interface.

This application is intended for **general users** who want a simple and flexible way to reflect on their daily activities without being limited to a single type of tracker. I am interested in this project because it combines structured data with everyday human behavior, and it allows me to practice core Java concepts such as object-oriented design, collections, file input/output, and program state persistence. I also like that the project can grow in complexity over time while remaining approachable and useful.

### Planned Features
- Log daily activities with categories and optional numeric values  
- View summaries such as totals, averages, and most frequent activities  
- Save and reload all logged data to continue using the application later  
- Transition from a **console-based interface** to a **graphical user interface**

## User Stories

- **As a user, I want to be able to add a new log entry to my LifeLog**, specifying the date, category, short description, and an optional numeric value, so that I can record anything I do during the day.

- **As a user, I want to be able to remove a log entry from my LifeLog**, so that I can correct mistakes or delete entries I no longer want to keep.  

- **As a user, I want to be able to view a list of all log entries in my LifeLog**, so that I can review what I have recorded over time.  

- **As a user, I want to be able to view log entries filtered by category or by date**, so that I can focus on specific types of activities or a particular day.

- **As a user, I want to be able to view the total number of hours of all log entries in my LifeLog**, so that I can track how much time I've spent across all activities.

- **As a user, I want to be able to see summary statistics about my log entries**, such as totals and averages by category, so that I can better understand my daily habits and patterns.

- **As a user, I want to have the option to save my entire LifeLog to a file**, so that I can resume tracking my activities later.

- **As a user, I want to have the option to load my previously saved LifeLog**, so that I can continue where I left off.

## Instructions for End User

- You can view the panel that displays the Xs that have already been added to the Y by:
  - Opening the app; the center panel (a scrollable list) will display all entries currently in your LifeLog. 
  - Each entry shows the title, category, description, hours, and date.

- You can generate the first required action related to the user story "adding multiple Xs to a Y" by:
  - Clicking the “Add Entry” button at the bottom of the window. 
  - A dialog will prompt you to enter the Title, Category, Description, Hours, and Date. 
  - Once submitted, the new entry will appear in the list.

- You can generate the second required action related to the user story "adding multiple Xs to a Y" by:
  - Clicking either the “Filter by Category” or “Filter by Date” buttons.
  - Enter a category or a date (YYYY-MM-DD) to display a subset of entries that match the specified criterion.

- You can locate my visual component by:
  - Viewing the banner image at the top of the application window. 
  - The banner (LifeLogBanner.png) visually represents time tracking productivity, and logging activities.

- You can save the state of my application by:
  - Clicking the “Save” button at the bottom of the window. 
  - This writes the current LifeLog to ./data/lifelog.json.

- You can reload the state of my application by:
  - Clicking the “Load” button at the bottom of the window. 
  - This reads the LifeLog from ./data/lifelog.json and updates the display panel.