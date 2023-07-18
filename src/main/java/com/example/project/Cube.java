package com.example.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Cube {

    static String[][] cube = {
        {
            "r", "r", "r",
            "r", "r", "r",
            "r", "r", "r"
        },
        {
            "b", "b", "b",
            "b", "b", "b",
            "b", "b", "b"
        },
        {
            "o", "o", "o",
            "o", "o", "o",
            "o", "o", "o"
        },
        {
            "g", "g", "g",
            "g", "g", "g",
            "g", "g", "g"
        },
        {
            "y", "y", "y",
            "y", "y", "y",
            "y", "y", "y"
        },
        {
            "w", "w", "w",
            "w", "w", "w",
            "w", "w", "w"
        },
    };

    class edgedFace{
        public int current_face;
        // Array with:
        // Element 0: Index of face of the edge
        // Elements 1-3: Positions on that edge, left to right
        int[] edge1 = new int[4];
        int[] edge2 = new int[4];
        int[] edge3 = new int[4];
        int[] edge4 = new int[4];

        public edgedFace(int face){
            current_face = face;

            switch(face){
                // For the red face
                case 0:
                    // Blue is on left
                    edge1[0] = 1;
                    // Blue square that is: Top right
                    edge1[1] = 2;
                    // Middle right
                    edge1[2] = 5;
                    // Lower right
                    edge1[3] = 8;

                    // Yellow is top
                    edge2[0] = 4;
                    // Bottom Row
                    edge2[1] = 8;
                    edge2[2] = 7;
                    edge2[3] = 6;

                    // Green is right
                    edge3[0] = 3;
                    // Left column
                    edge3[1] = 6;
                    edge3[2] = 3;
                    edge3[3] = 0;

                    // White is bottom
                    edge4[0] = 5;
                    // Top Row
                    edge4[1] = 0;
                    edge4[2] = 1;
                    edge4[3] = 2;
                break;

                // Blue face
                case 1:
                    // Orange is on left
                    edge1[0] = 2;
                    // Orange square that is: Top right
                    edge1[1] = 2;
                    // Middle right
                    edge1[2] = 5;
                    // Lower right
                    edge1[3] = 8;

                    // Yellow is top
                    edge2[0] = 4;
                    edge2[1] = 6;
                    edge2[2] = 3;
                    edge2[3] = 0;

                    // Red is right
                    edge3[0] = 0;
                    edge3[1] = 6;
                    edge3[2] = 3;
                    edge3[3] = 0;

                    // White is bottom
                    edge4[0] = 5;
                    edge4[1] = 6;
                    edge4[2] = 3;
                    edge4[3] = 0;
                break;

                // Orange face
                case 2:
                    // Green is on left
                    edge1[0] = 3;
                    // Green square that is: Top right
                    edge1[1] = 2;
                    // Middle right
                    edge1[2] = 5;
                    // Lower right
                    edge1[3] = 8;

                    // Yellow is top
                    edge2[0] = 4;
                    edge2[1] = 0;
                    edge2[2] = 1;
                    edge2[3] = 2;

                    // Blue is right
                    edge3[0] = 1;
                    edge3[1] = 6;
                    edge3[2] = 3;
                    edge3[3] = 0;

                    // White is bottom
                    edge4[0] = 5;
                    edge4[1] = 8;
                    edge4[2] = 7;
                    edge4[3] = 6;
                break;

                // Green face
                case 3:
                    // Red is on left
                    edge1[0] = 0;
                    // Red square that is: Top right
                    edge1[1] = 8;
                    // Middle right
                    edge1[2] = 5;
                    // Lower right
                    edge1[3] = 2;

                    // Yellow is top
                    edge2[0] = 4;
                    edge2[1] = 8;
                    edge2[2] = 5;
                    edge2[3] = 2;

                    // Orange is right
                    edge3[0] = 2;
                    edge3[1] = 0;
                    edge3[2] = 3;
                    edge3[3] = 6;

                    // White is bottom
                    edge4[0] = 5;
                    edge4[1] = 8;
                    edge4[2] = 5;
                    edge4[3] = 2;
                break;

                // Yellow face
                case 4:
                    // Blue is on left
                    edge1[0] = 1;
                    // Blue square that is: Top right
                    edge1[1] = 0;
                    // Middle rght
                    edge1[2] = 1;
                    // Lower right
                    edge1[3] = 2;

                    // Orange is top
                    edge2[0] = 2;
                    edge2[1] = 0;
                    edge2[2] = 1;
                    edge2[3] = 2;

                    // Green is right
                    edge3[0] = 3;
                    edge3[1] = 0;
                    edge3[2] = 1;
                    edge3[3] = 2;

                    // Red is bottom
                    edge4[0] = 0;
                    edge4[1] = 0;
                    edge4[2] = 1;
                    edge4[3] = 2;
                break;

                // White face
                case 5:
                    // Blue is on left
                    edge1[0] = 1;
                    // Blue square that is: Top right
                    edge1[1] = 6;
                    // Middle right
                    edge1[2] = 7;
                    // Lower right
                    edge1[3] = 8;

                    // Red is top
                    edge2[0] = 0;
                    edge2[1] = 6;
                    edge2[2] = 7;
                    edge2[3] = 8;

                    // Green is right
                    edge3[0] = 3;
                    edge3[1] = 6;
                    edge3[2] = 7;
                    edge3[3] = 8;

                    // Orange is bottom
                    edge4[0] = 2;
                    edge4[1] = 6;
                    edge4[2] = 7;
                    edge4[3] = 8;
                break;

            }
        }
    }

    public void turnFace(int index, String direction){
        edgedFace eFace = new edgedFace(index);

        String[][] copy = new String[6][9];

        for(int i=0; i<6; i++){
            for(int j=0; j<9; j++){
                copy[i][j] = cube[i][j];
            }
        }

        switch(direction){
            case "c":
                // For cube, on the current_face, square 6 becomes square 0
                cube[eFace.current_face][0] = copy[eFace.current_face][6];
                // Square 3 becomes square 1
                cube[eFace.current_face][1] = copy[eFace.current_face][3];
                cube[eFace.current_face][2] = copy[eFace.current_face][0];
                cube[eFace.current_face][3] = copy[eFace.current_face][7];
                // Skipping 4 because the middle tile never moves
                cube[eFace.current_face][5] = copy[eFace.current_face][1];
                cube[eFace.current_face][6] = copy[eFace.current_face][8];
                cube[eFace.current_face][7] = copy[eFace.current_face][5];
                cube[eFace.current_face][8] = copy[eFace.current_face][2];

                // On the cube, for the left-hand side (edge1), for the three
                // squares of that side: Set them each equal to the three
                // squares from the bottom side
                cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
                cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
                cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

                // left becomes top
                cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
                cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
                cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];

                // top becoms right
                cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
                cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
                cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

                // right becomes bottom
                cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
                cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
                cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];
            break;

            case "cc":
                // For cube, on the current_face, square 2 becomes square 0
                cube[eFace.current_face][0] = copy[eFace.current_face][2];
                // Square 5 becomes square 1
                cube[eFace.current_face][1] = copy[eFace.current_face][5];
                cube[eFace.current_face][2] = copy[eFace.current_face][8];
                cube[eFace.current_face][3] = copy[eFace.current_face][1];
                // Skipping 4 because the middle tile never moves
                cube[eFace.current_face][5] = copy[eFace.current_face][7];
                cube[eFace.current_face][6] = copy[eFace.current_face][0];
                cube[eFace.current_face][7] = copy[eFace.current_face][3];
                cube[eFace.current_face][8] = copy[eFace.current_face][6];

                // On the cube, for the left-hand side (edge1), for the three
                // squares of that side: Set them each equal to the three
                // squares from the top side
                cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
                cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
                cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

                // right becomes top
                cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
                cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
                cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];

                // bottom becoms right
                cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
                cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
                cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

                // left  becomes bottom
                cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
                cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
                cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];
            break;
        }
    }

    public void showCube(){
        int ind = 0;
        for(int x=0; x<6; x++){
            for(int y=0; y<3; y++){
                for(int z=0; z<3; z++){
                    System.out.print(cube[x][ind++]);
                }
                System.out.println();
            }
            ind = 0;
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

        Cube RubiksCube = new Cube();

        boolean argsCheck = false;
        int argsRunIndex = 0;
        boolean proceed = false;
        // ArrayList to check acceptable command line arguement input
        ArrayList<String>
            acceptableArgs = new ArrayList<String>(
                Arrays.asList("u", "u'", "d", "d'", "r", "r'",
                "l", "l'", "f", "f'", "b", "b'")
            );

        if(args.length > 0){
            argsCheck = true;
            proceed = true;
        }
        else{
            // Tell them they need to give input if they don't
            System.out.println("\n\tYou must provide an argument!");
        }

        // ArrayList for keeping track of solution moves, which amounts
        //  to the inverse input moves in reverse order
        ArrayList<String>
            solution = new ArrayList<String>();

        while(proceed){
            String input;

            if(!argsCheck){
                input = reader.readLine().toLowerCase();
            }
            else{
                if(argsRunIndex == args.length){
                    argsCheck = false;
                    input = "s";
                }
                else{
                    input = args[argsRunIndex].toLowerCase();
                    argsRunIndex++;
                    // If the arguement was an acceptable one
                    if (acceptableArgs.contains(input)){
                        // Check to see if it is a regular or inverse move
                        if (input.length() == 1){
                            // If regular, add the inverse as the first element
                            //  of the solution AL
                            solution.add(0, input + "'");
                        }
                        else {
                            // If inverse, add the regular move
                            solution.add(0,
                                input.replace("'", ""));
                        };
                    }
                    // If the argument was unacceptable, just skip it, but tell
                    //  the user what you're skipping...
                    else{
                        System.out.println("Skipping unacceptable arguement "
                            + "\"" + input + "\"\n");
                        // ... and then continue on with the next iteration
                        continue;
                    }
                }
            }

            switch(input){
                case "u":
                    RubiksCube.turnFace(4, "c");
                    RubiksCube.showCube();
                break;

                case "d":
                    RubiksCube.turnFace(5, "c");
                    RubiksCube.showCube();
                break;

                case "r":
                    RubiksCube.turnFace(0, "c");
                    RubiksCube.showCube();
                break;

                case "l":
                    RubiksCube.turnFace(2, "c");
                    RubiksCube.showCube();
                break;

                case "f":
                    RubiksCube.turnFace(1, "c");
                    RubiksCube.showCube();
                break;

                case "b":
                    RubiksCube.turnFace(3, "c");
                    RubiksCube.showCube();
                break;

                case "u'":
                    RubiksCube.turnFace(4, "cc");
                    RubiksCube.showCube();
                break;

                case "d'":
                    RubiksCube.turnFace(5, "cc");
                    RubiksCube.showCube();
                break;

                case "r'":
                    RubiksCube.turnFace(0, "cc");
                    RubiksCube.showCube();
                break;

                case "l'":
                    RubiksCube.turnFace(2, "cc");
                    RubiksCube.showCube();
                break;

                case "f'":
                    RubiksCube.turnFace(1, "cc");
                    RubiksCube.showCube();
                break;

                case "b'":
                    RubiksCube.turnFace(3, "cc");
                    RubiksCube.showCube();
                break;

                case "s":
                    System.out.println("To solve the cube, perform the "
                        + "following actions:\n---> " + solution);
                break;

                case "q":
                    proceed = false;
                break;
            }
        }

    }

}