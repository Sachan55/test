import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Solution {
    public Node copyRandomList(Node head) {
            Node start = head;
            Node dummy = new Node(0);
            Node newHead = dummy;
            Map<Node,Node> oldToNewNodeMapping  = new HashMap<>();
            while(start != null){
                Node temp = new Node(start.val);
                oldToNewNodeMapping.put(start,temp);
                newHead.next = temp;
                start = start.next;
                newHead = newHead.next;
            }

            start = head;
            while (start != null){
                Node random = start.random;
                oldToNewNodeMapping.get(start).random = oldToNewNodeMapping.get(random);
                start = start.next;
            }

            return dummy.next;
    }
}