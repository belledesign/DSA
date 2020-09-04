import java.util.*;

class Graph
{
    int ver;
    int edg;
    Edge edges[];
    
    class Edge
    {
        int sou;
        int des;
    }
    Graph(int m1,int m2)
    {
        ver=m1;
        edg=m2;
        edges=new Edge[edg];
        for(int i=0;i<edg;i++)
        {
            edges[i]=new Edge();
        }
    }
    int findSet(int parent[],int m1)
    {
        if(parent[m1]==-1)
            return m1;
        return findSet(parent,parent[m1]);
    }
    void unionSet(int[] parent,int m1,int m2)
    {
        int set1=findSet(parent,m1);
        int set2=findSet(parent,m2);
        parent[set1]=set2;
    }
    boolean detectCycle(Graph gra1)
    {
        int[] parent=new int[gra1.ver];
        Arrays.fill(parent,-1);

        for(int i=0;i<gra1.edg;i++)
        {
            int souPar=gra1.findSet(parent,gra1.edge[i].sou);
            int desPar=gra1.findSet(parent,gra1.edge[i].des);

            if(souPar==desPar)  
                return true;
            gra1.unionSet(parent,souPar,desPar);
        }
        return false;
    }
}
class DriverCycle
{
    public static void main(String[] zima)
    {
        int m1=3;
        int m2=3; 
        Graph gra1 = new Graph(m1,m2); 
  
        gra1.edge[0].sou=0; 
        gra1.edge[0].des=1; 
  
        gra1.edge[1].sou=1; 
        gra1.edge[1].des=2; 
  
        gra1.edge[2].sou=0; 
        gra1.edge[2].des=2; 
  
        if (graph.isCycle(graph)) 
            System.out.println("graph contains cycle"); 
        else
            System.out.println("graph doesn't contain cycle"); 

    }
}
