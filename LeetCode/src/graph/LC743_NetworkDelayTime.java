package graph;

import java.util.*;

/**
 *
 * You are given a network of n nodes, labeled from 1 to n. You are also given times,
 * a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node,
 * and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal, return -1.
 *
 * https://leetcode.com/problems/network-delay-time/description/
 */
public class LC743_NetworkDelayTime {

    private Map<Integer,List<int[]>> adj = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {

        for(int[] time : times){

            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];

            if(!adj.containsKey(source)) adj.put(source, new ArrayList<>());

            adj.get(source).add(new int[]{dest, travelTime});
        }

        for(int key : adj.keySet()){

            adj.get(key).sort((a, b) -> a[0] - b[0]);
        }

        int[] signalReceivedAt = new int[n+1];

        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        dfs(signalReceivedAt, k, 0);

        int result = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++){

            if (signalReceivedAt[i] == Integer.MAX_VALUE) return -1;
            result = Math.max(result, signalReceivedAt[i]);
        }

        return result;
    }

    void dfs(int[] signalReceivedAt, int currNode, int currTime){

        if(signalReceivedAt[currNode] <= currTime) return;

        signalReceivedAt[currNode] = currTime;

        if(!adj.containsKey(currNode)) return;

        for(int[] pair :adj.get(currNode)){

            int dest = pair[0];
            int travel = pair[1];

            dfs(signalReceivedAt, dest, travel+currTime);
        }
    }



}
