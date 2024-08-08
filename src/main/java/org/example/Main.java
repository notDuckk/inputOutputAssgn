package org.example;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)   {
        String inputFile1 = "src/inputFile1.txt";
        String inputFile2 = "src/inputFile2.txt";
        String mergedFile = "src/merged.txt";
        String commonFile = "src/common.txt";

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        try(BufferedReader br1 = new BufferedReader(new FileReader(inputFile1));
        BufferedReader br2 = new BufferedReader(new FileReader(inputFile2))) {

            String line;
            while ((line = br1.readLine()) != null) {
                try {
                    list1.add(Integer.parseInt(line));
                }catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            String line2;
            while ((line2 = br2.readLine()) != null) {
                try {
                    list2.add(Integer.parseInt(line2));
                }catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            try (FileWriter fw1 = new FileWriter(mergedFile, true)) {
                for (Integer i : list1) {
                    fw1.write(i + "\n");
                }
                for (Integer i : list2) {
                    fw1.write(i + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            try (FileWriter fw2 = new FileWriter(commonFile, true)) {
                for (Integer i : list1) {
                    if(list2.contains(i)) {
                        fw2.write(i + "\n");
                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
            }

        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}