import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class print{
    <T> void printArray(ArrayList<T> a){
        for(int i = 0; i < a.size(); i++){
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
    }

    <T> void printArray(int a[][]){
        for(int i = 0; i < a.length; i++){
            for(int j =0 ; j < a[i].length ; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }

    <T> void printArray(ArrayList<Integer> a []){
        for(int i = 0; i < a.length; i++){
            for(int j =0 ; j < a[i].size() ; j++)
                System.out.print(a[i].get(j) + " ");
            System.out.println();
        }
    }
}
public class ArrayListRevisit {
    public static void main(String[] args) {
        print p = new print();
        // initialize a array
        int [] array = new int[] {1,2,3};
        ArrayList<Integer> oneDimensionalArray = new ArrayList(Arrays.asList(1,2,3));
        p.printArray(oneDimensionalArray);
        System.out.println("Removing element at given position");
        oneDimensionalArray.remove(1);
        p.printArray(oneDimensionalArray);
        System.out.println("Sorting array");
        Collections.sort(oneDimensionalArray, (a,b) -> {
            return b.compareTo(a);
        });
        p.printArray(oneDimensionalArray);
        int [][] twoDimensionalArray = new int[5][5];
        p.printArray(twoDimensionalArray);

        // create adjList
        ArrayList<ArrayList<Integer>> arrayListArrayList = new ArrayList<>();
        ArrayList<Integer>[] adj = new ArrayList[3];
        adj[0] = new ArrayList<>(Arrays.asList(1));
        adj[1] = new ArrayList<>(Arrays.asList(1));
        adj[2] = new ArrayList<>(Arrays.asList(1));
        p.printArray(adj);
    }
}
