package com.winners;
import java.io.*;
import java.util.StringTokenizer;
/**
 * Created by benco on 4/27/2017.
 */
public class GridClass {
    private int mRows = 1;// # of rows, starts at 1 for counting purposes
    private int mCols = 1;// # of cols, starts at 1 for counting purposes
    //private int [] mFreeRows;// # of unassigned points in each row
    //private int [] mFreeCols;// # of unassigned points in each col
    private int mCurrentMaxRows;//stores the decrementing maximum number of available rows
    private int mCurrentMaxCols;//stores the decrementing maximum number of available columns
    private int [] mGivenRows;// # of pressed buttons in each row(given)
    private int [] mGivenCols;// # of pressed buttons in each col(given)
    private PointClass [][] mGrid;// the M16 keypad

    public GridClass(){

    }
    public void getData() throws IOException{
        BufferedReader input = new BufferedReader(new FileReader("data.txt"));
        //begin finding number of rows and columns
        String temp;
        temp = input.readLine();
        StringTokenizer tokens = new StringTokenizer(temp);
        while(tokens.hasMoreTokens()){
            String x = tokens.nextToken();
            mRows++;
        }
        temp = input.readLine();
        tokens = new StringTokenizer(temp);
        while(tokens.hasMoreTokens()){
            String x = tokens.nextToken();
            mCols++;
        }
        mCurrentMaxCols = mCols;
        mCurrentMaxRows = mRows;
        //end finding number of rows and columns
        mGrid = new PointClass[mRows][mCols];
        /*
        //initialize free rows and columns
        mFreeRows = new int [mRows];
        for( int i=0; i<mRows; i++)
            mFreeRows[i]= mCols;
        mFreeCols = new int [mCols];
        for( int i=0; i<mCols; i++)
            mFreeCols[i]= mRows;
        //end initializing free rows and columns
        */

        //inputting given data into row and column specific arrays
        mGivenRows = new int [mRows];
        mGivenCols = new int [mCols];
        BufferedReader input2 = new BufferedReader(new FileReader("data.txt"));
        temp = input2.readLine();
        StringTokenizer tokens2 =  new StringTokenizer(temp);
        for(int i = 0; i< mRows; i++){
            String y = tokens2.nextToken();
            mGivenRows[i] = Integer.parseInt(y);
        }
        temp = input2.readLine();
        tokens2 =  new StringTokenizer(temp);
        for(int i = 0; i< mCols; i++){
            String y =tokens2.nextToken();
            mGivenCols[i] = Integer.parseInt(y);
        }
        //end inputting given data into row and column arrays

    }//end getData()

    public void printGrid(){
        for(int i=0; i<mRows; i++){
            for(int j=0; j<mCols; j++){
                mGrid[i][j].printPoint();
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }//end printGrid

    public void fillRow(int rowNum, boolean pressed) {//pressed = true means x
        for (int i = 0; i < mCols; i++) {             //pressed = false means o
            if(!mGrid[rowNum][i].isDone())            //Will not touch points already assigned
                mGrid[rowNum][i].assign(pressed);

        }
    }
    public void fillCol(int colNum, boolean pressed){
        for(int i=0; i<mRows; i++){
            if(!mGrid[i][colNum].isDone())
                mGrid[i][colNum].assign(pressed);

        }
    }
    //finds all rows and columns with no button presses and assigns as such
    public void findAndFillZeros(){
        for(int i=0; i<mRows; i++){
            if(mGivenRows[i]==0){
                fillRow(i,false);
                mCurrentMaxRows--;
            }
        }
        for(int i=0; i<mCols; i++){
            if(mGivenCols[i]==0){
                fillCol(i,false);
                mCurrentMaxCols--;
            }
        }
    }
    //finds all rows and columnds with the current decremention max and assigns as pressed
    public void findAndFillMaximums(){
        for(int i=0; i<mRows; i++){
            if(mGivenRows[i]==mCurrentMaxCols&&mCurrentMaxCols!=0){
                fillRow(i,true);
                mCurrentMaxRows--;
            }
        }
        for(int i=0; i<mCols; i++){
            if(mGivenCols[i]==mCurrentMaxRows&&mCurrentMaxRows!=0){
                fillCol(i,true);
                mCurrentMaxCols--;
            }
        }
    }
    //runs fillrows and fillcol methods until complete graph is made
    public void runFills(){
        findAndFillZeros();
        while(mCurrentMaxCols!=0&&mCurrentMaxRows!=0)
            findAndFillMaximums();

    }

}
