import java.io.*;
import java.util.*;

public class BP {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Map<String, List<String>> adjList = new HashMap<>();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.contains("->")) {
                String[] nodes = line.split("->");
                String from = nodes[0];
                String to = nodes[1];
                if (!adjList.containsKey(from)) {
                    adjList.put(from, new ArrayList<>());
                }
                adjList.get(from).add(to);
            } else if (line.contains(",")) {
                String[] nodes = line.split(",");
                List<String> nodeList = Arrays.asList(nodes);
                boolean commonNodeFound = false;
                Map<String,String> mp  = new HashMap<>();
                for (int i = 0; i < nodeList.size(); i++) {
                    Set<String> visited = new HashSet<>();
                    String start = nodeList.get(i);
                    visited.add(start);
                    if(mp.containsKey(start)){
                        commonNodeFound = true;
                        break;
                    }
                    mp.put(start,start);
                    Queue<String> queue = new LinkedList<>();
                    queue.add(start);
                    while (!queue.isEmpty()) {
                        String node = queue.poll();
                        if(mp.containsKey(node) && mp.get(node) != start){
                            commonNodeFound = true;
                            break;
                        }
                        for (String neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                            if(mp.containsKey(neighbor) && mp.get(neighbor) != start){
                                commonNodeFound = true;
                                break;
                            }
                            if (!visited.contains(neighbor)) {
                                visited.add(neighbor);
                                mp.put(neighbor,start);
                                queue.add(neighbor);
                            } else {
                                throw new RuntimeException("Cycle found!");
                            }
                        }
                    }
                }
                System.out.println(commonNodeFound);
            }
        }

        bufferedReader.close();
    }
}
