//100 door puzzle
/*
There are 100 doors in a row that are all initially closed. You make 100 passes by the doors starting
        with the first door every time. The first time through you visit every door and toggle the door
        (if the door is closed, you open it, if its open, you close it). The second time you only visit
        every 2nd door (door #2, #4, #6). the third time, every 3rd door (door #3, #6, #9), etc, until you
        only visit the 100th door. What is the state of each door after the last pass?
*/

public class DoorOpenClose {
    public static void main(String args[]) {
        Boolean[] doors = new Boolean[100];
        //start all with zeros
        for (int i = 0; i < 100; i++) {
            doors[i] = false;
        }
        int increment = 1;
        for (int i = 0; i < 100; i++) {
            for (int j = increment - 1; j < 100; j = j + increment) {
                doors[j] = !doors[j];
            }
            increment++;
        }
        for (int i = 0; i < 100; i++) {
            if (doors[i]) {
                System.out.print(i + 1 + " ");
            }
        }
    }
}