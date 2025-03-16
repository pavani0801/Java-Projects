@ -0,0 +1,127 @@
Connect4 Description.

Connect 4 is a fun game in which the players are allowed to choose a column and then take turns dropping colored discs into a six row, seven column grid.As the name indicates , the first player to connect 4 disc either horizontally , vertically or diagonally will win tha game.
Developing this game in Java Programming language helps us to make use of class , methods or functions , passing paramaters to functions , declaring variables and trying to understand the scope of variables i.e variables declared inside the class , inside main method etc.. .It can constructed with the help of a mutli dimensional array.(2-D array)
The purpose of this program is to provide a playable version of Connect Four that can be run in a Java environment. It allows users to play against each other on a command-line interface.


In this project , I used loops , conditional statements i.e if , else statements in order to build the game.
Let's break down the java program into different steps.

First method():-
intro();
As the name suggest it gives the introduction about the game. The players can see the message "welcome to the connect4" followed by the instructions which states that 2 players will be playing the game and every player will the get their consecutive turns to drop their discs in the desired column.

Second method():-
intializeGrid();

As the name indicates , this method will intialize all the cells in the grid to zero. For this we declare a 2-Dimensional array , and we use variable "i" for rows and variable "j" for columns.Since , "i" indicates the total numbers rows so it will be and "j" indicates the total number of columns so it will be 7. As the array psoition starts from zero , the rows and columns intially will be declared to zero with the help of "for" loop.

Third method():-
readMove();

As the name indicates , this method will the read the values entered by the user . Here the users are players i.e Player 1 and Player 2. By using the scanner class we read the input from the player i.e asking the player to choose a column from 1-7 in order to drop their disc in the column. An integer variable column is assigned to store the Player's choice and that value is subtracted by 1 and stored in the same integer variable column . This step is done , as the array index position starts from zero and storing the values inside the array are also 0th position i.e grid[0][0],grid[1][1]........
After this , the value inside the column will be returned by using the data type 'int' in the function.

Fourth method():-
performMove();

As the name suggests that it used to perform the set of instructions passed to the code. Here the disc are intially dropeed at the bottom of the grid . So for this we use for loop , which staes i=5,
and the Players selected column . For example if the Players selects column '1'and since it gets subtracted it becomes o . Now grid[i][column]=grid[5][0]. In this position the first disc will be placed. Similalry the same thing with the Player 2 . Here the discs are dropped in bottom-up approach. 

Fifth method():-
CheckEndgame();

This is the backbone of the connect4 program . This method will identify the winner . It checks whether there are 4 sequential rows , columns or diagonal with same disc . If yes , it will declare the winner based on the conditions.
Let's break the code into step by step.
Here we declare a boolean method which return true or false.

1.checking rows.
using of "for" loop to check the rows.
for (int i = 0; i < grid.length - 3; i++)
here "i" is for rows , intial value =0, i value should be less than grid.length subtracted with 3 . This loop goes until grid.length-3 to ensure that there are atleast four consecutives rows to check.We need to check for runs of fours , and if there are fewer than four rows , there is no option of a getting a player win in the row segment .In that case , we move on to checking the column or diagonals.

Now for (int j = 0; j < grid[i].length; j++) this nested for loop will iterate over the columns of the each row.As long as the condition j<grid[i].length is true this for will keep getting executed and once it becomes false i.e j>=grid[i].length , it will come out of the nested for loop and control comes to the outer for loop incrementing the value of "i". This process takes place utill the conditions i<grid.length-3 is true. Then comes out of the loop.
if (grid[i][j] != 0 && grid[i][j] == grid[i + 1][j] && grid[i][j] == grid[i + 2][j] && grid[i][j] == grid[i + 3][j]) the if condition is used to check whether there are 4 consecutive same discs , to declare a winner. this if statement checks whether there are four consecutive non-zero elements in the same row,Here it checks [i][j] are non zero elements and the value of it is same as the value of the next 3 consecutive rows . If yes , then it means that a player has won by placing their dics , vertically ina column. So in such a winning case , it will return "true" indicating that the game has ended with a winner .


2.Checking columns.
Using of "for " loop to check the columns.
for (int j = 0; j < grid[i].length - 3; j++)
here "j" is for columns, intial value=0 , j value should be less than grid.length , subtracted with 3. This loop goes until grid.length-3 to ensure that are atleast four consecutive colums to check . we need to check for runs of fours , and if there are fewer than four columns , then there is no option of a getting a player win in the column segment.

Now for (int i = 0; i < grid.length; i++) This outer loop iterates over the rows of the grid.
if (grid[i][j] != 0 && grid[i][j] == grid[i][j + 1] && grid[i][j] == grid[i][j + 2] && grid[i][j] == grid[i][j + 3]) .this if statement checks whether there are four consecutive non-zero elements in the same row,Here it checks [i][j] are non zero elements and the value of it is same as the value of the next 3 consecutive columns . If yes , then it means that a player has won by placing their dics horizontal in a row. So in such a winning case , it will return "true" indicating that the game has ended with a winner .

3.Checking Diagonals.
using for loop to check the diagonals.

Upward Diagonal Check:

This code will check for the upward diagonal sequences. if (grid[i][j] != 0 && grid[i][j] == grid[i + 1][j + 1] && grid[i][j] == grid[i + 2][j + 2] && grid[i][j] == grid[i + 3][j + 3])It iterates through the grid , leaving the last three rows and columns so that it can check for diagonal order. It checks (i,j) along with the other cells by comparing the value at (i ,j) with the values of the next three positions diagonally up and to the right.
IF it finds four  non zero cells with same value in a diagonal order (up to the right) , it will return true indicating that a player has won by dropping their discs in the diagonal way.

Downward Diagonal Check:

This code will check for the downward diagonal sequences. if (grid[i][j] != 0 && grid[i][j] == grid[i + 1][j - 1] && grid[i][j] == grid[i + 2][j - 2] && grid[i][j] == grid[i + 3][j - 3]) {
It ietrates through the grid , leaving the last three rows and starting from the fourth  columns so that it can check for diagonal order. It checks (i,j) along with the other cells by comparing the value at (i ,j) with the values of the next three positions diagonally down and to the left. If all values are non zero and are equal , it returns true indicating a
If it finds four non zero cells holding the same value in a diagonal order ( down to the left) , it will return true indicating that a player has won by drpping discs in the diagonal way.

checking if the grid is full.
This loop ietrates over each position which has 6 rows and 7 columns m for each (i,j) it checks if the value is equal to zero. If yes , indicating that there is an empty slot and also indicates that the grid is not completely filled and it will return false in that case. Otherwise it will return true which implies that the grid is full and there are no empty slots.
It also checks for draw , both the players have played their respective games but neither of them won, indicating a draw.

