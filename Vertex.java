/*
 * Sean Gorham Project 3
 * CS 340 3/6/19
 */
package dfs;
import java.util.*;

public class Vertex {
    int id;
    String color;
    int parent;
    int discover;
    int finish;
    ArrayList<Integer> neighbors = new ArrayList<>();
    public Vertex(){
        id = Integer.MAX_VALUE;
        color = null;
        parent = Integer.MAX_VALUE;
        discover = finish = Integer.MAX_VALUE;
    }

}

