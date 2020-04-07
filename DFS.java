/*
 * Sean Gorham Project 3
 * CS 340 3/6/19
 */
package dfs;

import java.util.*;

public class DFS {

    int stackTop = 0;
    int time;
    ArrayList<BackEdge> backEdges = new ArrayList<>();
//    LinkedList<Vertex> topologicalSort = new LinkedList<>();
    Vertex[] vertexStack = new Vertex[9];

    public void search(ArrayList<Vertex> graph){
        for(int i = 0; i < graph.size(); i++){
            graph.get(i).color = "white";
            graph.get(i).parent = Integer.MAX_VALUE;
        }
        time = 0;
        for(int i = 0; i < graph.size(); i++){
            if(graph.get(i).color.equals("white")){
                visit(graph, graph.get(i));
            }
        }
    }

    public void visit(ArrayList<Vertex> graph, Vertex thisVertex){
        time = time+ 1;
        thisVertex.discover = time;
        thisVertex.color = "grey";
        if(backEdges.isEmpty()){push(thisVertex);}
        for(int i = 0; i < thisVertex.neighbors.size(); i++){
            if(graph.get(thisVertex.neighbors.get(i)-1).color.equals("white")){
                graph.get(thisVertex.neighbors.get(i)-1).parent = thisVertex.id;
                visit(graph, graph.get(thisVertex.neighbors.get(i)-1));
            }
            if(graph.get((thisVertex.neighbors.get(i)-1)).color.equals("grey")){
                BackEdge temp = new BackEdge();
                temp.vertexParent = thisVertex.id;
                temp.vertexToDiscover = thisVertex.neighbors.get(i);
                backEdges.add(temp);
            }
        }
        thisVertex.color = "black";
        time = time + 1;
        thisVertex.finish = time;
        //pop();
    }

    public void topSort(){
        System.out.println("Here is the topological sort of the graph");
        for(int i = 0; i < vertexStack.length; i++){
           System.out.print(vertexStack[i].id + " " );
        }
        System.out.println();
    }

    public void checkCycle(){
        if(backEdges.isEmpty()){
            System.out.println("This is an acyclic graph and will be topologically sorted");
            topSort();

        }else{
            System.out.println("This graph contains one or more cycles");
            System.out.println("The back edges of this graph are :");
            for(int i = 0; i < backEdges.size(); i ++){
                System.out.println(backEdges.get(i).vertexParent + " to " + backEdges.get(i).vertexToDiscover);
            }
        }
    }
    public void pop(){
        if(stackEmpty() == true){
            System.err.println("Stack underflow");
        }
        stackTop = stackTop - 1;
    }
    public boolean stackEmpty(){
        if(stackTop == 0){
            return true;
        }
        return false;
    }
    public void push(Vertex toAdd){
        vertexStack[stackTop] = toAdd;
        stackTop = stackTop + 1;
    }
}