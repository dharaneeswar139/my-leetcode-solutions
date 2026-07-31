class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode temp = head;int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        int mid = 0;
        if(len%2==0) mid = len/2;
        else mid = (len-1)/2;
        ListNode prev = null,curr = head;
        for(int i=0;i<mid;i++){
            prev = curr;
            curr = curr.next;
        }
        if(prev != null) prev.next = curr.next;
        return head;
    }
}