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
