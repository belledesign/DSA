import java.util.*;
import java.io.*;

class Prims
{
    public void prims(int[][] graph)
    {
        int len1=graph.length;
        boolean[] visited=new boolean[len1];
        int curEdge=0;
        Arrays.fill(visited,false);

        while(curEdge<len1-1)
        {
            int mini=Integer.MAX_VALUE;
            int row=0;
            int col=0;

            for(int i=0;i<len1;i++)
            {
                if(visited[i])
                {
                    for(int j=0;j<len1;j++)
                    {
                        if(!visited[j]&&graph[i][j]!=0&&mini>graph[i][j])
                        {
                            mini=graph[i][j];
                            row=i;
                            col=j;
                        }
                    }
                }
            }
            System.out.println(row+" "+col+" "+graph[row][col]);
            visited[col]=true; 
            curEdge++;
        }
    }
}
class DriverPrims
{
    public static void main(String[] zima)
    {
        Prims pri1=new Prims();
        int[][] graph = {   { 0, 9, 75, 0, 0 }, 
                            { 9, 0, 95, 19, 42 }, 
                            { 75, 95, 0, 51, 66 }, 
                            { 0, 19, 51, 0, 31 },
                            { 0, 42, 66, 31, 0 } 
                        };
        pri1.prims(graph);
    }
}