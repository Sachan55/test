import javafx.util.Pair;

import java.util.Stack;

public class MaximuAreaRectangle {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Pair<Integer,Integer>> st = new Stack<>();
        for(int i = 0; i < heights.length; i++){
            if(st.empty()){
                st.push(new Pair<>(heights[i], i));
            }else{
                if(heights[i] > st.peek().getKey()){
                    st.push(new Pair<>(heights[i], i));
                }else{
                    int index = i;
                    while(!st.empty() && st.peek().getKey() > heights[i]){
                        Pair<Integer,Integer> top = st.peek();
                        maxArea = Math.max(maxArea, top.getKey() * (i- top.getValue()));
                        st.pop();
                        index = top.getValue();
                    }
                    st.push(new Pair<>(heights[i], index));
                }
            }
        }
        while(!st.empty()){
            Pair<Integer,Integer> top = st.peek();
            maxArea = Math.max(maxArea, top.getKey() * (heights.length - top.getValue()));
            st.pop();
        }

        return maxArea;
    }
}
