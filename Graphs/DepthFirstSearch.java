import java.util.*;

class Graph
{
    List<ArrayList<Integer>> adjacent;
    List<Boolean> visited;

    Graph(int m1)
    {
        adjacent=new ArrayList<>();
        visited=new ArrayList<>();

        for(int i=0;i<m1;i++)
        {
            adjacent.add(new ArrayList<>());
        }
        for(int i=0;i<m1;i++)
        {
            visited.add(false);
        }
    }
    void addEdge(int m1,int m2)
    {
        this.adjacent.get(m1).add(m2);
        this.adjacent.get(m2).add(m1);
    }
    void dfs(int m1)
    {
        Stack<Integer> sta1=new Stack<>();
        sta1.push(m1);
        visited.set(m1,true);
        
        while(!sta1.isEmpty())
        {
            int temp1=sta1.peek();
            sta1.pop();
            System.out.print(temp1+" ");

            for(int i=0;i<adjacent.get(temp1).size();i++)
            {
                if(!visited.get(adjacent.get(temp1).get(i)))
                {
                    sta1.push(adjacent.get(temp1).get(i));
                    visited.set(adjacent.get(temp1).get(i),true);
                }
            }
        }
        for(int i=0;i<m1;i++)
        {
            visited.set(i,false);
        }
    }
}
class DriverDFS
{
    public static void main(String[] zima)
    {
        Scanner sc1=new Scanner(System.in);
        int m1=sc1.nextInt();
        int m2=sc1.nextInt();
        Graph gra1=new Graph(m1);

        for(int i=0;i<m2;i++)
        {
            int temp1=sc1.nextInt();
            int temp2=sc1.nextInt();
            gra1.addEdge(temp1,temp2);
        }
        gra1.dfs(0);
        sc1.close();
    }
}
