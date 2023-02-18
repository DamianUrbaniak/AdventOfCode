package org.damianurbaniak.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadInput {

    public static Scanner inputToFurtherManipulations(String filename) throws FileNotFoundException {
        File input = new File(filename);

        return new Scanner(input);
    }
}
