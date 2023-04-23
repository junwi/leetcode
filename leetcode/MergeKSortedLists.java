/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        int k = lists.size();
        ListNode[] heap = new ListNode[k];
        int size = 0;
        for (ListNode list : lists) {
            if (list == null) continue;
            int current = size;
            heap[size++] = list;
            while (current > 0) {
                int parent = (current - 1) / 2;
                if (heap[parent].val > heap[current].val) {
                    ListNode t = heap[parent];
                    heap[parent] = heap[current];
                    heap[current] = t;
                    current = parent;
                } else {
                    break;
                }
            }
        }
        ListNode result = null;
        ListNode node = null;
        while (size > 0) {
            if (result == null) {
                result = heap[0];
                node = result;
            } else {
                node.next = heap[0];
                node = heap[0];
            }
            heap[0] = heap[0].next;
            if (heap[0] == null) {
                --size;
                if (size == 0) break;
                heap[0] = heap[size];
            }
            int current = 0;
            while (current < size - 1) {
                int left = current + current + 1;
                int right = current + current + 2;
                int min = current;
                if (left < size && heap[min].val > heap[left].val) min = left;
                if (right < size && heap[min].val > heap[right].val) min = right;
                if (min == current) break;
                ListNode t = heap[current];
                heap[current] = heap[min];
                heap[min] = t;
                current = min;
            }
        }
        
        return result;
    }
}
