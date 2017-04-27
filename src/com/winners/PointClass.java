package com.winners;

/**
 * Created by ${theATeam} on 4/27/2017.
 */
public class PointClass {
    private boolean mDone;//whether or not a point has been assigned a value
    private char mPressedOrNot;//value assigned

    public PointClass(){
        mDone = false;
    }
    public void printPoint(){
        System.out.print(mPressedOrNot);
    }
    public void assign(boolean pressed){
        if(pressed)
            mPressedOrNot = 'x';
        else
            mPressedOrNot = 'o';
        mDone = true;
    }
}
