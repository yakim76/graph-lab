package org.example;

import java.util.*;

public class DepthFirst {
    private static final Map<String, String[]> GRPAPH = Map.of(
            "a", new String[]{"c", "b"},
            "b", new String[]{"d"},
            "c", new String[]{"e"},
            "d", new String[]{"f"},
            "e", new String[0],
            "f", new String[0]
    );

    public static void main(String[] args) {
        System.out.println("depthFirst iterative");
        depthFirst(GRPAPH, "a");
        System.out.println("depthFirst recursive");
        depthFirstR(GRPAPH, "a");
        System.out.println("breadthFirst recursive");
        breadthFirst(GRPAPH, "a");
    }

    private static void depthFirst(Map<String, String[]> graph, String source) {
        Deque<String> stack = new LinkedList<>();
        stack.push(source);
        while (!stack.isEmpty()) {
            String current = stack.pop();
            System.out.println("current = " + current);
            for (String neighbor : graph.get(current)) {
                stack.push(neighbor);
            }
        }
    }

    private static void depthFirstR(Map<String, String[]> graph, String current) {
        System.out.println("current = " + current);
        for (String neighbor : graph.get(current)) {
            depthFirstR(graph, neighbor);
        }
    }

    private static void breadthFirst(Map<String, String[]> graph, String source){
        Queue<String> queue = new LinkedList<>(Collections.singleton(source));
        while (!queue.isEmpty()){
            String current = queue.poll();
            System.out.println("current = " + current);
            queue.addAll(Arrays.asList(graph.get(current)));
        }
    }
}
