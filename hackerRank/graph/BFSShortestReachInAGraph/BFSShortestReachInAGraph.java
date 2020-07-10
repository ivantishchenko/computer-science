package main;

import lib.io.InputReader;
import lib.io.OutputWriter;

import java.util.*;

public class BFSShortestReachInAGraph {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int numNodes = in.nextInt();
            Graph graph = new Graph(numNodes);
            int numEdges = in.nextInt();
            for (int j = 0; j < numEdges; j++) {
                int u = in.nextInt();
                int v = in.nextInt();
                graph.addEdge(u, v);
            }
            int startIdx = in.nextInt() - 1;
            int[] res = graph.shortestReach(startIdx);
            for (int j = 0; j < res.length; j++) {
                if(j != startIdx) out.print(res[j] + " ");
            }
            out.println();
        }
    }

    public class Graph {
        public List<List<Integer>> nodes;

        public Graph(int size) {
            nodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                nodes.add(new ArrayList<>());
            }
        }

        public void addEdge(int first, int second) {
            nodes.get(first - 1).add(second - 1);
            nodes.get(second - 1).add(first - 1);
        }

        private void bfs(int startNode, int[] distances) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(startNode);
            distances[startNode] = 0;
            while (!q.isEmpty()) {
                int currNode = q.poll();
                for (int n : nodes.get(currNode)) {
                    if (distances[n] == -1) {
                        q.offer(n);
                        distances[n] = distances[currNode] + 6;
                    }
                }
            }
        }

        public int[] shortestReach(int startId) {
            int[] res = new int[nodes.size()];
            Arrays.fill(res, -1);
            bfs(startId, res);
            return res;
        }

    }

}