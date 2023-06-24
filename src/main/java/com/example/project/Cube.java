package com.example.project;

public class Cube {

    // Needs to be static so it can be called in other methods/functions
    // We'll make it directly initialized (specifying the values)
    static String[][] Face = {
        {"0" ,"1" ,"2"}
        ,{"3" ,"4" ,"5"}
        ,{"6" ,"7" ,"8"}
    };

    static String[][][] cube = {
        {
            {"0r" ,"1r" ,"2r"}
            ,{"3r" ,"4r" ,"5r"}
            ,{"6r" ,"7r" ,"8r"}
        }
        ,{
            {"0b" ,"1b" ,"2b"}
            ,{"3b" ,"4b" ,"5b"}
            ,{"6b" ,"7b" ,"8b"}
        }
        ,{
            {"0y" ,"1y" ,"2y"}
            ,{"3y" ,"4y" ,"5y"}
            ,{"6y" ,"7y" ,"8y"}
        }
        ,{
            {"0g" ,"1g" ,"2g"}
            ,{"3g" ,"4g" ,"5g"}
            ,{"6g" ,"7g" ,"8g"}
        }
        ,{
            {"0w" ,"1w" ,"2w"}
            ,{"3w" ,"4w" ,"5w"}
            ,{"6w" ,"7w" ,"8w"}
        }
        ,{
            {"0o" ,"1o" ,"2o"}
            ,{"3o" ,"4o" ,"5o"}
            ,{"6o" ,"7o" ,"8o"}
        }
    };

    static void showFace(String[][] face){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.print(face[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    static void rotateFace(String[][] face, boolean clockwise){

        /* Need a temporary Face var so that referencing a square you've
            already updated doesn't create a cascading issue */
        String[][] tempFace = new String[3][3];

        // Copy over the inital face into tempFace
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                tempFace[i][j] = face[i][j];
            }
        }

        if(!clockwise){
            // Flip every (i, j) pair to (j, i)
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    face[i][j] = tempFace[j][i];
                }
            }
            /*  Now the middle row, face[1], is now correct, but the top and
                bottom rows need to switch */

            // Intent here will be to swap rows
            String[] tempRow = new String[3];

            // Store each of the elements of the top row in a tempRow
            for(int k=0; k<3; k++){
                tempRow[k] = face[0][k];
            }

            // Set the top row equal to the last and the last equal to the top
            face[0] = face[2];
            face[2] = tempRow;
        }
        else{
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    face[i][j] = tempFace[j][i];
                }
                // For each row, store the element in the first column...
                String tempElement = face[i][0];

                // ...and swap the first and last columns
                face[i][0] = face[i][2];
                face[i][2] = tempElement;
            }
        }

    }

    public static void main(String[] args){

        String[][] tempFace = new String[3][3];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                tempFace[i][j] = cube[0][i][j];
            }
        }

        showFace(tempFace);

        rotateFace(tempFace, true);

        showFace(tempFace);
    }
}