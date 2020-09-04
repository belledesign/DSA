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
    void bfs(int m1)
    {
        Queue<Integer> que1=new LinkedList<>();
        que1.offer(m1);
        visited.set(m1,true);

        while(!que1.isEmpty())
        {
            int temp1=que1.peek();
            que1.poll();
            System.out.print(temp1+" ");

            for(int i=0;i<adjacent.get(temp1).size();i++)
            {
                if(!visited.get(adjacent.get(temp1).get(i)))
                {
                    que1.offer(adjacent.get(temp1).get(i));
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
class DriverBFS
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
        gra1.bfs(0);
        sc1.close();
    }
}
