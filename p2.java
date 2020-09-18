package project02;

import java.io.*;
import java.util.Scanner;
//Constance Xu
//I pledge my honor that I have abided by the Stevens Honor System.
public class p2 {
	/***
	 * 
	 * This is all the possible tags. 
	 *
	 */
	public enum Tag {
	    INDI, NAME, SEX, BIRT, DEAT, FAMC, FAMS, FAM, MAR, HUSB, WIFE, CHIL, DIV, DATE, HEAD, TRLR, NOTE
	}
	/**
	 * This class will create each string. 
	 * @param line
	 * @return string in correct format
	 */
    public static String parseLine(String line) {
    	String[] params = line.split(" ");
        String level = params[0];
        String tag = params[1];

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < params.length; i++) {
            sb.append(params[i]);
            sb.append(" ");
        }
        
        boolean x;
        try {
            Tag.valueOf(tag);
            x = true;
        } catch (IllegalArgumentException e) {
            x = false;
        } 
        
        String y;
        if (x) {
        	y = "Y";
        } else {
        	y = "N";
        }

        return String.format("%s|%s|%s|%s", level, tag, y, sb.toString());
    }

    /**
     * Creates the output here.
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        File text = new File(args[0]);
        Scanner s = new Scanner(text);
        String line;

        while (s.hasNextLine()) {
            line = s.nextLine();
            System.out.printf("--> %s\n", line);

            line = parseLine(line);
            System.out.printf("<-- %s\n", line);
        }

        s.close();
    }

}