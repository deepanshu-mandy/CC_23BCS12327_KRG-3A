import java.util.*;

public class Main 
{
    public static void main(String[] args) 
    {
        int V = 3;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new int[]{5, 1});
        adj.get(1).add(new int[]{5, 0});

        adj.get(1).add(new int[]{3, 2});
        adj.get(2).add(new int[]{3, 1});

        adj.get(0).add(new int[]{1, 2});
        adj.get(2).add(new int[]{1, 0});

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] mst = new boolean[V];

        pq.add(new int[]{0, 0});
        int tw = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int wt = cur[0];
            int u = cur[1];

            if (mst[u]) continue;

            mst[u] = true;
            tw += wt;

            for (int[] edge : adj.get(u)) {
                int w = edge[0];
                int v = edge[1];

                if (!mst[v]) {
                    pq.add(new int[]{w, v});
                }
            }
        }

        System.out.println("MST weight: " + tw);
    }
}
