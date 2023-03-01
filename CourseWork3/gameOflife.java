package CourseWork3;

import java.util.HashMap;

public class gameOflife{
    public static int[][] state = {
            {0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}};
    public static int n = 103;

    public static HashMap<String, Integer> count = new HashMap<String, Integer>();

    // Return the alive cell’s count around the state[x][y].
    public static int returnAlive(int x, int y) {
        // Initial the total number of alive cells.
        int aliveSum = 0;
        // Iterate through all surrounding cells.
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                // Skip, if it is the original cell.
                if (i == x && j == y) {
                    continue;
                }
                // Check if the cells are alive.
                if (state[x][y] == 1) {
                    aliveSum++;
                }
            }
        }
        return aliveSum;
    }

    // The state variable changes to the next state’s value.
    public static void goNextState() {
        // Initialization.
        int[][] tempState = new int[5][5];
        // Iterate through all surrounding cells.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int aliveNum = returnAlive(i, j);
                // Determine the situation of the alive cells in the next state.
                if (state[i][j] == 1) {
                    // The situation that the cell becomes dormant.
                    if (aliveNum < 2 || aliveNum > 3)
                        tempState[i][j] = 0;
                        // Otherwise, the cells remain alive.
                    else
                        tempState[i][j] = 1;
                } else {// Determine the situation of the dormant cells in the next state.
                    // The situation that the cell becomes alive.
                    if (aliveNum == 3)
                        tempState[i][j] = 1;
                        // Otherwise, the cells remain dormant.
                    else
                        tempState[i][j] = 0;
                }
            }
        }
        state = tempState;
    }
    // The function to print the ans matrix.
    public static void printState(String stateStr) {
        // Iterate through the string and print each character.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                // Print the element at the current position.
                System.out.print(state[i][j]);

                // If the current index is a multiple of 5, add a newline character
                if (j % 5 == 4) {
                    System.out.println();
                }
            }
        }
    }

    // This function returns a 25-length String that represents the state matrix.
    public static String getStateStr() {
        // Initialization.
        String stateStr = "";
        // Iterate through all surrounding cells.
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                stateStr += state[i][j];
            }
        }
        return stateStr;
    }

    // Check if a 25-length String represents a valid state.
    public static boolean checkStateStr(String str) {
        // Check if the string has a length of 25.
        if (str.length() != 25) {
            return false;
        }
        // Check if all characters in the string are either '0' or '1'.
        for (char c : str.toCharArray()) {
            if (c != '0' && c != '1') {
                return false;
            }
        }
        // If the string passes the previous checks, it is a valid state string.
        return true;
    }
    public static void main(String[] args) {
        // Initialize the count HashMap.
        count = new HashMap<>();
        // Iterate through the first n states.
        String stateStr = null;
        for (int i = 0; i < n; i++) {
            // Get the current state as a string.
            stateStr = getStateStr();
            // Check if the current state is already in the count HashMap.
            if (count.containsKey(stateStr)) {
                // If it is, increment the count for this state.
                count.put(stateStr, count.get(stateStr) + 1);
            } else {
                // If it isn't, add it to the count HashMap with a count of 1.
                count.put(stateStr, 1);
            }
            // Move to the next state.
            goNextState();
            checkStateStr(stateStr);
        }
        // Print the results.
        int a = count.get(stateStr);
        System.out.println(a);
        printState(getStateStr());
    }
}
