package moreAlgorithms;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class lessColor {

	
	public static ArrayList<Integer>[]coloredGraph(ArrayList<Integer>[] graph){
		int size = graph.length;
		int[] dist = new int[size], pred = new int[size], color = new int[size];
		int partitions[] = new int[size];
		int WHITE=1, GRAY=2,  BLACK=3, NIL = -1;
		for (int i = 0; i < size; i++) {
			partitions[i] = 0;
			dist[i] = NIL;
			pred[i] = NIL;
			color[i] = WHITE;
		}
		int s = 0;//source vertex
		dist[s] = 0;
		color[s] = GRAY;
		partitions[s] = 1;
		ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(size);
		q.add(s);
		while(!q.isEmpty()){
			int u = q.poll();//Retrieves and removes the head of this queue, or returns null if this queue is empty
			for(int v : graph[u]){
				if (color[v] == WHITE){
					dist[v] = dist[u]+1;
					pred[v] = u;
					color[v] = GRAY;
					partitions[v] = 3 - partitions[u];
					q.add(v);
				}
			}
			color[u] = BLACK;
		}
		ArrayList<Integer>[] ans = new ArrayList[2];
		ans[0] = new ArrayList<Integer>();
		ans[1] = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			if(partitions[i] == 1){
				ans[0].add(i);
			} else {
				ans[1].add(i);
			}
		}
		return ans;
	}
}
