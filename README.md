# COMP55-resurrection

### Issue chosen:
> Add a top 10 scoreboard that doesn't reset everytime the program closes

### Pseudocode for Scoreboard class:
Comapare scores method
> If new score is greater than or equal to current score from list   
>> Get name from user   
>> Add new score with name to spot before current score   
>> Remove last score from list
> <p>Repeat comparison until new score is greater than current score or end of score list is reached</p>

Ask for User name method
> Ask user for 3 letter name   
> If name is more than 3 letters   
>> Repeat section above
> <p>Save name</p>

Default method
> Set all 10 spots to have <"---", 000000>

Save data method
> Clear file   
> Open file   
> Write top 10 scores and the names in the file
> Close file

Load data method
> Open file  
> Go through each line with data and save them   
> Close file

Clear file method
> Open file   
> Write "" to clear file of previous data   
> Close file

******

### Steps I took:
1. Created Scoreboard class and added code in the methods I had in my pseudocode.
2. Added variables, code, and methods needed to create a screen in game.
4. Added button to main menu for scoreboard
5. Moved labels around on screen that have instructions, "Highscores", and each score.
6. Added another method to register keys pressed from user when getiing a name and a label to show what user has typed.
7. Added method called changeColor() that changes the score label color to highlight the new score added.
8. Added method to update score labels that reflect top10scores arrayList.
9. Worked on saveScores() to save top10scores into a text file.
10. Added saveScores() call to main menu exit button.
11. Worked on loadScores() to load the scores from a text file.
12. Added loadScores() call to initializeScoreboard() that is called when program first opens.
13. Looked through code to remove dupicate code and add comments when needed.
> Added another method called changeLabelcolors() that call changeColor() on a score label depending on newScoreSpot. 
