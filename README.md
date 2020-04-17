# Bomb_Manual
 This is the Bomb Manual for Keep Talking and Nobody Explodes Vanilla (No Mods)
 The program is a variant of the original Bomb Manual (http://www.bombmanual.com/) that provides a quick way to solve each module. This project uses JDK 14 and language level 14 - Switch expressions

### Traits Tab
Tab displays options to toggle the important indicators "FRK" and "CAR", whether there's a parallel port on the bomb, a place to input the number of batteries, and whether the Serial Number contains a vowel and last digit odd number. The batteries TextField does not accept non-number values.

### Button Tab
There's a section for the label of the button and one for the color. Press one in each to view the results.

### Keypad Tab
Clicking a keypad will highlight that keypad in a cyan background for easy location. Click 4 of them to get the correct order.

### Simple Wires Tab
The tab contains a slider with the current number of wires and "piano keys" of each color of wire. Set the number of wires and click the order to get the correct wire to cut. There's also a quick clear area for when the user is done with the module.

### Simon Says Tab
Tab contains a slider for the number of strikes earned during the current defuse and a panel for each color. The output displays the order of colors to press in response to the flashing sequence. Changing the number of strikes will have the sequence change to the correct order as well.

### Who's On First Tab
Step 1 will find the correct panel based on what is typed. Step 2 will find the sequence of words that correspond to the typed word. Go through the words to find the one that the defuser has. Also a quick clear area for easy use

### Memory Tab
**[Unfinished]**

### Morse Code Tab
Only reads dots and dashes in the input field (- and .) and outputs possible words in the TextArea.
**[Module does not display correct results, needs further coding and testing]**

### Complicated Wires Tab
Input a letter sequence for each wire, and the output will display what that wire is and whether to cut it or not. Be sure to check the sides of the bomb for parallel port, batteries and the serial number.
- r - Wire has red coloring
- b - Wire has blue coloring
- s - Wire has a star underneath
- l - Wire has a lit LED
- w - Only if the wire is completely bare (But we all know that you cut that wire)

### Wires Sequences Tab
Goes through the occurrences of red, blue and black wires to determine which to cut. No more remembering or covering the manual with your fingers.

### Mazes Tab
**(From my personal experience being the expert)** There are three notations possible for people who use coordinate systems with (1,1) being the *top left* or *bottom left* corner or for those who say rows as A,B,C,D,E or F and columns as numbers. Select the correct notation and input the coordinates for a circle on the right to find the correct maze, either circle works and just numbers, nothing else. There are places to put the coordinates to the dot and the target.

### Password Tab
Contains 5 input fields to take in the sets of letters in each row. Input the set of letters into the corresponding input, and the Output area displays the possible passwords.

### Knobs Tab
Displays the orientations for each knob from the original manual, nothing fancy.
