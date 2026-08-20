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

 // Basic Approach
// class Solution {
//     public ListNode middleNode(ListNode head) {
//         int n = 0;
//         ListNode temp = head;
//         while(temp != null) {
//             n++;            
//             temp = temp.next;
//         }
//         int t = n/2;
//         temp = head;
//         for(int i = 0; i < t; ++i) {
//             temp = temp.next;
//         }
//         return temp;
//     }
// }

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}