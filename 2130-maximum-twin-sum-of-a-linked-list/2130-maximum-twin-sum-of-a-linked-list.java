class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow;
        ListNode prev = null;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

        }
        ListNode left = head;
        ListNode right = prev;
        int max = 0;
        while(left!=null && right!=null){
            int sum = left.val + right.val;
            max = Math.max(max, sum);
            left = left.next;
            right = right.next; 
        }
        return max;
    }
}