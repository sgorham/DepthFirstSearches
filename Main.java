/*
 * Sean Gorham Project 3
 * CS 340 3/6/19
 */
package dfs;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws  java.io.IOException {
        ArrayList<Vertex> vertices = new ArrayList<>();
        DFS depthSearch = new DFS();
        String[] fileList = {"graphin-DAG.txt", "graphin-c1.txt", "graphin-c2.txt"};
        Scanner kb = new Scanner(System.in);
        int choice;
            System.out.println("Choose which file to read (enter the number): 1 for Dag, 2 for C1, and 3 for C2.");
            choice = kb.nextInt();

            makeGraph(vertices, fileList[choice-1]);
            depthSearch.search(vertices);
            depthSearch.checkCycle();
            for (int i = 0; i < vertices.size(); i++) {
                System.out.println(vertices.get(i).id + " D:" + vertices.get(i).discover + " F:" + vertices.get(i).finish);
            }

            System.out.println();

    }

    public static void makeGraph(ArrayList<Vertex> makeGraph, String fileName)throws java.io.IOException{
        File input = new File(fileName);
        String line;
        BufferedReader br = null;

        try{
            br = new BufferedReader(new FileReader((input)));
        }catch(Exception e){
            return;
        }

        while((line = br.readLine()) != null){
            ArrayList<Integer>  fileList = new ArrayList<>();
            Scanner fin = new Scanner(line);
            String[] tempArr = line.split("[\\s\\:]+");
            Vertex temp1 = new Vertex();
            temp1.id = Integer.parseInt(tempArr[0]);
            for(int i = 1; i < tempArr.length; i++){
                temp1.neighbors.add(Integer.parseInt(tempArr[i]));
            }
            makeGraph.add(temp1);
        }
    }
}

