package com.winners;
import java.io.*;
import java.util.StringTokenizer;
/**
 * Created by benco on 4/27/2017.
 */
public class GridClass {
    private int mRows = 1;// # of rows, starts at 1 for counting purposes
    private int mCols = 1;// # of cols, starts at 1 for counting purposes
    private int [] mFreeRows;// # of unassigned points in each row
    private int [] mFreeCols;// # of unassigned points in each col
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
        while(tokens !=null){
            String x = tokens.nextToken();
            mRows++;
        }
        temp = input.readLine();
        tokens = new StringTokenizer(temp);
        while(tokens !=null){
            String x = tokens.nextToken();
            mCols++;
        }
        //end finding number of rows and columns
        mGrid = new PointClass[mRows][mCols];
        //initialize free rows and columns
        mFreeRows = new int [mRows];
        for( int i=0; i<mRows; i++)
            mFreeRows[i]= mCols;
        mFreeCols = new int [mCols];
        for( int i=0; i<mCols; i++)
            mFreeCols[i]= mRows;
        //end initializing free rows and columns

        //inputting given data into row and column specific arrays
        BufferedReader input2 = new BufferedReader(new FileReader("data.txt"));
        temp = input2.readLine();
        tokens =  new StringTokenizer(temp);
        for(int i = 0; i< mRows; i++){
            mGivenRows[i] = Integer.parseInt(tokens.nextToken());
        }
        temp = input2.readLine();
        tokens =  new StringTokenizer(temp);
        for(int i = 0; i< mCols; i++){
            mGivenCols[i] = Integer.parseInt(tokens.nextToken());
        }
        //end inputting given data into row and column arrays

    }//end getData()

}
