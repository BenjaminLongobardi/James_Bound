package com.winners;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        GridClass grid = new GridClass();
        grid.getData();
        grid.runFills();
        grid.printGrid();
    }
}
